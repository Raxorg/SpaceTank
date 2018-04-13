package com.frontanilla.test;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class SpaceTank {

    private float rotation;
    private Texture base, glow;
    private Vector2 position, cannonPosition;
    private Color glowColor;
    private Random random;

    public SpaceTank() {
        rotation = 0;
        base = new Texture("tank_base.png");
        glow = new Texture("tank_glow.png");
        position = new Vector2();
        cannonPosition = new Vector2();
        random = new Random();
    }

    public void update() {
        cannonPosition.set(
                position.x + (Constants.TANK_WIDTH / 2) * MathUtils.cosDeg(rotation),
                position.y + Constants.TANK_HEIGHT * MathUtils.sinDeg(rotation)
        );
    }

    public void render(SpriteBatch batch) {
        glowColor = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat(), 1);
        batch.setColor(glowColor);
        // Texture texture, float x, float y, float originX, float originY, float width, float height, float scaleX,
        //		float scaleY, float rotation, int srcX, int srcY, int srcWidth, int srcHeight, boolean flipX, boolean flipY
        batch.draw(
                glow,
                position.x,
                position.y,
                50,
                50,
                Constants.TANK_WIDTH,
                Constants.TANK_HEIGHT,
                1,
                1,
                rotation,
                0,
                0,
                300,
                300,
                false,
                false
        );
        batch.setColor(Color.WHITE);
        batch.draw(
                base,
                position.x,
                position.y,
                50,
                50,
                Constants.TANK_WIDTH,
                Constants.TANK_HEIGHT,
                1,
                1,
                rotation,
                0,
                0,
                300,
                300,
                false,
                false
        );
    }

    public Bullet shoot() {
        return new Bullet(cannonPosition, rotation);
    }

}
