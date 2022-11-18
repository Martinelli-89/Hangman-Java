package org.example;

import java.util.Scanner;

public class GameUtils {

    static String displayWord(String word, char[] userInputs) {

        String result = "";
        char[] convertWord = word.toCharArray();
        for(char letter : convertWord) {
            if(new String(userInputs).contains(""+letter)) {
                result += letter;
            } else {
                result += "_";
            }
        }
        return result;
    }

    static boolean wasWordCompleted(String word, char[] userInputs) {
        boolean isWordComplete = true;
        char[] convertWord = word.toCharArray();
        for(char letter : convertWord) {
            if(new String(userInputs).contains(""+letter) == false) {
                isWordComplete= false;
            }
        }
        return isWordComplete;
    }

    static boolean wasLetterCorrect(String word, char userInput) {
        boolean isLetterRight = false;
        char[] convertWord = word.toCharArray();
        if(word.contains(""+userInput)) {
            isLetterRight= true;
        }
        return isLetterRight;
    }

    static boolean validateInput(String input) {
        if(input.length() > 1 || input.length() < 1 || new String(Game.getUserLetters()).contains(input)) {
            if (new String(Game.getUserLetters()).contains(input)) {
                System.out.println("You already entered this letter");
            }
            return false;
        } else {
            return true;
        }
    }

    static char getInput () {
        Scanner getLetter = new Scanner(System.in);
        boolean loop = true;
        String input="";
        while(loop) {
            System.out.println("Enter letter");
            input = getLetter.nextLine().toLowerCase();
            boolean isValid = validateInput(input);
            if (Character.isLetter(input.charAt(0)) == false) {
                isValid = false;
            }
            if(isValid) {
                loop = false;
            } else {
                System.out.println("Please enter a valid input");
            }
        }
        return input.charAt(0);
    }

}
