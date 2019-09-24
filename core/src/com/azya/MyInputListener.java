package com.azya;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MyInputListener extends InputListener {
    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        ((AnimatedActor) event.getTarget()).started = !((AnimatedActor) event.getTarget()).started;
        return true;
    }


}
