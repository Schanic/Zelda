/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author fredr
 */
public class Start extends Game {

    private SpriteBatch batch;
    
    private GameScreen screen;
    

    @Override
    public void create() {
        batch = new SpriteBatch();
        screen = new GameScreen(batch);
        setScreen(screen);
    }

    @Override
    public void render() {
        super.render();

    }

    @Override
    public void dispose() {
        super.dispose();
    }

}
