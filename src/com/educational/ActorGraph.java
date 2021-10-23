/*
@author Samuel Sloboda
@author Kevin Wilson
@date 10/22/2021
GitHub: https://github.com/SamSloboda/ActorGraphProject

This is a main class for the whole project. It is the only runnable element of this whole project.
 */
package com.educational;

public class ActorGraph {
    /*
    This is the main class. I have created some test cases.
    Distance of 1 is when two actors appeared in the same movie together.
    Distance of n is number of EDGES counting only ACTOR TO ACTOR edges.
     */
    public static void main(String[] args) {
        GraphHandler graphHandler = new GraphHandler("src/com/educational/movies-mpaa.txt");

        System.out.println("\n*** TEST 1: ACTORS IN THE SAME MOVIE ***");
        graphHandler.printDistAndPath("Pitt, Brad", "Bacon, Kevin");

        System.out.println("\n*** TEST 2: ACTORS NOT IN THE SAME MOVIE ***");
        graphHandler.printDistAndPath("Sbarge, Raphael", "Mignacco, Darlene");

        System.out.println("\n*** TEST 3: ACTORS NOT IN THE SAME MOVIE ***");
        graphHandler.printDistAndPath("Marber, Samuel J.", "Hamilton, Mahlon");
    }
}