package com.altruce.challenge;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Main {

    public static void main(final String[] args) {
        try {
            String completedRhymes;
            JSONReader jsonReader = new JSONReader();
            JSONObject rhymes = jsonReader.readFile("src/main/resources/rhymes.json");
            String input = String.join(" ", args);

            // TODO - complete rhymes

            String[] inputList = input.split("\n");
            ArrayList<String> rhymeList = new ArrayList<>();
            ArrayList<String> lastWordList = new ArrayList<>();
            for (String i:inputList
            ) {
                i = i.replaceAll(",", "");
                String lastword = i.substring(i.lastIndexOf( " ")+1);
                lastWordList.add(lastword);
            }
            for (String i:lastWordList
                 ) {
                if (rhymes.containsKey(i)){
                    rhymeList.add(rhymes.get(i).toString());
                }
            }
            for (String i:rhymeList
                 ) {
                input = input.replaceFirst("_",i);
            }
            input = input + "\n";
            completedRhymes = input;

            // TODO - export / illustrate rhymes

            // even if you created a fancy export / illustration from the completed rhymes
            // we need this print to run the automated grading test

            System.out.print(completedRhymes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
