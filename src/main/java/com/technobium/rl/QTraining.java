package com.technobium.rl;

public class QTraining{
    public static void main (String[]args){

    MazeGenerator generatey = new MazeGenerator();
    QLearning q = new QLearning();

    for (int i = 0; i < 10; i++){
        String mazeName = "Maze " + i;
        generatey.fullGenerate(3, mazeName);
        q.init(mazeName);
        q.calculateQ();
        
    }


}
}