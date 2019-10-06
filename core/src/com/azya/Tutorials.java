package com.azya;

import com.azya.battlestage.BattleStage;
import com.azya.screens.MainScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.ext.eventbus.bridge.tcp.TcpEventBusBridge;
import io.vertx.ext.eventbus.bridge.tcp.impl.TcpEventBusBridgeImpl;

import java.io.IOException;


public class Tutorials extends Game {

	@Override
	public void create() {
        BattleStage battleStage = loadBattleStageFromJson();
		Socket socket = Gdx.net.newClientSocket(Net.Protocol.TCP,"localhost",9090,
				getSocketHints());
		setScreen(new MainScreen(battleStage,socket));
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

	public SocketHints getSocketHints(){
		SocketHints socketHints = new SocketHints();
		socketHints.connectTimeout = 10000;
		return socketHints;
	}


}
