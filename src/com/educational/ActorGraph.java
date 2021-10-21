package com.educational;
/*
This is the main class of this project!
 */

import edu.princeton.cs.algs4.Graph;

import java.util.ArrayList;

public class ActorGraph {
    public static void main(String[] args) {
        BuildDataStructs bds = new BuildDataStructs("/Users/samsloboda/OneDrive - Shepherd University/4 Shepherd Senior/Fall 2021/CIS431/Projects/ActorGraphProject/src/com/educational/test_movies.txt");
        bds.printArraySize();
        bds.printHashMapSize();

        //Testing Graph class
        Graph g1 = new Graph(3);
        g1.addEdge(0,1);
        g1.addEdge(1,2);

        System.out.println(g1.degree(1)); //degree of vertexID = 1 == 2
        System.out.println(g1.toString()); //Adjacency list printing
    }
}
