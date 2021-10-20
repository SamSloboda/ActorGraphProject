package com.educational;
import java.util.ArrayList;
import java.util.HashMap;

public class BuildDataStructs {
    private ArrayList parsedArray;
    private String pathName;

    public BuildDataStructs(String path){
        this.pathName=path;
        parsedArray = getParsedArray();


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
        String[] idToStringArray = new String[lengthOfArray];
        HashMap<String, Integer> stringToIdHashMap = new HashMap<String, Integer>(capacityOfHashMap);

    }
}
