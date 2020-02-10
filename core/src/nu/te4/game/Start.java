package nu.te4.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Start extends ApplicationAdapter {
	private SpriteBatch batch;
	Texture img;
	private Player player;
        
        
	@Override
	public void create () {
            FileHandle playerFile = Gdx.files.internal("Link.png");
		batch = new SpriteBatch();
		player = new Player(new Texture(playerFile),20,20,20,20);
	}
        
        void move() { // FIXA DETTA LOGIKEN
        if (Gdx.input.isKeyPressed(Input.Keys.W) ) {
            player.setY(player.getY() + 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            player.setX(player.getX() + 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S) ) {
            player.setY(player.getY() - 5);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            player.setX(player.getX() - 5);
        }
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
                move();
                player.draw(batch);
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
