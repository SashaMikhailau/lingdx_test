package com.azya.battlestage;

import com.azya.actors.AnimatedActor;
import com.azya.actors.EnemyAnimatedActor;
import com.badlogic.gdx.Gdx;

public class BattlePositionResolver {
    public static final int PADDING = 40;
    public static final int PADDING_RIGHT = 200;
    public float topLine;
    public float middle;
    public float bottomLine;
    public float enemyXPosition;


    public BattlePositionResolver() {
        bottomLine = PADDING;
        middle = Gdx.graphics.getHeight() / 2 - 110;
        topLine = Gdx.graphics.getHeight() - 225;
        enemyXPosition = Gdx.graphics.getWidth() - PADDING_RIGHT;
    }

    public void resolvePosition(AnimatedActor actor){
        switch (actor.getBattlePosition()) {
            case TOP:
                actor.setY(topLine);
                break;
            case BOTTOM:
                actor.setY(middle);
                break;
            case MIDDLE:
                actor.setY(bottomLine);
                break;
        }
        if(actor instanceof EnemyAnimatedActor){
            actor.setX(enemyXPosition);
        } else {
            actor.setX(PADDING);
        }
    }
}
