package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.FontMetrics;
import java.io.File;
import java.io.IOException;

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
        Font fonteTitulo, fonteOpcoes;
        try {
            Font fonteBase = Font.createFont(Font.TRUETYPE_FONT, new File("src/recursos/FONT/PressStart2P-Regular.ttf"));
            fonteTitulo = fonteBase.deriveFont(Font.BOLD, 28f);
            fonteOpcoes = fonteBase.deriveFont(Font.PLAIN, 18f);
        } catch (FontFormatException | IOException e) {
            fonteTitulo = new Font("Arial", Font.BOLD, 28);
            fonteOpcoes = new Font("Arial", Font.PLAIN, 18);
            System.out.println("Erro ao carregar fonte personalizada. Usando fonte padrão.");
        }

        Graphics g = janela.getGraphics();
        FontMetrics fmTitulo = g.getFontMetrics(fonteTitulo);
        FontMetrics fmOpcoes = g.getFontMetrics(fonteOpcoes);

        while (true) {
            janela.clear(Color.BLACK);

            // Centralizar título com sombra
            String titulo = "JOGO PAUSADO";
            int larguraTitulo = fmTitulo.stringWidth(titulo);
            int xTitulo = (janela.getWidth() - larguraTitulo) / 2;
            janela.drawText(titulo, xTitulo + 2, 152, Color.DARK_GRAY, fonteTitulo); // sombra
            janela.drawText(titulo, xTitulo, 150, Color.WHITE, fonteTitulo);         // principal

            // Centralizar opções com sombra
            for (int i = 0; i < opcoes.length; i++) {
                String texto = opcoes[i];
                int y = 250 + i * 50;
                int larguraTexto = fmOpcoes.stringWidth(texto);
                int xTexto = (janela.getWidth() - larguraTexto) / 2;
                Color cor = (i == selecionado) ? Color.YELLOW : Color.WHITE;

                janela.drawText(texto, xTexto + 2, y + 2, Color.DARK_GRAY, fonteOpcoes); // sombra
                janela.drawText(texto, xTexto, y, cor, fonteOpcoes);                     // principal
            }

            janela.update();

            if (teclado.keyDown(27)) {
                while (teclado.keyDown(27)) janela.delay(100);
                return true; // continuar o jogo
            }

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