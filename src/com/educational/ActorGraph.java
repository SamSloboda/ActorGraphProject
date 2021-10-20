package com.educational;
/*
This is the main class of this project!
 */

import java.util.ArrayList;

public class ActorGraph {
    public static void main(String[] args) {

        Parser p1 = new Parser();
        boolean completedParsing = p1.parseFileToArray("/Users/samsloboda/OneDrive - Shepherd University/4 Shepherd Senior/Fall 2021/CIS431/Projects/ActorGraphProject/src/com/educational/test_movies.txt");
        ArrayList<Vertex> arry;

        if(completedParsing){
            arry = p1.getVerticesArrayList();
            for(Vertex v: arry){
                System.out.println(v.toString());
            }
        }



    }
}
