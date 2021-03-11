<h1 align="center">
  <img  alt="Logo" src="app/src/main/res/mipmap-xxxhdpi/ic_launcher_round.png" />  
</h1>

<h1 align="center">
  Naruto Game  
</h1>

In the game you will be a ninja and your mission is to develop your skills and chart your own ninja path to become Kage!

## Download
<a href="https://naruto-game.en.uptodown.com/android" target="_blank">
  <img src="https://user-images.githubusercontent.com/48946749/80045244-2f095100-84dd-11ea-9152-f25f85fd3351.png"> 
<a/>

## Table of contents
* [Download](#download)
* [Screenshots](#screenshots)
* [Contribute](#contribute)
* [Disclaimer](#disclaimer)

## Screenshots
<p><img src="screenshots/create_character.jpg" height="400"/>
  <img src="screenshots/select_character.jpg" height="400"/>
  <img src="screenshots/nav_header.jpg" height="400"/>
  <img src="screenshots/profiles.jpg" height="400">
  <img src="screenshots/profiles1.jpg" height="400"/>
  <img src="screenshots/profiles2.jpg" height="400"/>
  <img src="screenshots/map_leaf1.jpg" height="400"/>
  <img src="screenshots/map_leaf.jpg" height="400"/>
  <img src="screenshots/map_aka.jpg" height="400"/>
  <img src="screenshots/dojo_pvp.jpg" height="400">
  <img src="screenshots/dojo_npc.jpg" height="400">
  <img src="screenshots/learn_jutsus.jpg" height="400">
  <img src="screenshots/learn_jutsus1.jpg" height="400">
  <img src="screenshots/team.jpg" height="400"/>
  <img src="screenshots/chat.jpg" height="400">
</p>

## Disclaimer
Naruto Game is a game developed by fans for fans (completely free), where players choose from some of the most attractive manga/anime characters to participate online in Naruto RPG adventures with your friends.<br>
Original characters and illustrations © Copyright 2002 by Masashi Kishimoto. All rights reserved

## Contribute
Any contributions to this repository are most welcome.

### Running locally

#### Prerequires
The following items should be installed in your system:

 - git command line tool (https://help.github.com/articles/set-up-git)
 - Android Studio IDE (https://developer.android.com/studio)
 
And you also should have a Firebase Account (https://firebase.google.com)

#### Steps

<ol>
  <li>
    On the command line 
    
    git clone https://github.com/guto-alves/naruto-game.git
  </li>  
  <li>Open the Project in Android Studio</li><br>
  <li>Preparing Firebase
    <ul>
      <br>
      <li>
       Access the Firebase Console and create a new Project. Add it to the cloned Android application. The most important steps in this case to add Firebase to your Android app are the steps <b>Register app</b> and Download config file (<b>google-services.json</b>) because the Firebase SDK and its dependencies have already been added to the build.gradle , if you want, you can just confirm by looking in the build.gradle files.
       <p>
        <img width="300" height="200" src="https://user-images.githubusercontent.com/48946749/110720857-13d72b00-81ee-11eb-9832-f2737c962c78.png">  
        <img height="250" src="https://user-images.githubusercontent.com/48946749/110721199-c60ef280-81ee-11eb-8611-e9ff9c4837e3.png">
      </p>
      </li>
      <li>
        Now still on the Firebase Console, you need to configure
        <ol>
          <br>
          <li>
            <b>Realtime Database</b>
            - Create the Realtime Database and configure it to start in <b>test mode</b> rules. Then, initialize the database with the game status (download <a href="https://github.com/guto-alves/naruto-game/blob/master/game-status.json">game-status.json</a>) and import it into the Realtime Database).
        <p><img height="200" src="https://user-images.githubusercontent.com/48946749/110722164-9bbe3480-81f0-11eb-930c-35c32376280d.png">
        <img height="250" src="https://user-images.githubusercontent.com/48946749/110722387-e93aa180-81f0-11eb-9361-38b1a9968f75.png">
        <img height="200" src="https://user-images.githubusercontent.com/48946749/110722470-138c5f00-81f1-11eb-9802-e3bae458e874.png"></p>
          </li>
          <li>
            <b>Authentication</b> 
            - All you need to do here is to <b>enable the sign-in providers Email/Password and Google</b>, as in the image below:
            <p><img width="800" height="300" src="https://user-images.githubusercontent.com/48946749/110723018-205d8280-81f2-11eb-9655-3fe94a0b0aca.png"></p>
          </li>
          <br>
          <li>
           <b>Storage</b> 
            - Download the folder with the images (https://drive.google.com/drive/folders/1Dr2a00AzU4yEkg6e0RxLrQMUPXkzZEEQ?usp=sharing) and upload it to Firebase Storage. The structure of the folders in the Storage must be the same as the downloaded folder or you will need to change the methods of the <a href="https://github.com/guto-alves/naruto-game/blob/master/app/src/main/java/com/gutotech/narutogame/data/firebase/StorageUtils.java">StorageUtils</a> class to match the paths of the images.
            </p><img src="https://user-images.githubusercontent.com/48946749/110729144-ed6cbc00-81fc-11eb-93b4-957e25e111d4.png">
            <img src="https://user-images.githubusercontent.com/48946749/110732253-979b1280-8202-11eb-8942-5b4abda94eee.png"></p>
          </li>
        </ol>
      </li>
    </ul>
  </li>  
  <br>
  <li>
    That's all. With your emulator or real device connected, just run it.
  </li>
</ol>

## License
This project is licensed under the MIT License - see the [LICENSE](https://github.com/guto-alves/naruto-game/blob/master/LICENSE) file for details.
