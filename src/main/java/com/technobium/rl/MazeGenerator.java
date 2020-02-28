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
        maze[r.nextInt(x-1)][r.nextInt(y-1)] = 'F';
        for (int i = 0; i < 1000; i++){
        int randX = r.nextInt(x-1);
        int randY = r.nextInt(y-1);
        if (maze[randX][randY] == '0'){
            maze[randX][randY] = 'X';
            i = 999;
        }
        }

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