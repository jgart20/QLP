package com.technobium.rl;
import java.util.Random;
import java.io.PrintWriter;
import java.util.Scanner;

public class MazeGenerator{

    char[][] maze;

    public char[][] generate(int x, int y){
        maze = new char[x][y];

        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                maze[i][j] = '0';
            }
        }

        Random r = new Random();
        maze[r.nextInt(x)][r.nextInt(y)] = 'F';
        int randX = r.nextInt(x);
        int randY = r.nextInt(y);
        while (maze[randX][randY] != '0'){
            randX = r.nextInt(x);
            randY = r.nextInt(y);
        }
            maze[randX][randY] = 'X';
            
        return maze;
    }
    public void fullGenerate(int mazeSize, String mazeName){
        MazeGenerator g = new MazeGenerator();
        char[][] maze = g.generate(mazeSize, mazeSize);

        String finalMaze = "";
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                finalMaze += (maze[i][j] + " ");
            }
            finalMaze += '\n';
        }
    try {
        PrintWriter out = new PrintWriter(mazeName);
    out.println(finalMaze);
    out.close();
        }
    catch (Exception e){
        e.printStackTrace();
    }
    }
}