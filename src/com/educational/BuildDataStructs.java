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
            //p1.printParsedArray();
            return arry;
        }else{
            return null;
        }
    }
    private void buildTables(){
        int lengthOfArray = parsedArray.size();
        int capacityOfHashMap = parsedArray.size() * 2;
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

}
