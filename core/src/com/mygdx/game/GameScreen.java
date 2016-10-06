package com.mygdx.game;
import com.badlogic.gdx.ScreenAdapter;
public class GameScreen extends ScreenAdapter {
	
	private PacmanGame pacmanGame;
	
	public GameScreen(PacmanGame pacmanGame) {
		this.pacmanGame = pacmanGame;
	}
	
	@Override
	public void render(float delta) {
		System.out.println("Hello " + delta);
	}
}
