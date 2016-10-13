package com.mygdx.game;

public class Maze {
	private int height;
	private int width;
	private boolean [][] hasDots;
    private String[] MAP = new String [] {
            "####################",
            "#..................#",
            "#.###.###..###.###.#",
            "#.#...#......#...#.#",
            "#.#.###.####.###.#.#",
            "#.#.#..........#.#.#",
            "#.....###..###.....#",
            "#.#.#..........#.#.#",
            "#.#.###.####.###.#.#",
            "#.#...#......#...#.#",
            "#.###.###..###.###.#",
            "#..................#",
            "####################"    
    };
    
    public Maze() {
        height = MAP.length;
        width = MAP[0].length();
        initDotData();
    }
    private void initDotData() {
        hasDots = new boolean[height][width];
        for(int r = 0; r < height; r++) {
            for(int c = 0; c < width; c++) {
                hasDots[r][c] = MAP[r].charAt(c) == '.';
            }
        }
    }
    public int getHeight() {
        return height;
    }
 
    public int getWidth() {
        return width;
    }
    public boolean hasWallAt(int r, int c) {
        if(r<0 || c<0){
        	return false;
        }
    	return MAP[r].charAt(c) == '#';
    }
 
    public boolean hasDotAt(int r, int c) {
        return hasDots[r][c];
    }
    public void removeDotAt(int r, int c) {
        hasDots[r][c] = false;
    }
}
