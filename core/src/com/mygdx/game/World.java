package com.mygdx.game;

public class World {
	private Pacman pacman;
    private PacmanGame pacmanGame;
    private Maze maze;
    private int score;
    World(PacmanGame pacmanGame) {
        this.pacmanGame = pacmanGame;
        maze = new Maze();
        pacman = new Pacman(60,60,this);
        score = 0;
    }
    public int getScore() {
    	return score;
    }
    Pacman getPacman() {
        return pacman;
    }
    Maze getMaze() {
    	return maze;
    }
    public void update(float delta) {
        pacman.update();
    }
	public void increaseScore() {
		// TODO Auto-generated method stub
		
	}	
    
}
