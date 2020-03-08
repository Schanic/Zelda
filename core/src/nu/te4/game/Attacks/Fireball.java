/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.game.Attacks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author fredr
 */
public class Fireball {
    private Texture t;
    private Vector2 pos;
    private Vector2 target;
    private boolean out;
    private float time;
    
    public Fireball(Vector2 pos){
        this.pos = pos;
        t = new Texture(Gdx.files.internal("Link.png"));
        out = false;
        target = new Vector2();
        time = 0;
    }
    
    public void render(SpriteBatch batch){
        if(out){
            batch.draw(t, pos.x, pos.y, 24,24);
        }
        
    }
    
    
    public void update(float delta){
        time += delta;
        
        double angle = Math.atan2(target.y - pos.y, target.x - pos.x);
        pos.x += 4 * Math.cos(angle);
        pos.y += 4 * Math.sin(angle);
        if(time >= 0.5f){
            out = false;
            time = 0;
        }
    }
    
    public void setOut(){
        out = true;
    }
    public boolean getOut(){
        return out;
    }
    public void setPos(Vector2 pos){
        this.pos = pos;
    }
    public void setTarget(Vector2 target){
        this.target = target;
    }
}
