package edu.hillel.homework.lesson7.game.setup;

import java.util.Random;
import java.util.Scanner;

public class InitialSetup {

    private final Random rnd;
    protected final Scanner sc;
    protected final String[] WORDS;
    protected final String HIDDEN_WORD;
    protected final String HIDDEN_SYMBOL = "#";
    protected final int HIDDEN_SYMBOL_FIELD_LENGTH = 14;
    protected boolean isLetterGuessed;
    protected boolean isWordOpened;

    protected InitialSetup() {
        this.WORDS = new String[]{
                "apple",
                "orange",
                "lemon",
                "banana",
                "apricot",
                "avocado",
                "broccoli",
                "carrot",
                "cherry",
                "garlic",
                "grape",
                "melon",
                "leak",
                "kiwi",
                "mango",
                "mushroom",
                "nut",
                "olive",
                "pea",
                "peanut",
                "pear",
                "pepper",
                "pineapple",
                "pumpkin",
                "potato"
        };

        this.sc = new Scanner(System.in);
        this.rnd = new Random();
        this.HIDDEN_WORD = WORDS[rnd.nextInt(WORDS.length)];
        this.isLetterGuessed = false;
        this.isWordOpened = false;
    }

    protected InitialSetup(String[] wordsArray) {
        this.WORDS = wordsArray;
        this.sc = new Scanner(System.in);
        this.rnd = new Random();
        this.HIDDEN_WORD = WORDS[rnd.nextInt(WORDS.length)];
        this.isLetterGuessed = false;
        this.isWordOpened = false;
    }
}
