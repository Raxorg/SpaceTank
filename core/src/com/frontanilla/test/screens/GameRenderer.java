package com.frontanilla.test.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.test.Bullet;

public class GameRenderer {

    private GameStuff stuff;
    private SpriteBatch batch;

    public GameRenderer(GameStuff stuff) {
        this.stuff = stuff;
        batch = new SpriteBatch();
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        stuff.getTank().render(batch);
        for (Bullet bullet : stuff.getBullets()) {
            bullet.render(batch);
        }

        batch.end();
    }
}
