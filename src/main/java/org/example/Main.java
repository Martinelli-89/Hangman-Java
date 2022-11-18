package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static boolean playAgain = true;

    public static void main(String[] args) throws IOException {
        Scanner get = new Scanner(System.in);
        while(playAgain) {
            Game.play();
            System.out.println("Would you like to play again? Enter yes or anything else to quit");
            String response = get.nextLine().toLowerCase();
            if(!response.equals("yes")) {
                playAgain = false;
            }
            Game.resetVariables();
        }
        System.out.println("Thanks to play my game. Have a lovely day!");
    }
}