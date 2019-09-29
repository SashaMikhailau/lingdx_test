package com.azya.stages;


import com.azya.actors.*;
import com.azya.battlestage.BattlePosition;
import com.azya.battlestage.BattleStage;
import com.azya.models.EnemyModel;
import com.azya.models.HeroModel;
import com.azya.rolesystem.Attack;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.HashMap;
import java.util.Map;

public class MainStage extends Stage {

	private OrthographicCamera camera;
	private Box2DDebugRenderer renderer;
	private Texture background;

	public static final String pathToBackGround = "backgrounds/battleback10.png";
    private BattleStage battleStage;
	private AnimatedActor hero;
	private BitmapFont font;
    private Map<String, TextureModel> textureModelMap = new HashMap<>();


	public MainStage(Viewport viewPort, BattleStage battleStage) {
		super(viewPort);
        this.battleStage = battleStage;
		font = new BitmapFont();
		background = new Texture(Gdx.files.internal(pathToBackGround));

		initActors();
	}

	@Override
	public void draw() {
		super.draw();
	}

	@Override
	public void dispose() {
		super.dispose();
		background.dispose();
		font.dispose();
        for (TextureModel value : textureModelMap.values()) {
            value.dispose();
        }
	}

	public AnimatedActor getHero() {
		return hero;
	}

	private void initActors() {
		addActor(new Background(background));
        for (Map.Entry<BattlePosition, EnemyModel> entry : battleStage.getEnemies().entrySet()) {
            String assetName = entry.getValue().getAssetName();
            if(!textureModelMap.containsKey(assetName)){
                textureModelMap.put(assetName,new TextureModel(assetName));
            }
            addActor(new EnemyAnimatedActor(entry.getKey(),textureModelMap.get(assetName)));
        }
        for (Map.Entry<BattlePosition, HeroModel> entry :
                battleStage.getFoos().entrySet()) {
            String assetName = entry.getValue().getAssetName();
            if(!textureModelMap.containsKey(assetName)){
                textureModelMap.put(assetName,new TextureModel(assetName));
            }
            if(entry.getKey()==BattlePosition.MIDDLE){
                hero = new HeroAnimatedActor(entry.getKey(),
                        textureModelMap.get(assetName));
                addActor(hero);
            } else {
                addActor(new FriendAnimatedActor(entry.getKey(),
                        textureModelMap.get(assetName)));
            }
        }
	}

	public void poputHit(Attack attack){
		addActor(new AttackCounter(attack.getPower(),font));

	}
}
