const functions = require('firebase-functions');

const admin = require('firebase-admin');
admin.initializeApp();


exports.getTime = functions.https.onCall((data, context) => {
	return Date.now();
});

const MAX_MESSAGES = 300;

exports.limitNumberOfMessages = functions.database.ref('/chats/{villageId}')
	.onWrite(async (change) => {
		const messagesRef = change.after.ref;
		const snapshot = await messagesRef.once('value');
		
		if (snapshot.numChildren() >= MAX_MESSAGES) {
			let childCount = 0;
			const updates = {};
			
			snapshot.forEach((child) => {
			  if (++childCount <= snapshot.numChildren() - MAX_MESSAGES) {
				updates[child.key] = null;
			  }
			});

			return messagesRef.update(updates);
		 }

		return null;
	});
	
exports.formBattle = functions.database.ref('/dojo-random-wait')
	.onWrite(async (change) => {
		const snapshot = change.after;
		const players = snapshot.val();

		var charIds = {};
		let count = 0;

		snapshot.forEach((child) => {
			charIds[count] = child.key;
			count++;
		});

		for(var i = 0; i < count - 1; i++){
			 for(var j = i + 1; j < count; j++){ 
			 	if (players[charIds[i]].playerId === players[charIds[j]].playerId) {
			 		continue;
			 	}

				if(players[charIds[i]].level === players[charIds[j]].level){
					var battle = {
						attackStart: Date.now(),
						currentPlayer: 1,
						id: "test",
						player1: players[charIds[i]],
						player2: players[charIds[j]],	 
						playerCount: 2,
						status: "CONTINUE"
					}

					battle.id = 'DOJO-PVP' + battle.player1.nick + '-' +  battle.player2.nick;

					//battle.id = admin.database().ref('/battles/').push();

					admin.database().ref('/battles/').child(battle.id).set(battle);

					admin.database().ref('/dojo-pvp-ids/')
						.child(battle.player1.id)
						.child('battleId')
						.set(battle.id);

					admin.database().ref('/dojo-pvp-ids/')
						.child(battle.player2.id)
						.child('battleId')
						.set(battle.id);

					snapshot.ref.child(battle.player1.nick).set(null);
					snapshot.ref.child(battle.player2.nick).set(null);
					
					j = count;
					i = count;
				}
			 }
		 }

		return null;
	});