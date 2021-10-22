package com.educational;
/*
This is the main class of this project!
 */

import edu.princeton.cs.algs4.Graph;

import java.util.ArrayList;

public class ActorGraph {
    public static void main(String[] args) {
        GraphHandler graphHandler = new GraphHandler("/Users/samsloboda/OneDrive - Shepherd University/4 Shepherd Senior/Fall 2021/CIS431/Projects/ActorGraphProject/src/com/educational/movies-mpaa.txt");
        graphHandler.printDistance("Sbarge, Raphael", "Mignacco, Darlene");
        graphHandler.printRoute("Sbarge, Raphael","Mignacco, Darlene");
    }
}

/*
TODO:
Create an Graph manipulator class. DONE!
Finding stuff...in this class it will only return the distance. it will be called GraphHandler.DONE!
This will be the USER accessible class:
USER SHOULD:
1) Pass the pair of Actors (not movies)
2) Pass the path of the file they want to get parsed.
3) Get the number of steps between them.
 */