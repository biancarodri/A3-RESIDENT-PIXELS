/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

import java.awt.Color;

public class PauseMenu {

    private Window janela;
    private Keyboard teclado;

    public PauseMenu(Window janela) {
        this.janela = janela;
        this.teclado = janela.getKeyboard();
    }

    // Exibe o menu de pausa e retorna true para continuar ou false para sair
    public boolean mostrar() {
        while (true) {
            janela.clear(Color.BLACK);
            janela.drawText("JOGO PAUSADO", 300, 150, Color.WHITE);
            janela.drawText("1 - Continuar", 300, 250, Color.WHITE);
            janela.drawText("2 - Parar e voltar ao menu", 300, 300, Color.WHITE);
            janela.update();

            if (teclado.keyDown(27)) {
                while (teclado.keyDown(27)) janela.delay(100);
                return true; // continuar o jogo
            }

            if (teclado.keyDown(27)) {
                while (teclado.keyDown(27)) janela.delay(100); 
                return false; // encerrar o cenário
            }
        }
    }
}

