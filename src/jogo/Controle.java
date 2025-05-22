/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import jplay.GameObject;
import jplay.TileInfo;

/**
 *
 * @author isaac
 */
public class Controle {
    
    public boolean colisao(GameObject obj, TileInfo tile){
       if((tile.id>=7)&& obj.collided(tile)){
           return true;
       }
       return false;   
    }
    
}
