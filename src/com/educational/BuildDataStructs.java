package com.educational;
import java.util.ArrayList;
import java.util.HashMap;

public class BuildDataStructs {
    private ArrayList<Vertex> parsedArray;
    private String pathName;
    HashMap<String, Integer> stringToIdHashMap;
    String[] idToStringArray;


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
        int lengthOfArray = parsedArray.size(); //Problematic line of the code, this number is not true can be fixed by t.odo item 1.
        int capacityOfHashMap = parsedArray.size()*2; //Multiplied the capacity for the test dataset, for the real one the parsedArray.size() is more than a double of the number of keys.
        idToStringArray = new String[lengthOfArray];
        stringToIdHashMap = new HashMap<String, Integer>(capacityOfHashMap);

        int idCount = 0;
        for(Vertex v: parsedArray){
            if(stringToIdHashMap.isEmpty() || !stringToIdHashMap.containsKey(v.getName())){
                v.setID(idCount);
                idToStringArray[v.getID()] = v.getName();
                stringToIdHashMap.put(v.getName(),v.getID());
                idCount++;
            }
        }
    }
    public void printHashMap(){
        System.out.println(stringToIdHashMap);
    }
    public void printHashMapSize(){
        System.out.println("Size of HashMap = "+stringToIdHashMap.size());
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
TODO:
1) Think about separation of methods: BuildHashMap, BuildArray, and Build Graph instead of BuildTables.
PROS:
i) This would fix the problem with array capacity as it would be the right size. (I will know in forward what the proper size is.)
ii) The returns of the HashMap, Array and Graph would be possible for the future manipulation with it. Such as find something in the graph...

CONS:
i) More useless iterations.
ii) With this the algorithm would be 3*N instead of N.(It is the risk that I am willing to take.)

2) Realize how would I know, if the movie and the actor are related???
SOLUTION:
i) Work with it while parsing, or constantly comparing the parsedArray (of Vertices) with the stringArray of Vertices.

 */