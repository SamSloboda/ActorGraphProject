package com.educational;
import edu.princeton.cs.algs4.Graph;

public class GraphHandler {
    Graph graph;
    public GraphHandler() {
        BuildDataStructs bds = new BuildDataStructs("/Users/samsloboda/OneDrive - Shepherd University/4 Shepherd Senior/Fall 2021/CIS431/Projects/ActorGraphProject/src/com/educational/test_movies.txt");
        graph = bds.getActorGraph();
        System.out.println(graph.toString());
        bds.printArray();
    }
}
/*
TODO:
1) Then manipulation starts. Manipulation classes. getDistance. (this will be useful)
2) We will need to access the built HashMap and the built Array from BuildDataStructs.java
 */
