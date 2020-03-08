/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author fredr
 */
public class GameScreen extends ScreenAdapter{

    private SpriteBatch batch;
    private Player player;
    private MageEnemy mage;
    
    public GameScreen(SpriteBatch batch){
        this.batch = batch;
        player = new Player();
        mage = new MageEnemy(player);
    }
    
    @Override
    public void show(){
        
    }
    
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        player.update(delta);
        mage.update(delta);

        batch.begin();;

        player.render(batch);
        mage.render(batch);

        batch.end();

    }

    @Override
    public void dispose() {

    }
    
}
