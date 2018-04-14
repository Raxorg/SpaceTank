package com.frontanilla.test;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Bullet {

    private Texture base;
    private Vector2 position, velocity;
    private float rotation;

    public Bullet(Vector2 position, float rotation) {
        base = new Texture("pixel.jpg");
        this.position = position.cpy();
        velocity = new Vector2();
        this.rotation = rotation;
        velocity.set(
                MathUtils.cosDeg(rotation),
                MathUtils.sinDeg(rotation)
        );
    }

    public void update() {
        position.add(velocity);
    }

    public void render(SpriteBatch batch) {
        batch.setColor(Color.WHITE);
        batch.draw(
                base,
                position.x,
                position.y,
                Constants.BULLET_SIZE,
                Constants.BULLET_SIZE
        );
    }
}
