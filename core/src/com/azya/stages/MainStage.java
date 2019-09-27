package com.azya.stages;


import com.azya.actors.*;
import com.azya.rolesystem.Attack;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.Viewport;

public class MainStage extends Stage {
	public static final int PADDING = 40;
	public float LOW_LINE;
	public float MIDDLE_LINE;
	public float TOP_LINE;
	private OrthographicCamera camera;
	private Box2DDebugRenderer renderer;
	private Texture background;
	public static final String pathToCrouchAnimation = "skeleton/atlases/crouch.atlas";
	public static final String pathToAttackAnimation = "skeleton/atlases/attack.atlas";
	public static final String pathToWalkAnimation = "skeleton/atlases/walk.atlas";
	public static final String pathToHitAnimation = "skeleton/atlases/hit.atlas";
	public static final String pathToBackGround = "backgrounds/battleback10.png";
	private TextureAtlas crouchSpriteSheet;
	private TextureAtlas attackSpriteSheet;
	private TextureAtlas walkSpriteSheet;
	private TextureAtlas hitSpriteSheet;
	private AnimatedActor hero;
	private BitmapFont font;

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return super.mouseMoved(screenX, screenY);
	}

	public MainStage(Viewport viewPort) {
		super(viewPort);
		crouchSpriteSheet = new TextureAtlas(Gdx.files.internal(pathToCrouchAnimation));
		attackSpriteSheet = new TextureAtlas(Gdx.files.internal(pathToAttackAnimation));
		walkSpriteSheet = new TextureAtlas(Gdx.files.internal(pathToWalkAnimation));
		hitSpriteSheet = new TextureAtlas(Gdx.files.internal(pathToHitAnimation));
		font = new BitmapFont();
		background = new Texture(Gdx.files.internal(pathToBackGround));
		LOW_LINE = PADDING;
		MIDDLE_LINE = getHeight() / 2 - 110;
		TOP_LINE = getHeight() - 225;
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
		hitSpriteSheet.dispose();
		font.dispose();
	}

	public AnimatedActor getHero() {
		return hero;
	}

	private void initActors() {
		addActor(new Background(background));
		TextureModel skeletonModel = new TextureModel(attackSpriteSheet, walkSpriteSheet,
				crouchSpriteSheet,hitSpriteSheet);
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
		skeleton4.setX(getWidth() - 200);
		skeleton4.setY(LOW_LINE);
		AnimatedActor skeleton5 = new EnemyAnimatedActor(skeletonModel);
		skeleton5.setX(getWidth() - 200);
		skeleton5.setY(MIDDLE_LINE);
		AnimatedActor skeleton6 = new EnemyAnimatedActor(skeletonModel);
		skeleton6.setX(getWidth() - 200);
		skeleton6.setY(TOP_LINE);

		addActor(skeleton1);
		addActor(hero);
		addActor(skeleton3);
		addActor(skeleton4);
		addActor(skeleton5);
		addActor(skeleton6);
	}

	public void poputHit(Attack attack){
		addActor(new AttackCounter(attack.getPower(),font));
	}
}
