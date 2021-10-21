package com.educational;
import edu.princeton.cs.algs4.Graph;

public class GraphHandler {
    Graph graph;
    public GraphHandler() {
        BuildDataStructs bds = new BuildDataStructs("/Users/samsloboda/OneDrive - Shepherd University/4 Shepherd Senior/Fall 2021/CIS431/Projects/ActorGraphProject/src/com/educational/test_movies.txt");
        graph = bds.getActorGraph();
    }
}
/*
TODO:
1) BuildTables. Constructor class. DONE!
2) getActorGraph and save it here. Constructor class. DONE!
3) Then manipulation starts. Manipulation classes. getDistance. (this will be useful)
 */
