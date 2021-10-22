package com.educational;
import edu.princeton.cs.algs4.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class BuildDataStructs {
    private ArrayList<Vertex> parsedArray;
    private String pathName;
    private Graph actorGraph;
    private HashMap<String, Integer> stringToIdHashMap;
    private String[] idToStringArray;


    public BuildDataStructs(String path){
        this.pathName=path;
        parsedArray = getParsedArray();
        buildTables();
    }

    private ArrayList getParsedArray(){
        Parser p1 = new Parser();
        boolean completedParsing = p1.parseFileToArray(pathName);
        if(completedParsing){
            ArrayList<Vertex> arry = p1.getVerticesArrayList();
            return arry;
        }else{
            return null;
        }
    }
    private void buildTables(){
        buildHashMap();
        buildIDtoStringArray();
        buildGraph();
    }
    /*
    Builds the HashMap and sets the correct IDs to every element of the Vertices ArrayList.
     */
    private HashMap<String, Integer> buildHashMap(){
        int capacityOfHashMap = parsedArray.size()*2; //Multiplied the capacity for the test dataset, for the real one the parsedArray.size() is more than a double of the number of keys.
        stringToIdHashMap = new HashMap<String, Integer>(capacityOfHashMap);

        int idCount = 0;
        for(Vertex v: parsedArray){
            if(stringToIdHashMap.isEmpty() || !stringToIdHashMap.containsKey(v.getName())){
                v.setID(idCount);
                stringToIdHashMap.put(v.getName(),v.getID());
                idCount++;
            }
            else if(stringToIdHashMap.containsKey(v.getName())){
                v.setID(stringToIdHashMap.get(v.getName()));    //in the case that the the Vertex has already appeared in the HashMap, need to set th proper ID!!!
            }
        }
        return stringToIdHashMap;
    }
    /*
    Builds the Array of strings, the indexes are vertexIDs and corresponding array elements are name/movie name.
     */
    private String[] buildIDtoStringArray(){
        int lengthOfArray = stringToIdHashMap.size();
        idToStringArray = new String[lengthOfArray];

        for(Vertex v: parsedArray){
            if(idToStringArray[v.getID()] == null){
                idToStringArray[v.getID()] = v.getName();
            }
        }
        return idToStringArray;
    }
    private Graph buildGraph(){
        int numOfVertices = getHashMapSize();
        actorGraph = new Graph(numOfVertices); //initialize the Graph with number of vertices (HashMap has the correct number of vertices.)

        int temp = 0;
        for(int i = 0; i < parsedArray.size();i++){
            if(!parsedArray.get(i).getIsActor()){
                for(int j = i+1;j < parsedArray.size() && parsedArray.get(j).getIsActor();j++){
                    int movieID = parsedArray.get(i).getID();
                    int actorID = parsedArray.get(j).getID();
                    actorGraph.addEdge(movieID, actorID);
                    temp = j;
                }
                i = temp;
            }
        }
        return actorGraph;
    }
    public void printGraph(){
        System.out.println(actorGraph.toString());
    }
    public Graph getActorGraph() {
        return actorGraph;
    }
    public HashMap<String, Integer> getHashMap(){
        return stringToIdHashMap;
    }
    public String[] getIdToStringArray(){
        return idToStringArray;
    }
    public void printHashMap(){
        System.out.println(stringToIdHashMap);
    }
    public void printHashMapSize(){
        System.out.println("Size of HashMap = "+stringToIdHashMap.size());
    }
    public int getHashMapSize(){
        return stringToIdHashMap.size();
    }
    public void printArray(){
        for(int i = 0;i<idToStringArray.length;i++){
            System.out.println("["+i+"] = "+idToStringArray[i]);
        }
    }
    public void printArraySize(){
        System.out.println("Size of Array = "+idToStringArray.length);
    }
    private void printArrayOfVertices(ArrayList<Vertex> arry){
        for(Vertex v: arry){
            System.out.println(v.toString());
        }
    }

}
/*
TODO = DONE!:
1) Think about separation of methods: BuildHashMap, BuildArray, and Build Graph instead of BuildTables. DONE!!!
PROS:
i) This would fix the problem with array capacity as it would be the right size. (I will know in forward what the proper size is.) FIXED
ii) The returns of the HashMap, Array and Graph would be possible for the future manipulation with it. Such as find something in the graph... FIXED

CONS:
i) More useless iterations.
ii) With this the algorithm would be 3*N instead of N.(It is the risk that I am willing to take.)

2) Realize how would I know, if the movie and the actor are related???
SOLUTION:
i) Work with it while parsing, or constantly comparing the parsedArray (of Vertices) with the stringArray of Vertices. XXX
ii) Approach: I will try to work on this with simple VerticesArray traversal, and rely on the fact that the movie is followed by actors
until the next movie...This is how I will create the relationship(link). It is a bit risky, but I will take this approach now.

TODO - DONE:
1) FOUND A BUG IN ARRAY. = ALL VALUES ARE NULL...
TO FIX THIS BUG:
Look up the buildIDtoStringArray conditions as the second condition looks up for the duplicates, modify the adding condition. == FIXED!
It is fixed that it rewrites the Array element when the same element occurs, it is not really good algorithm, but it works. No time to be fixed.

TODO - IMPROVEMENTS:
1) Fix  buildIDtoStringArray so it doesn't override the multiples. == FIXED!
 */