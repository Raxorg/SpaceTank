package com.frontanilla.test;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.frontanilla.test.screens.GameObserver;

public class InputDetector extends InputAdapter {

    private GameObserver observer;

    public InputDetector(GameObserver observer) {
        this.observer = observer;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.SPACE:
                observer.fire();
                break;
        }
        return true;
    }
}
