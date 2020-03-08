/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author fredr
 */
public interface Entity {

    public void render(SpriteBatch batch);

    public void update(float delta);
}
