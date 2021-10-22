package com.educational;
import edu.princeton.cs.algs4.Graph;

import java.util.HashMap;

public class GraphHandler {
    Graph graph;
    HashMap hashMap;
    String[] IDtoString;

    public GraphHandler() {
        BuildDataStructs bds = new BuildDataStructs("/Users/samsloboda/OneDrive - Shepherd University/4 Shepherd Senior/Fall 2021/CIS431/Projects/ActorGraphProject/src/com/educational/movies-mpaa.txt");
        graph = bds.getActorGraph();
        hashMap = bds.getHashMap();
        IDtoString = bds.getIdToStringArray();

        System.out.println(hashMap.get("Bacon, Kevin"));
        System.out.println(graph.degree(6764));

    }
    public int getDistance(){
        return 0;
    }
    public void printRoute(){
        System.out.println("Road 66!");
    }
}
/*
TODO:
1) Then manipulation starts. Manipulation classes. getDistance. (this will be useful)
2) We will need to access the built HashMap and the built Array from BuildDataStructs.java = done!
 */
