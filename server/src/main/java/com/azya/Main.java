package com.azya;

import akka.actor.ActorSystem;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		ActorSystem actorSystem = ActorSystem.create();
		System.out.println("Press any key");
		int read = System.in.read();
		System.out.println("Exitting");
		actorSystem.terminate();
	}
}
