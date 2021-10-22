package com.educational;
import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphHandler {
    Graph graph;
    HashMap hashMap;
    String[] IDtoString;
    BreadthFirstPaths breadthFirstPaths;

    public GraphHandler(String pathname) {
        BuildDataStructs bds = new BuildDataStructs(pathname);
        graph = bds.getActorGraph();
        hashMap = bds.getHashMap();
        IDtoString = bds.getIdToStringArray();
    }
    public int getDistance(String actor1, String actor2){
        int actor1ID = (int)hashMap.get(actor1);
        int actor2ID = (int)hashMap.get(actor2);
        breadthFirstPaths = new BreadthFirstPaths(graph,actor1ID);

        if(breadthFirstPaths.hasPathTo(actor2ID)){
            return breadthFirstPaths.distTo(actor2ID);
        }
        return -1;
    }
    public void printRoute(String actor1, String actor2){
        int actor1ID = (int)hashMap.get(actor1);
        int actor2ID = (int)hashMap.get(actor2);
        Iterable <Integer> iterable;
        ArrayList <Integer> idArray = new ArrayList<Integer>();
        ArrayList <String> stringArray = new ArrayList<String>();
        String result = "";
        breadthFirstPaths = new BreadthFirstPaths(graph,actor1ID);

        if(breadthFirstPaths.hasPathTo(actor2ID)){
            iterable = breadthFirstPaths.pathTo(actor2ID);
            iterable.forEach(idArray::add);

            for(Integer id: idArray){
                stringArray.add(IDtoString[id]);
            }

            for(int i=0; i< stringArray.size();i++){
                if(i==0){
                    result = stringArray.get(i);
                }
                else if(i % 2==0 && i!=0){
                    result = result +"<--"+ stringArray.get(i);
                }else if(i % 2 == 1){
                    result = result +"-->"+stringArray.get(i);
                }
            }
            System.out.println("THE ROUTE IS: ");
            System.out.println(result);
        }
    }
    public void printDistance(String actor1, String actor2){
        System.out.println("THE DISTANCE IS: "+getDistance(actor1,actor2));
    }
}
/*
TODO - DONE:
1) Then manipulation starts. Manipulation classes. getDistance. (this will be useful)
2) We will need to access the built HashMap and the built Array from BuildDataStructs.java = done!

 */
