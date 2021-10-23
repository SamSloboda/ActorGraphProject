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