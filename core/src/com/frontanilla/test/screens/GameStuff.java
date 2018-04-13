package com.frontanilla.test.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.test.Bullet;
import com.frontanilla.test.InputDetector;
import com.frontanilla.test.SpaceTank;
import com.frontanilla.test.Test;

public class GameStuff extends ScreenAdapter {

    private Test test;
    private SpriteBatch batch;
    private GameObserver observer;
    private GameRenderer renderer;
    private InputDetector inputDetector;

    private SpaceTank tank;
    private DelayedRemovalArray<Bullet> bullets;

    public GameStuff(Test test) {
        this.test = test;
        batch = new SpriteBatch();
        observer = new GameObserver(this);
        renderer = new GameRenderer(this);
        inputDetector = new InputDetector(observer);

        tank = new SpaceTank();
        bullets = new DelayedRemovalArray<Bullet>();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(inputDetector);
    }

    @Override
    public void render(float delta) {
        observer.update();
        renderer.render();
    }

    public SpaceTank getTank() {
        return tank;
    }

    public void addBullet(Bullet bullet) {
        bullets.add(bullet);
    }

    public DelayedRemovalArray<Bullet> getBullets() {
        return bullets;
    }
}
