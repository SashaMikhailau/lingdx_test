package com.azya;

import com.azya.actors.AnimatedActor;
import com.azya.stages.MainStage;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MyInputListener extends InputListener {
    @Override
    public synchronized boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        AnimatedActor target = (AnimatedActor) event.getTarget();
        ((MainStage) event.getStage()).getHero().attack(target);
        return true;
    }


}
