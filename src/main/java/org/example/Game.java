package org.example;

import java.io.IOException;

public class Game {

    private  static String randomWord;

    static {
        try {
            randomWord = APIword.apiCall();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static char[] letters = new char[25];
    private static int lives = (int)Math.ceil(randomWord.length()/2);
    private static boolean userWon = false;
    private static int index = 0;

    public static String getWord () {
        return randomWord;
    }

    public static  void resetVariables () throws IOException {
        letters = new char[25];
        randomWord = APIword.apiCall();
        lives = (int)Math.ceil(randomWord.length()/2);
        userWon = false;
        index = 0;
    }

    public static void updateUserWin() {
        userWon=GameUtils.wasWordCompleted(randomWord,letters);
    }

    public static char[] getUserLetters () {
        return letters;
    }

    public static int getLives () {
        return lives;
    }

    public static void addInputLetter(char letter) {
        letters[index] = letter;
        index++;
    }

    public static void wasInputLetterCorrect () {
        if(!GameUtils.wasLetterCorrect(randomWord, letters[index-1])) {
            lives--;
        }
    }

    public static void play () {

        System.out.println("Welcome to the hangman, a name that perfectly describe how I felt while writing this code!");
        System.out.println("You have " + Game.getLives() + " lives to guess the word. Let's start");
        System.out.println("The word you have to guess is : ");
        System.out.println(GameUtils.displayWord(Game.getWord(), Game.getUserLetters()));
        while(lives > 0 && !userWon) {
            if(index>0) {
                System.out.println(GameUtils.displayWord(Game.getWord(), Game.getUserLetters()));
                System.out.println("You have " + Game.getLives() + " lives left");
            }
            addInputLetter(GameUtils.getInput());
            updateUserWin();
            wasInputLetterCorrect();
        }
        if(userWon && lives > 0) {
            System.out.println("You won, the word was");
            System.out.println(Game.getWord());
        } else {
            System.out.println("You lost your life baby!");
            System.out.println("The word was : " + Game.getWord());
        }
    }

}
