package com.educational;
/*
This is the main class of this project!
 */

import edu.princeton.cs.algs4.Graph;

import java.util.ArrayList;

public class ActorGraph {
    public static void main(String[] args) {
        GraphHandler graphHandler = new GraphHandler("src/com/educational/movies-mpaa.txt");

        System.out.println("\n*** TEST 1: ACTORS IN THE SAME MOVIE ***");
        graphHandler.printDistAndPath("Pitt, Brad", "Bacon, Kevin");

        System.out.println("\n*** TEST 2: ACTORS NOT IN THE SAME MOVIE ***");
        graphHandler.printDistAndPath("Sbarge, Raphael", "Mignacco, Darlene");
    }
}

/*
TODO-DONE:
Create an Graph manipulator class. DONE!
Finding stuff...in this class it will only return the distance. it will be called GraphHandler.DONE!
This will be the USER accessible class:
USER SHOULD:
1) Pass the pair of Actors (not movies) ==DONE!
2) Pass the path of the file they want to get parsed. == DONE!
3) Get the number of steps between them. == DONE!

TODO:
ASK ABOUT THE DISTANCE what should the number be?
 */