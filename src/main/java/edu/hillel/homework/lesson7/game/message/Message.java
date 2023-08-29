package edu.hillel.homework.lesson7.game.message;

import edu.hillel.homework.lesson7.game.setup.InitialSetup;

public class Message extends InitialSetup {

    protected Message() {
        // need default empty
    }

    protected Message(String[] wordsArray) {
        super(wordsArray);
    }

    protected void gameField(String str, String msg) {
        System.out.println("\n+".concat("-".repeat(50)).concat("+")
                + "\n|".concat(" ".repeat(18)).concat("Guess The Word").concat(" ".repeat(18)).concat("|")
                + "\n+".concat("-".repeat(50)).concat("+")
                + "\n|".concat(" ".repeat(50)).concat("|")
                + "\n|".concat(" ".repeat(18)).concat(str).concat(" ".repeat(18)).concat("|")
                + "\n|".concat(" ".repeat(50)).concat("|")
                + "\n+".concat("-".repeat(50)).concat("+"));
        System.out.print(msg);
    }

    protected String startMessage() {
        return "Guess the hidden word!\n" +
                "Write your own version of the word: ";
    }

    protected String wordDoesNotExist() {
        return "This word does not exist in the list!\n" +
                writeAnotherWord();
    }
    protected String guessedTheWord() {
        return "Congratulations!\n" +
                "You guessed the word!";
    }

    protected String wrongWordCold() {
        return "I'm sorry, but you did not guess the whole word, not at least one letter from the hidden word.\n" +
                writeAnotherWord();
    }

    protected String wrongWordHot() {
        return "I'm sorry, but you didn't guess the whole word.\n" +
                "But you guessed at least one letter from the hidden word!\n" +
                writeAnotherWord();
    }

    private String writeAnotherWord() {
        return "Write your another version of the word: ";
    }
}
