package com.educational;
/*
This is the main class of this project!
 */

import edu.princeton.cs.algs4.Graph;

import java.util.ArrayList;

public class ActorGraph {
    public static void main(String[] args) {
        BuildDataStructs bds = new BuildDataStructs("/Users/samsloboda/OneDrive - Shepherd University/4 Shepherd Senior/Fall 2021/CIS431/Projects/ActorGraphProject/src/com/educational/test_movies.txt");
        bds.printHashMap();
        bds.printGraph();
    }
}

/*
TODO:
Create an Graph manipulator class.
Finding stuff...in this class it will only return the distance. it will be called GraphHandler.
 */