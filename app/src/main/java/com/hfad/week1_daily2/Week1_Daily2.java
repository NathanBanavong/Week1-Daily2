package com.hfad.week1_daily2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Week1_Daily2 {

    public static void main(String[] args) {
        //Problem 1
        List<String> leWords =  new ArrayList<>();
        leWords.addAll(Arrays.asList("Nathan", "Jimmy", "Michael","Bob","Daniel"));
        findDuplicates(leWords);

        checkPalindrom("level"); //Problem 2 -> Works

        fizzBuzz(20);     //Problem 3 -> Works

        checkAnagrams("neck", "turtle");  ////Problem 4 ->

        printTables();      //Problem 5 -> Works
    }

    //Week 1 Daily Problems

    //Problem 1 - Create function to print the duplicates in a list of strings
    public static void findDuplicates(List<String> stringsList) {
        boolean isDuplicates = false;

        //Map to set up values to find/compare Strings
        Map<String, Integer> leList = new LinkedHashMap<String,Integer>();

        for(String str : stringsList) {
            if (leList.containsKey(str)) {
                leList.put(str, leList.get(str) + 1);
                isDuplicates = true;
                break;
            }
            else {
                leList.put(str, 1);
            }
        }

        if(isDuplicates == true) {
            System.out.println("There is Duplicates");
        }
        else {
            System.out.println("No Duplicates");
        }
    }

    //Problem 2 - function that will check if string is palindrome (ANNA, LEVEL)
    public static boolean checkPalindrom(String word){

        boolean isPalindrome = false;

        //need to define letter placement
        int wordLength = word.length();
        int begin = 0;
        int end = wordLength - 1;
        int middle = (begin + end)/2;
        int i;  //keep track of placement (keep outside of loop)

        //use begin - middle, to match middle - end
        for(i = begin; i <= middle; i++){
            if(word.charAt(begin) == word.charAt(end)) {
                begin++;
                end--;
            }
            else {
                //isPalindrome = true;
                break;
            }
        }
        //check to see if "i" placement is center, with values from 'for-loop' same
        if(i == middle + 1) {
            isPalindrome = true;
            System.out.println("Palindrome");
        }
        else {
            System.out.println("Not a palindrome");
        }
        return isPalindrome;
    }


    //Problem 3
    //print out if
    //'fizz' is number divisible by 3
    //'buzz' is number divisible by 5
    //fizzbuzz is the number divisible by both and the integer for the rest
    //Can use a for loop for using the first 20 integers
    public static void fizzBuzz(int count){
        for(int i =0; i <= count; i++)
        {
            if(i%3 == 0 && i%5 != 0)
                System.out.println("Fizz");
            else if(i%3 != 0 && i%5 == 0)
                System.out.println("Buzz");
            else if(i%3 == 0 && i%5 ==0)
                System.out.println("FizzBuzz");
            else
                System.out.print(i + "\n");
        }
    }


    //Problem 4
    //create function to check the two strings are anagrams (COAT -> TACO)
    public static boolean checkAnagrams(String word1, String word2) {
        boolean isAnagram = false;

        //check character, increment count number of character
        Map<Character, Integer> leWord = new HashMap<>();

        for(char letter : word1.toCharArray()) {
            if(leWord.containsKey(letter)) {
                leWord.put(letter, leWord.get(letter) + 1);
            }
            else {
                leWord.put(letter,1);
            }
        }
        //compare the map containing "string" (array of char), to other word
        for(char letter : word2.toCharArray()) {
            if (!leWord.containsKey(letter)) {
                return false;
            }
            else {
                //continue loop until 0 -> match word length
                leWord.put(letter, leWord.get(letter) - 1);
                if(leWord.get(letter)==0) {
                    leWord.remove(letter);
                    isAnagram = true;
                }
            }
        }

        if(isAnagram == true) {
            System.out.println("Word is Anagram");
        }
        else {
            System.out.println("Not an Anagram");
        }

        return isAnagram;

    }

    //Problem 5
    //Print multiplication table from 1 - 10 using multidimensional array
    //EXAMPLE OUTPUT
    // 1 2 3 4 5 6 7 8 9 10
    // 2 4 6 8 10
    public static void printTables() {

        int[][] multiTable = new int[11][11];
        int varNum1, varNum2;
        for(int x = 1; x <= 10; x++) {
            varNum1=x;
            for(int y = 1; y <= 10; y++) {
                varNum2 = x*y;
                System.out.print((multiTable[x][y]) = varNum2 );
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
