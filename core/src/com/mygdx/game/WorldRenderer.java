package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	private PacmanGame pacmanGame;
	private World world;
	private Texture pacmanImg;
	private SpriteBatch batch;
	private MazeRenderer mazeRenderer;
	public static final int BLOCK_SIZE = 40;
	private BitmapFont font;
	
	public WorldRenderer(PacmanGame pacmanGame, World world) {
		this.world = world;
		this.pacmanGame = pacmanGame;
        pacmanImg = new Texture("pacman.png");  
        mazeRenderer = new MazeRenderer(pacmanGame.batch, world.getMaze());
        font = new BitmapFont();
    }

	public void render(float delta) {
		mazeRenderer.render();
		batch = pacmanGame.batch;
        batch.begin();
        Vector2 pos = world.getPacman().getPosition();
        batch.draw(pacmanImg, pos.x - BLOCK_SIZE/2, PacmanGame.HEIGHT - pos.y - BLOCK_SIZE/2);
        font.draw(batch, "" + world.getScore(), 700, 60);
        batch.end();
	}

	
	
}
