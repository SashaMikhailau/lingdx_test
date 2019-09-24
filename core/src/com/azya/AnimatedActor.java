package com.azya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.*;
import com.badlogic.gdx.utils.Pool;

import java.util.Iterator;

public class AnimatedActor extends Actor {
    public static final String pathToAnimation = "skeleton/SPRITE_SHEETS" +
            "/FW_Skeleton_Crouching.png";
    volatile boolean started;


    public AnimatedActor(InputListener inputListener) {
        Animation<TextureRegion> animationFromSpriteSheetTexture = AnimationUtils.getAnimationFromSpriteSheetTexture(pathToAnimation, 2, 6, 8);
        TextureRegion keyFrame = animationFromSpriteSheetTexture.getKeyFrames()[0];
        setBounds(getX(),getY(),keyFrame.getRegionWidth(),keyFrame.getRegionHeight());
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
