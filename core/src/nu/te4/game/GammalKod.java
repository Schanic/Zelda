/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 *
 * @author fredr
 */
public class GammalKod { /*
    package nu.te4.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Start extends ApplicationAdapter {

    private SpriteBatch batch;
    Texture img;
    private Player player;

    public Animation<TextureRegion> runningAnimation;

    private static final int FRAME_COLS = 6, FRAME_ROWS = 5;
    Animation<TextureRegion> walkAnimation;
    Texture walksheet;
    SpriteBatch spriteBatch;

    float stateTime;

    @Override
    public void create() {
        FileHandle playerFile = Gdx.files.internal("Link.png");
        batch = new SpriteBatch();
        player = new Player(new Texture(playerFile), 20, 20, 20, 20);
        walksheet = new Texture(Gdx.files.internal("animations_link.png"));

        TextureRegion[][] tmp = TextureRegion.split(walksheet,
                walksheet.getWidth() / FRAME_COLS,
                walksheet.getHeight() / FRAME_ROWS);

        TextureRegion[] walkframes = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkframes[index++] = tmp[i][j];
            }
        }

        walkAnimation = new Animation<TextureRegion>(0.025f, walkframes);

        spriteBatch = new SpriteBatch();
        stateTime = 0f;
    }

    

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear screen
        stateTime += Gdx.graphics.getDeltaTime(); // Accumulate elapsed animation time
        TextureRegion currentFrame = walkAnimation.getKeyFrame(stateTime, true);
        
        //move();
        batch.begin();
        player.draw(batch);
        batch.draw(currentFrame, 50, 50);  // Positionen av bilden
        batch.end();
        
 
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        spriteBatch.dispose();
        walksheet.dispose();
    }
}
*/
}
