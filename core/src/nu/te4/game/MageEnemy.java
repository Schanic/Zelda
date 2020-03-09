/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import java.util.ArrayList;
import java.util.Random;
import nu.te4.game.Attacks.Fireball;

/**
 *
 * @author fredr
 */
public class MageEnemy implements Entity {

    public enum State {TELE, FIRE, CHARGE}

    private Texture tex;
    private Texture tex2;
    private Vector2 magePos;
    private Vector2 mageSize;
    private Vector2 target;
    private ArrayList<Vector2> telePos;
    private Player player;
    private State state;
    private boolean reappear;
    private Random random;
    private Fireball fb;

    public MageEnemy(Player player) {
        this.player = player;
        init();
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(tex, magePos.x, magePos.y, mageSize.x, mageSize.y);
        batch.draw(tex2, 20, 20, mageSize.x, mageSize.y);
        fb.render(batch);
    }
    @Override
    public void update(float delta) {
        switch(state) {
            case TELE:
                tele();
                break;
            case FIRE:
                fire(delta);
                break;
            case CHARGE:
                charge();
                break;
           // default:
        }
    }

    public void chooseState() {
        if (Math.abs(player.getPos().x - magePos.x) > 300 || Math.abs(player.getPos().y - magePos.y) > 300) {
            state = State.CHARGE;
            target.x = player.getPos().x;
            target.y = player.getPos().y;
        } else if (state == State.TELE) {
            state = State.FIRE;
        } else {
            state = State.TELE;
        }
    }

    private void tele() {
        if (!reappear) {
            mageSize.x -= 1;
        } else if (reappear) {
            mageSize.x += 1;
        }
        if (mageSize.x <= 0) {
            reappear = true;
            magePos = chooseNewLocation();
        } else if (mageSize.x > 40) {
            mageSize.x = 40;
            reappear = false;
            chooseState();
        }
    }

    private void charge() {
        double angle = Math.atan2(target.y - magePos.y, target.x - magePos.x);
        magePos.x += 4 * Math.cos(angle);
        magePos.y += 4 * Math.sin(angle);

        if (Math.abs(target.x - magePos.x) < 3 || Math.abs(target.y - magePos.y) < 3) {
            chooseState();
        }
    }

    private void fire(float delta) {
        if (fb.getOut() == false) {
            fb.setPos(new Vector2(magePos.x, magePos.y));
            fb.setOut();
        }
        fb.setTarget(new Vector2(player.getPos().x, player.getPos().y));
        fb.update(delta);

        if (fb.getOut() == false) {
            chooseState();
        }
    }

    public Vector2 chooseNewLocation() {
        int num = random.nextInt(4);

        while (telePos.get(num).x == magePos.x) {
            num = random.nextInt(4);
        }
        return telePos.get(num);
    }

    private void init() {
        tex = new Texture(Gdx.files.internal("Link.png"));
        tex2 = new Texture(Gdx.files.internal("Link.png"));
        magePos = new Vector2(640 / 2 - 40, 480 - 64);
        mageSize = new Vector2(40, 64);
        state = State.TELE;
        telePos = new ArrayList<>();
        telePos.add(new Vector2(640 / 2 - 40, 480 - 100));
        telePos.add(new Vector2(640 / 2 - 40, 480 - 400));
        telePos.add(new Vector2(640 / 2 - 200, 480 - 300));
        telePos.add(new Vector2(640 / 2 + 300, 480 - 200));
        reappear = false;
        random = new Random();
        target = new Vector2();
        fb = new Fireball(new Vector2(640 / 2 - 40, 480 - 64));
    }
}
