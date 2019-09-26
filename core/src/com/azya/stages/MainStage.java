package com.azya.stages;


import com.azya.actors.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class MainStage extends Stage {
	public static final int PADDING = 70;
	public static final int VIEWPORT_WIDTH = 800;
	public static final int VIEWPORT_HEIGHT = 480;
	public static final int LOW_LINE = 25;
	public static final int MIDDLE_LINE = 225;
	public static final int TOP_LINE = 425;
	private OrthographicCamera camera;
	private Box2DDebugRenderer renderer;
	private Texture background;
	public static final String pathToCrouchAnimation = "skeleton/SPRITE_SHEETS/FW_Skeleton_Crouching.png";
	public static final String pathToAttackAnimation = "skeleton/SPRITE_SHEETS" +
			"/FW_Skeleton_Attack.png";
	public static final String pathToWalkAnimation = "skeleton/SPRITE_SHEETS" +
			"/FW_Skeleton_Walking.png";
	public static final String pathToBackGround= "backgrounds/battleback10.png";
	private Texture crouchSpriteSheet;
	private Texture attackSpriteSheet;
	private Texture walkSpriteSheet;
	private AnimatedActor hero;

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return super.mouseMoved(screenX, screenY);
	}

	public MainStage() {
		super();
		crouchSpriteSheet = new Texture(Gdx.files.internal(pathToCrouchAnimation));
		attackSpriteSheet = new Texture(Gdx.files.internal(pathToAttackAnimation));
		walkSpriteSheet = new Texture(Gdx.files.internal(pathToWalkAnimation));
		background = new Texture(Gdx.files.internal(pathToBackGround));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
		renderer = new Box2DDebugRenderer();
		initActors();
	}

	@Override
	public void draw() {
		super.draw();
	}

	@Override
	public void dispose() {
		super.dispose();
		crouchSpriteSheet.dispose();
		background.dispose();
		walkSpriteSheet.dispose();
		attackSpriteSheet.dispose();
	}

	public AnimatedActor getHero() {
		return hero;
	}

	private void initActors() {
		addActor(new Background(background));
		TextureModel skeletonModel = new TextureModel(attackSpriteSheet, walkSpriteSheet, crouchSpriteSheet);
		AnimatedActor skeleton1 = new FriendAnimatedActor(skeletonModel);
		skeleton1.setX(PADDING);
		skeleton1.setY(LOW_LINE);
		hero = new HeroAnimatedActor(skeletonModel);
		hero.setX(PADDING);
		hero.setY(MIDDLE_LINE);
		AnimatedActor skeleton3 = new FriendAnimatedActor(skeletonModel);
		skeleton3.setX(PADDING);
		skeleton3.setY(TOP_LINE);
		AnimatedActor skeleton4 = new EnemyAnimatedActor(skeletonModel);
		skeleton4.setX(VIEWPORT_WIDTH - PADDING - skeleton4.getWidth());
		skeleton4.setY(LOW_LINE);
		AnimatedActor skeleton5 = new EnemyAnimatedActor(skeletonModel);
		skeleton5.setX(VIEWPORT_WIDTH - PADDING - skeleton5.getWidth());
		skeleton5.setY(MIDDLE_LINE);
		AnimatedActor skeleton6 = new EnemyAnimatedActor(skeletonModel);
		skeleton6.setX(VIEWPORT_WIDTH - PADDING - skeleton6.getWidth());
		skeleton6.setY(TOP_LINE);

		addActor(skeleton1);
		addActor(hero);
		addActor(skeleton3);
		addActor(skeleton4);
		addActor(skeleton5);
		addActor(skeleton6);
	}
}
