/*
Name: Jeremy Gart
Purpose: To create a program that tests the functions of QLearning and 
MazeGenerator by generating 10 mazes and printing out all data from the 
QLearning portion.
Date: March 2nd, 2020
Source (for QLearning): technobium.com
*/

package com.technobium.rl;

public class QTraining{
    public static void main (String[]args){

    //creates instances of the necessary classes
    MazeGenerator generatey = new MazeGenerator();
    QLearning q = new QLearning();

    //loops through each of 10 mazes, generating then calling QLearning on the
    // maze, then writing the output to a txt file
    for (int i = 0; i < 10; i++){
        String mazeName = "Maze " + (i + 1);
        generatey.fullGenerate(3, mazeName);
        q.init(mazeName);
        q.calculateQ();
        q.saveMazeAndPolicy(i+1);
        
    }


}
}