/*
Name: Jeremy Gart
Purpose: To create a program capable of generating mazes of a given size, 
containing one 'X', one 'F', and the rest filled with 0's.
Date: March 2nd, 2020
Source (for QLearning): technobium.com
*/

package com.technobium.rl;
import java.util.Random;
import java.io.PrintWriter;

public class MazeGenerator{

    char[][] maze;

    //method that generates a new maze with dimensions x and y, returns a 2D matrix
    public char[][] generate(int x, int y){
        maze = new char[x][y];

        //generates maze filled with 0s
        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                maze[i][j] = '0';
            }
        }

        //randomly inserts an 'F' and an 'X' into the maze
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

    //void method that generates a maze and writes it to a .txt file with a given name
    public void fullGenerate(int mazeSize, String mazeName){
        MazeGenerator g = new MazeGenerator();
        char[][] maze = g.generate(mazeSize, mazeSize);

        //converts matrix into a string
        String finalMaze = "";
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                finalMaze += (maze[i][j] + " ");
            }
            finalMaze += '\n';
        }
    
    //writes maze to a .txt file
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