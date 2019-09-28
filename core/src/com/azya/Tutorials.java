package com.azya;

import com.azya.battlestage.BattleStage;
import com.azya.screens.MainScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class Tutorials extends Game {

	@Override
	public void create() {
        BattleStage battleStage = loadBattleStageFromJson();
        setScreen(new MainScreen(battleStage));

	}

	public BattleStage loadBattleStageFromJson() {
		BattleStage battleStage = null;
		try {
			FileHandle internal = Gdx.files.internal("data/stage1.json");
			ObjectMapper objectMapper = new ObjectMapper();
			battleStage = objectMapper.readValue(internal.reader(), BattleStage.class);
		} catch (IOException e) {
			Gdx.app.error("Battle Stage","Battle stage couldnt. load",e);
		}
		return battleStage;
	}


}
