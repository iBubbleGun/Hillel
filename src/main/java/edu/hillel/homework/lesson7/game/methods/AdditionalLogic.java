package edu.hillel.homework.lesson7.game.methods;

import edu.hillel.homework.lesson7.game.message.Message;

public class AdditionalLogic extends Message {

    protected AdditionalLogic() {
        // need default empty
    }

    protected AdditionalLogic(String[] wordsArray) {
        super(wordsArray);
    }

    protected String letterOpener(String currentWordInGameField, String userAnswer) {
        char[] currentWordInGameFieldCharArray = currentWordInGameField.toCharArray();
        int len;
        String result;
        if (HIDDEN_WORD.length() <= userAnswer.length()) {
            len = HIDDEN_WORD.length();
        } else {
            len = userAnswer.length();
        }
        for (int i = 0; i < len; i++) {
            if (HIDDEN_WORD.charAt(i) == userAnswer.charAt(i)) {
                currentWordInGameFieldCharArray[i] = HIDDEN_WORD.charAt(i);
                this.isLetterGuessed = true;
            }
        }
        result = new String(currentWordInGameFieldCharArray);
        if (isTheWholeWordIsOpen(result)) {
            this.isWordOpened = true;
            return clearHiddenWordField();
        }
        return result;
    }

    protected boolean isWordsArrayContainWord(String[] wordsArray, String word) {
        for (String s : wordsArray) {
            if (s.equals(word)) {
                return true;
            }
        }
        return false;
    }

    protected boolean isTheWholeWordIsOpen(String s) {
        return HIDDEN_WORD.equals(s.substring(0, HIDDEN_WORD.length()));
    }

    protected String clearHiddenWordField() {
        return HIDDEN_WORD.concat(" ".repeat(HIDDEN_SYMBOL_FIELD_LENGTH - HIDDEN_WORD.length()));
    }
}
