package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Game;

public class PacmanGame extends Game {
    public SpriteBatch batch;
    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;
    public void create () {
        batch = new SpriteBatch();
        setScreen(new GameScreen(this));
    }

    public void dispose () {
        batch.dispose();
    }
}
