/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 *
 * @author Johan
 */
public class Player extends Sprite {
    private float speed;
    private int health;
    

    
    public Player(Texture texture,int xpos, int ypos, int sp, int hp){
        super(texture);
        super.setPosition(xpos,ypos);
        health = hp;
        speed = sp; 
    }
}
