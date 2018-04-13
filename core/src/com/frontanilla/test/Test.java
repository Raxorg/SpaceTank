package com.frontanilla.test;

import com.badlogic.gdx.Game;
import com.frontanilla.test.screens.GameStuff;

public class Test extends Game {

    @Override
    public void create() {
        setScreen(new GameStuff(this));
    }
}
