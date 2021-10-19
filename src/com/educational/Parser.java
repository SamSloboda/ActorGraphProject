package com.educational;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    public static void main(String[] args) throws IOException {

        FileReader input = new FileReader(new File("/Users/samsloboda/OneDrive - Shepherd University/4 Shepherd Senior/Fall 2021/CIS431/Projects/ActorGraphProject/src/com/educational/test_movies.txt"));
        BufferedReader br = new BufferedReader(input);
        String myLine = null;
        ArrayList<String[]> movieLine = new ArrayList<>();

        while ((myLine = br.readLine()) !=null ) {
            String[]  vals = myLine.split("/");
            movieLine.add(vals);
        }
        for (String[] currLine : movieLine) {
            for (String currString : currLine) {
                System.out.print(currString + "+");
            }
            System.out.println();
        }

        /*
        TODO:
        1) Separate the splitted subarrays to either movie/actor
        2) If Movie, Make sure the Word ("The") is parsing properly along with the year
        3) If person store first name & last name.
        4) Try-catch
         */


    }

}
