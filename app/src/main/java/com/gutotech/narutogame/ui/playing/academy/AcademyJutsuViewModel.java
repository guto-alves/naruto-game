package com.gutotech.narutogame.ui.playing.academy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.gutotech.narutogame.data.model.CharOn;
import com.gutotech.narutogame.data.model.Classe;
import com.gutotech.narutogame.data.model.Jutsu;

import java.util.ArrayList;
import java.util.List;

public class AcademyJutsuViewModel extends ViewModel {
    private MutableLiveData<List<Jutsu>> mJutsus = new MutableLiveData<>();

    private Classe mClasseSelected;

    public AcademyJutsuViewModel() {
        mClasseSelected = CharOn.character.getClasse();
    }

    public LiveData<List<Jutsu>> getJutsus() {
        return mJutsus;
    }

    public void onClassButtonPressed(Classe classe) {
        mClasseSelected = classe;
    }

    private List<Jutsu> jutsusList = new ArrayList<>();

    private void loadJutsus() {

    }

    private void carregarTaijutsus() {
        jutsusList.add(new Jutsu("Dynamic Kick", "chute_dinamico", "Um chute fortíssimo, capaz de esmagar uma pedra.",
                1, 16, 0, 0, 6, 2, 5, 32,
                "atk", "tai"));

        jutsusList.add(new Jutsu("Hariitsuba ", "agulhas_sopranas", "Expele agulhas escondidas em sua boca",
                1, 29, 0, 0, 6, 2, 11, 59,
                "atk", "tai"));
    }

    private void carregarNinjutsus() {
        jutsusList.add(new Jutsu("Henge no Jutsu", "transformacao", "Jutsu de cópia, o usuário utiliza esse jutsu para copiar qualquer coisa (pessoas, objetos etc..) e assim utilizar desse método para atacar o oponente que fica distraído.",
                1, 0, 16, 0, 6, 2, 32, 5,
                "atk", "nin"));
    }

    private void carregarGenjutsus() {
        jutsusList.add(new Jutsu("Kishibari no Jutsu ", "Kishibari_no_Jutsu", "Esse genjutsu faz ninja sumir por alguns poucos instantes, dando à  sua vítima a idéia de que fora extremamente veloz, enquanto isso ele pode se esconder ou até mesmo atacar o alvo.",
                1, 0, 16, 0, 6, 2, 32, 5,
                "atk", "gen"));
    }

    private void carregarBukijutsus() {
        jutsusList.add(new Jutsu("Soufuushasan no Tachi", "soufuushasan-no-tachi", "O ninja prende shurikens com linhas e as controla para atacar o inimigo.",
                1, 16, 0, 0, 6, 2, 5, 32,
                "atk", "buk"));
    }

}
