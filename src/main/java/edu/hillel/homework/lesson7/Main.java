package edu.hillel.homework.lesson7;

import edu.hillel.homework.lesson7.game.GuessTheWord;
import edu.hillel.homework.lesson7.stringmethods.StringMethodsUse;

public class Main {

    public static void main(String[] args) {

        StringMethodsUse smu = new StringMethodsUse(); // String methods
        GuessTheWord gameGuessTheWord = new GuessTheWord(); // The game "Guess The Word"

        smu.delimiter(1);
        // Attention, the method is case-sensitive.
        System.out.println(smu.findSymbolOccurance("abAcaabbccABCAABsfhgjaklBCC", 'B'));

        smu.delimiter(2);
        // Attention, the method is case-sensitive.
        System.out.println(smu.findWordPosition("Abcdefghi", "efgh"));

        smu.delimiter(3);
        System.out.println(smu.stringReverse("Abcdefghi"));

        smu.delimiter(4);
        // The method is not case-sensitive.
        System.out.println(smu.isPalindrome("Abcdcba"));

        smu.delimiter(5);
        gameGuessTheWord.start();
    }
}
