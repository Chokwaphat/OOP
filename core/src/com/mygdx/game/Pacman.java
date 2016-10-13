package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Pacman {
    private Vector2 position;
    private int currentDirection;
    private int nextDirection;
    private Maze maze;
    private int currentRow, currentCol;
    public static final int DIRECTION_STILL = 0;
    public static final int DIRECTION_UP = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_DOWN = 3;
    public static final int DIRECTION_LEFT = 4;
    
    public static final int SPEED = 5;	
    private static final int [][] DIR_DIFF = new int [][] {
        {0,0},
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    public Pacman(int x, int y, Maze maze) {
    	this.maze = maze;
        position = new Vector2(x,y);
        currentDirection = DIRECTION_STILL;
        nextDirection = DIRECTION_STILL;
    }  
    public void move(int dir) { 
    	position.x += SPEED * DIR_DIFF[dir][0];
        position.y += SPEED * DIR_DIFF[dir][1];
    }
         
    public Vector2 getPosition() {
        return position;    
    }
    public void setNextDirection(int dir) {
        nextDirection = dir;
    }
    private boolean canMoveInDirection(int dir) {
    	int blockSize = WorldRenderer.BLOCK_SIZE;
    	currentRow = (int) (position.y - blockSize/2)/blockSize;
    	currentCol = (int) (position.x - blockSize/2)/blockSize;
        int newRow = currentRow + DIR_DIFF[dir][1];
        int newCol = currentCol + DIR_DIFF[dir][0];
        return !maze.hasWallAt(newRow, newCol);   
    }
    public void update() {
    	if(isAtCenter()){
    		if(canMoveInDirection(nextDirection)) {
                currentDirection = nextDirection;    
            } 
    		else {
                currentDirection = DIRECTION_STILL;    
            }
    		if(maze.hasDotAt(currentRow, currentCol)){
    			maze.removeDotAt(currentRow, currentCol);
    		}
    	}
    	position.x += SPEED * DIR_DIFF[currentDirection][0];
    	position.y += SPEED * DIR_DIFF[currentDirection][1];
    }
    public boolean isAtCenter() {
    	int blockSize = WorldRenderer.BLOCK_SIZE;
    	return ((((int)position.x - blockSize/2) % blockSize) == 0) &&
                ((((int)position.y - blockSize/2) % blockSize) == 0);
    }
}