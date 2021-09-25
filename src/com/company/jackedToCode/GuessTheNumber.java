package com.company.jackedToCode;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private final Scanner scan;
    private final int range;
    private final int random;
    private final boolean cheat = true;
    public static int numberOfGuesses = 7;
    public static boolean isCorrect = false;

    public GuessTheNumber(int range){
        Random myRandom = new Random();
        this.scan = new Scanner(System.in);
        this.range = range;
        this.random = myRandom.nextInt(range) +1;

        cheatCodes();
        gameLoop();
    }

    public void gameLoop(){
        System.out.printf("Gæt på et nummer mellem 1 og %d\n", range);
        System.out.printf("Du har %d gæt\n", numberOfGuesses);
        while(numberOfGuesses > 0 && !isCorrect){
            feedback();
            numberOfGuesses--;

            if (!isCorrect){
                System.out.printf("Gæt tilbage : " + numberOfGuesses + "\n");
            } else {
                System.out.println("Tillykke med det!");
            }
            if (numberOfGuesses == 0 && !isCorrect) {
                System.out.println("Du Tabte!");
            }

        }
    }

    public void highterOrLower(int guess){
        if (guess < random){
            System.out.println("Højere!");
        } else {
            System.out.println("Lavere!");
        }
    }

    public void feedback() {
        int guess = getUserInput();
        if(random == guess){
            System.out.printf("Nummeret er %d, du har ret..\n", random);
            isCorrect = true;
        } else if (guess > 0 && guess <= range) {
            highterOrLower(guess);
        } else {
            System.out.println("Det indtastede passer ikke ind, prøv igen..");
            feedback();
        }
    }

    private int getUserInput() {

        try {
            return Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException ex){
            return 0;
        }
    }

    private void cheatCodes(){
        if (cheat){
            System.out.println("CHEAT!!! : RANDOM NUMBER IS : " + random);
        }
    }
}
