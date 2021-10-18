package by.epamtc.ivangavrilovich.ex3.util;

import java.util.Set;

public class TextHandler {
    private  String text;

    //fix

    public void removeWordsStartingWithOdds(int length) {
        Set<Character> odds = Set.of('q', 'w', 'r', 't', 'p', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm');
        StringBuffer str = new StringBuffer();
        char c;
        int wordBeginning = 0;
        int wordEnding = 0;
        int indexCorrection = 0;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (c == ' ') {
                wordEnding = i - 1;
                if ((wordEnding - wordBeginning + 1 == length) && odds.contains(text.charAt(wordBeginning))) {
                    replaceWithSubstring(wordBeginning - indexCorrection, wordEnding - indexCorrection, "", str);
                    indexCorrection += length;
                }
                wordBeginning = i + 1;
                str.append(" ");
            } else {
                str.append(c);
                wordEnding++;
            }
        }
        if ((wordEnding - wordBeginning + 1 == length) && odds.contains(text.charAt(wordBeginning))) {
            replaceWithSubstring(wordBeginning - indexCorrection, wordEnding - indexCorrection, "", str);
        }

        this.text = str.toString();
    }
    public void removeNonWordCharacters() {
        StringBuffer str = new StringBuffer();
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if ((c > 64 && c < 91) || (c > 96 && c < 123) || (c == ' ')) {
                str.append(c);
            }
        }

        this.text = str.toString();
    }

    private void replaceWithSubstring(int start, int end, String replacement, StringBuffer str){
        str.delete(start, end + 1);
        str.insert(start, replacement);
    }

    public void replaceWordWithSubstring(int length, String replacement) {
        int wordBeginning = 0;
        int wordEnding = 0;
        StringBuffer str = new StringBuffer();
        int amountOfReplaced = 0;
        int indexCorrection = replacement.length() - length + amountOfReplaced;
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (c == ' ') {
                wordEnding = i - 1;
                if (wordEnding - wordBeginning + 1 == length) {
                    replaceWithSubstring(wordBeginning + indexCorrection*amountOfReplaced, wordEnding + indexCorrection*amountOfReplaced, replacement, str);
                    amountOfReplaced++;
                }
                wordBeginning = i + 1;
                str.append(" ");
            } else {
                str.append(c);
                wordEnding++;
            }
        }
        if (wordEnding - wordBeginning == length) {
            replaceWithSubstring(wordBeginning, wordEnding, replacement, str);
        }

        this.text = str.toString();
    }

    private void correctWord(int start, int end, StringBuffer str) {
        boolean isPreP = false;

        for (int i = start; i < end; i++) {
            if (isPreP) {
                if (str.charAt(i) == 'A') {
                    System.out.println("repl");
                    str.replace(i, i + 1, "O");
                    isPreP = false;
                }
            }
            if ('P' == str.charAt(i)) {
                isPreP = true;
                System.out.println("isPreP");
            }
        }
    }

    public void correctMisprint() {
        int wordBeginning = 0;
        int wordEnding = 0;
        StringBuffer str = new StringBuffer();
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (c == ' ') {
                wordEnding = i - 1;
                correctWord(wordBeginning, wordEnding, str);
                wordBeginning = i + 1;
                str.append(" ");
            } else {
                str.append(c);
                wordEnding++;
            }
        }
        correctWord(wordBeginning, wordEnding, str);

        this.text = str.toString();
    }

    private void doReplacements(int start, int replacementIndex, char replacement, StringBuffer str) {
        int index = start + replacementIndex;
        str.replace(index, index + 1, Character.toString(replacement));
    }

    public void replaceAtIndex(int k, char replacement) {
        int replacementIndex = k - 1;
        int wordBeginning = 0;
        int wordEnding = 0;
        StringBuffer str = new StringBuffer();
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (c == ' ') {
                wordEnding = i - 1;
                if (replacementIndex <= (wordEnding - wordBeginning)) {
                    doReplacements(wordBeginning, replacementIndex, replacement, str);
                }
                wordBeginning = i + 1;
                str.append(" ");
            } else {
                str.append(c);
                wordEnding++;
            }
        }
        if (replacementIndex <= (wordEnding - wordBeginning)) {
            doReplacements(wordBeginning, replacementIndex, replacement, str);
        }

        this.text = str.toString();
    }

    public TextHandler() {
    }

    public TextHandler(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextHandler that = (TextHandler) o;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{" +
                "text='" + text +
                '}';
    }
}
