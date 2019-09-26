package com.azya.actors;

import com.badlogic.gdx.graphics.Texture;

public class TextureModel {
	private Texture attackSpreadSheet;
	private Texture walkSpreadSheet;

	public Texture getAttackSpreadSheet() {
		return attackSpreadSheet;
	}

	public void setAttackSpreadSheet(Texture attackSpreadSheet) {
		this.attackSpreadSheet = attackSpreadSheet;
	}

	public Texture getWalkSpreadSheet() {
		return walkSpreadSheet;
	}

	public void setWalkSpreadSheet(Texture walkSpreadSheet) {
		this.walkSpreadSheet = walkSpreadSheet;
	}

	public Texture getCrouchSpreadSheet() {
		return crouchSpreadSheet;
	}

	public void setCrouchSpreadSheet(Texture crouchSpreadSheet) {
		this.crouchSpreadSheet = crouchSpreadSheet;
	}

	public TextureModel(Texture attackSpreadSheet, Texture walkSpreadSheet, Texture crouchSpreadSheet) {
		this.attackSpreadSheet = attackSpreadSheet;
		this.walkSpreadSheet = walkSpreadSheet;
		this.crouchSpreadSheet = crouchSpreadSheet;
	}

	private Texture crouchSpreadSheet;
}
