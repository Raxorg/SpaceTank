package com.frontanilla.test.screens;

import com.frontanilla.test.Bullet;

public class GameObserver {

    private GameStuff stuff;

    public GameObserver(GameStuff stuff) {
        this.stuff = stuff;
    }

    public void update() {
        stuff.getTank().update();
        for (Bullet bullet : stuff.getBullets()) {
            bullet.update();
        }
    }

    public void fire() {
        stuff.addBullet(stuff.getTank().shoot());
    }
}
