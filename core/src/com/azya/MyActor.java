package com.azya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.*;
import com.badlogic.gdx.utils.Pool;

import java.util.Iterator;

public class MyActor extends Actor {
    private Texture texture = new Texture(Gdx.files.internal("0001.png"));
    volatile boolean started;


    public MyActor(InputListener inputListener) {
        setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
        addListener(inputListener);

        Pool<RotateToAction> rotateToActionPool = new Pool<RotateToAction>() {

            @Override
            protected RotateToAction newObject() {
                RotateToAction rotateToAction = new RotateToAction();
                rotateToAction.setRotation(90);
                rotateToAction.setDuration(5);
                return rotateToAction;
            }
        };

    }

      @Override
    public void draw(Batch batch, float parentAlpha) {
          batch.draw(texture, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
                  getScaleX(), getScaleY(), getRotation(), 0, 0, texture.getWidth(), texture.getHeight(),
                  false, false);
    }
}
