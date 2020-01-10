package com.gutotech.narutogame.ui.loggedin.newcharacteer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.Character;
import com.gutotech.narutogame.data.repository.CharacterRepository;

public class CharacterCreateViewModel extends ViewModel {
    private MutableLiveData<Character> character;

    private CharacterRepository mRepository;

    public CharacterCreateViewModel() {
        mRepository = CharacterRepository.getInstance();
    }

    public LiveData<Character> getCharacter() {
        return character;
    }

    public void createCharacter() {
//        if (isValidNick(nick))
//            verificarNickRepetido(nick);
    }

    private boolean isValidNick(String nick) {
//        if (nick.isEmpty()) {
//            nickEditText.setError("Campo obrigatório");
//            return false;
//        }
//
//        String message = "";
//
//        if (nick.length() > 18)
//            message = "O nome do seu character não pode ter mais de 18 caractéres\n";
//
//        String nickSemPontuacao = nick.replaceAll("(?!_)\\p{P}", "");
//
//        if (!nickSemPontuacao.equals(nick))
//            message += "O nome do seu character só pode conter letras, números e underlines";
//
//        if (message.isEmpty())
//            return true;
//        else {
//            exibirAlerta("Aviso!", "Os seguintes problemas evitaram que a operação fosse completada:\n\n" + message);
//            return false;
        }
    }

//    private void salvarPersonagem(String nick) {
//        character.setIdPlayer(FirebaseConfig.getAuth().getCurrentUser().getUid());
//        character.setNick(nick);
//        character.setLevel(1);
//        character.setGraducao("Estudante");
//        character.setRyous(500);
//        character.setVila(vilaSelecionada);
//        character.setNumVila(numVila);
//        character.setClasse(classeSelecionada);
//        character.setAtributos(atributos);
//        character.setFotoAtual(1);
//        character.setExpUpar(1200);
//        character.setPontos(1000);
//        character.setResumoCombates(new ResumoCombates());
//        character.setResumoMissoes(new ResumoMissoes());
//        character.setMapa_posicao(-1);
//        character.setDiasLogadosFidelidade(1);
//        character.setTemRecompensaFidelidade(true);
//
//        List<Atributo> atributosDistribuidos = new ArrayList<>();
//        atributosDistribuidos.add(new Atributo(Atributo.TAI, R.drawable.layout_icones_ene, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.BUK, R.drawable.layout_icones_ken, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.NIN, R.drawable.layout_icones_nin, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.GEN, R.drawable.layout_icones_gen, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.SELO, R.drawable.layout_icones_conhe, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.AGI, R.drawable.layout_icones_agi, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.FOR, R.drawable.layout_icones_forc, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.INTE, R.drawable.layout_icones_inte, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.ENER, R.drawable.layout_icones_ene, 0));
//        atributosDistribuidos.add(new Atributo(Atributo.RES, R.drawable.layout_icones_defense, 0));
//        character.setAtributosDistribuitos(atributosDistribuidos);
//
//        PersonagemOn.character = character;
//        character.atualizarAtributos();
//        character.getAtributos().getFormulas().setVidaAtual(character.getAtributos().getFormulas().getVida());
//        character.getAtributos().getFormulas().setChakraAtual(character.getAtributos().getFormulas().getChakra());
//        character.getAtributos().getFormulas().setStaminaAtual(character.getAtributos().getFormulas().getStamina());
//
//        List<Jutsu> jutsus = new ArrayList<>();
//        if (character.getClasse().equals(Classe.NIN) || character.getClasse().equals(Classe.GEN)) {
//            jutsus.add(new Jutsu(0, "defesa_2_mao", 1, 0, 0, 5, 0, 3, 10, 3, "def", "basico"));
//            jutsus.add(new Jutsu(1, "defesa_acrobatica", 1, 0, 0, 5, 0, 3, 15, 4, "def", "basico"));
//            jutsus.add(new Jutsu(2, "soco", 1, 0, 5, 0, 0, 3, 8, 1, "atk", "basico"));
//            jutsus.add(new Jutsu(3, "chute", 1, 0, 8, 0, 0, 3, 11, 2, "atk", "basico"));
//        } else {
//            jutsus.add(new Jutsu(0, "defesa_2_mao", 1, 0, 0, 5, 0, 3, 3, 10, "def", "basico"));
//            jutsus.add(new Jutsu(1, "defesa_acrobatica", 1, 0, 0, 5, 0, 3, 4, 15, "def", "basico"));
//            jutsus.add(new Jutsu(2, "soco", 1, 5, 0, 0, 0, 3, 1, 8, "atk", "basico"));
//            jutsus.add(new Jutsu(3, "chute", 1, 8, 0, 0, 0, 3, 2, 11, "atk", "basico"));
//        }
//        character.setJutsus(jutsus);
//
//        Bolsa bolsa = new Bolsa();
//        List<Ramen> ramens = new ArrayList<>();
//        ramens.add(new Ramen("nissin", "Merenda Ninja",
//                "Super macarrão reforçado para uso nos intervalos das tarefas ninjas",
//                25, ItemShop.TipoPgto.RYOUS, 5, 0, 1, 100));
//        bolsa.setRamensList(ramens);
//        character.setBolsa(bolsa);
//
//        character.setOn(false);
//        character.salvar();
//
//        exibirAlerta("NINJA CRIADO COM SUCESSO", "Parabéns você acaba de criar seu character no Naruto Game.\n" +
//                "Selecione seu character e comece agora mesmo seu treinamento");
//    }
}
