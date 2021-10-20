/*
   Author: Samuel Sloboda
   Date: 10/19/2021
   Description: This class works as a parser from Text  file into ArrayList of Vertices (with IDs of -1).
   The correct IDs will be assigned later in the graph building phase.
 */
package com.educational;
import java.io.*;
import java.util.ArrayList;


public class Parser {

    private final ArrayList<Vertex> arrayOfVertices = new ArrayList<>();

    public boolean parseFileToArray(String path) {
        boolean parsingComplete = false;
        try {
            FileReader input = new FileReader(path);
            BufferedReader br = new BufferedReader(input);
            String line;

            while ((line = br.readLine()) != null) {
                String[] lineArray = line.split("/");
                arrayOfVertices.add(new Vertex(lineArray[0],-1,false));
                for(int i=1; i< lineArray.length;i++){
                    arrayOfVertices.add(new Vertex(lineArray[i],-1,true));
                }
            }
            parsingComplete = true;
        } catch (IOException e) {
            parsingComplete = false;
        }
        return parsingComplete;
    }
    public ArrayList getVerticesArrayList(){
        return arrayOfVertices;
    }
    public void printParsedArray(){
        for(Vertex v: arrayOfVertices){
            System.out.println(v.toString());
        }
    }
}


