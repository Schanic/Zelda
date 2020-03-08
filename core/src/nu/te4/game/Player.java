/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;



/**
 *
 * @author Johan
 */
public class Player implements Entity{
    private Vector2 playerPos;
    private Texture player;
    
    public Player(){
        player = new Texture(Gdx.files.internal("Link.png"));
        playerPos = new Vector2(640 / 2 - 32, 0);
    }
    
    
    @Override
    public void render(SpriteBatch batch){
        batch.draw(player, playerPos.x, playerPos.y ,32, 32);
    }
    @Override
    public void update(float delta){
        move(delta);
    }
    
    private void move(float delta) { 
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            playerPos.y += 2.5f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            playerPos.x += 2.5f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            playerPos.y -= 2.5f;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            playerPos.x -= 2.5f;
        }
        
        
    }
    public Vector2 getPos(){
         return playerPos;   
        }
}
