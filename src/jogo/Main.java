package jogo;



import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;



public class Main {
    public static void main(String[] args) {
        Window janela = new Window(800, 600);
        GameImage plano = new GameImage(URL.sprite("RESIDENTPIXEL4.png"));
        Keyboard teclado = janela.getKeyboard();
        
        
        while(true){
            plano.draw();
            janela.update();
            
            if(teclado.keyDown(Keyboard.ENTER_KEY)){
                new Cenario1(janela);
            
            
            }
            
        }
        
    }
}
