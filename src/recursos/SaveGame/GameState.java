package recursos.SaveGame;

import java.time.LocalTime;

public class GameState {

    private String localizacao;
    private int vida;
    private LocalTime tempoDeJogo;

    public GameState (String localizacao, int vida, java.time.LocalTime tempoDeJogo) {
        this.localizacao = localizacao;
        this.vida = vida;
        this.tempoDeJogo = tempoDeJogo;
    }
    //Getters
    public String getLocalizacao() {
        return localizacao;
    }
    public int getVida() {
        return vida;
    }
    public LocalTime gettempoDeJogo() {
        return tempoDeJogo;
    }


}

