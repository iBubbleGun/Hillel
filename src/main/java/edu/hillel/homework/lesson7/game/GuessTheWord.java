package edu.hillel.homework.lesson7.game;

import edu.hillel.homework.lesson7.game.methods.AdditionalLogic;

public class GuessTheWord extends AdditionalLogic {

    private String wordGameField;

    public GuessTheWord() {
        this.wordGameField = HIDDEN_SYMBOL.repeat(HIDDEN_SYMBOL_FIELD_LENGTH);
    }

    public GuessTheWord(String[] wordsArray) {
        super(wordsArray);
        this.wordGameField = HIDDEN_SYMBOL.repeat(HIDDEN_SYMBOL_FIELD_LENGTH);
    }

    public void start() {
        gameField(wordGameField, startMessage());
        while (true) {
            String userAnswer;
            while (true) {
                userAnswer = sc.nextLine();
                if (isWordsArrayContainWord(WORDS, userAnswer)) {
                    break;
                }
                gameField(wordGameField, wordDoesNotExist());
            }
            wordGameField = letterOpener(wordGameField, userAnswer);
            if (userAnswer.equals(HIDDEN_WORD) || isWordOpened) {
                gameField(clearHiddenWordField(), guessedTheWord());
                break;
            }
            gameField(wordGameField, (isLetterGuessed) ? wrongWordHot() : wrongWordCold());
            this.isLetterGuessed = false;
        }
    }
}
