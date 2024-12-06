package org.advent24;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("DuplicatedCode")
public class day1 {

    public void runPt1() {
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/IdeaProjects/adventOfCode24/src/main/java/org/example/input_1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String s : input) {
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            for (int i = 0; i < 5; i++){
                str1.append(s.charAt(i));
            }

            for (int i = 8; i < 13; i++){
                str2.append(s.charAt(i));
            }

            list1.add(Integer.valueOf(str1.toString()));
            list2.add(Integer.valueOf(str2.toString()));
        }


        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(list1);
        System.out.println(list2);

        int count = 0;
        for (int i = 0; i < list1.size(); i++){
            count += Math.abs(list1.get(i) - list2.get(i));
        }

        System.out.println(count);
    }

    public void runPt2(){
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/IdeaProjects/adventOfCode24/src/main/java/org/example/input_1"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String s : input) {
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();
            for (int i = 0; i < 5; i++){
                str1.append(s.charAt(i));
            }

            for (int i = 8; i < 13; i++){
                str2.append(s.charAt(i));
            }

            list1.add(Integer.valueOf(str1.toString()));
            list2.add(Integer.valueOf(str2.toString()));

        }

        System.out.println(list1);
        System.out.println(list2);
        int score = 0;
        for (int i : list1){
            int count = 0;
            for (int j : list2){
                if (i == j){
                    count++;
                }
            }

            score += i*count;
        }

        System.out.println(score);
    }


}
