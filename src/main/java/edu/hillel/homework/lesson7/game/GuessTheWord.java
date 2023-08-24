package edu.hillel.homework.lesson7.game;

import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {

    private final String[] WORDS;
    private final Scanner sc;
    private final Random rnd;
    private final String HIDDEN_WORD;
    private final int HIDDEN_LETTERS_FIELD_LENGTH;

    public GuessTheWord() {
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
        this.HIDDEN_WORD = WORDS[rnd.nextInt(WORDS.length - 1)];
        this.HIDDEN_LETTERS_FIELD_LENGTH = 14;
    }

    public GuessTheWord(String[] wordsArray) {
        this.WORDS = wordsArray;
        this.sc = new Scanner(System.in);
        this.rnd = new Random();
        this.HIDDEN_WORD = WORDS[rnd.nextInt(WORDS.length - 1)];
        this.HIDDEN_LETTERS_FIELD_LENGTH = 14;
    }

    public void start() {

        String wordInGameField = "#".repeat(HIDDEN_LETTERS_FIELD_LENGTH);
        String answer;
        gameField(wordInGameField, "Guess the hidden word!\nWrite your own version of the word: ");

        while (true) {
            while (true) {
                answer = sc.nextLine();
                if (isWordsArrayContainWord(WORDS, answer)) {
                    break;
                }
                gameField(wordInGameField, "This word does not exist in the list!\nWrite your own version of the word: ");
            }
            if (answer.equals(HIDDEN_WORD)) {
                gameField(HIDDEN_WORD.concat(" ".repeat(HIDDEN_LETTERS_FIELD_LENGTH - HIDDEN_WORD.length())),"You win!");
                break;
            }
            // wordInGameField = letterOpener(answer); // here
            gameField(wordInGameField,"You wrong!\nWrite your another version of the word: ");
        }
    }

    private void gameField(String str, String msg) {
        System.out.println();
        System.out.println(HIDDEN_WORD);
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                  Guess The Word                  |");
        System.out.println("+--------------------------------------------------+");
        System.out.println("|                                                  |");
        System.out.println("|                  " + str + "                  |");
        System.out.println("|                                                  |");
        System.out.println("+--------------------------------------------------+");
        System.out.print(msg);
    }

    private String letterOpener(String str) {
        // not complete yet
        return str;
    }

    private boolean isWordsArrayContainWord(String[] wordsArray, String word) {
        for (String s : wordsArray) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
