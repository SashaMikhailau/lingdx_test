package com.azya.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TextureModel {
	private TextureAtlas attackSpreadSheet;
	private TextureAtlas walkSpreadSheet;
	private TextureAtlas crouchSpreadSheet;

	public TextureAtlas getAttackSpreadSheet() {
		return attackSpreadSheet;
	}

	public TextureAtlas getWalkSpreadSheet() {
		return walkSpreadSheet;
	}

	public TextureAtlas getCrouchSpreadSheet() {
		return crouchSpreadSheet;
	}

	public TextureModel(TextureAtlas attackSpreadSheet, TextureAtlas walkSpreadSheet, TextureAtlas crouchSpreadSheet) {
		this.attackSpreadSheet = attackSpreadSheet;
		this.walkSpreadSheet = walkSpreadSheet;
		this.crouchSpreadSheet = crouchSpreadSheet;
	}
}
