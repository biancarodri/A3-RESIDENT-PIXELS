package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

import java.awt.Color;
import java.awt.event.MouseEvent;

public class PauseMenu {

    private Window janela;
    private Keyboard teclado;
    private String[] opcoes = {"Continuar", "Salvar", "Sair"};
    private int selecionado = 0;

    public PauseMenu(Window janela) {
        this.janela = janela;
        this.teclado = janela.getKeyboard();
    }

    // Exibe o menu de pausa e retorna true para continuar ou false para sair
    public boolean mostrar() {
        while (true) {
            janela.clear(Color.BLACK);
            janela.drawText("JOGO PAUSADO", 300, 150, Color.WHITE);
            janela.update();

            if (teclado.keyDown(27)) {
                while (teclado.keyDown(27)) janela.delay(100);
                return true; // continuar o jogo
            }


            
            for (int i = 0; i < opcoes.length; i++) {
                Color cor = (i == selecionado) ? Color.YELLOW : Color.WHITE;
                janela.drawText(opcoes[i], 300, 250 + i * 40, cor);
            }

            janela.update();

            if (teclado.keyDown(Keyboard.DOWN_KEY)) {
                selecionado = (selecionado + 1) % opcoes.length;
                esperarSoltarTecla(Keyboard.DOWN_KEY);
            }

            if (teclado.keyDown(Keyboard.UP_KEY)) {
                selecionado = (selecionado - 1 + opcoes.length) % opcoes.length;
                esperarSoltarTecla(Keyboard.UP_KEY);
            }

            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                esperarSoltarTecla(Keyboard.ENTER_KEY);
                return tratarOpcaoSelecionada();
            }

            

            janela.delay(100);
        }
    }

    private boolean tratarOpcaoSelecionada() {
        switch (selecionado) {
            case 0: // Continuar
                return true;
            case 1: // Salvar
                // Implementar lógica de salvar
                return true;
            case 2: // Sair
                return false;
            default:
                return true;
        }
    }

    private void esperarSoltarTecla(int tecla) {
        while (teclado.keyDown(tecla)) {
            janela.delay(100);
        }
    }
}

        
    


