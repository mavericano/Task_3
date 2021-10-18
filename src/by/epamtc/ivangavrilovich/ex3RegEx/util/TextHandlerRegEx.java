package by.epamtc.ivangavrilovich.ex3RegEx.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandlerRegEx {

    private String text;

    public void removeWordsStartingWithOdds(int length) {
        StringBuffer str = new StringBuffer(text);
        Pattern pattern = Pattern.compile("\\b[qwrtpsdfghjklzxcvbnm]+");
        Matcher matcher = pattern.matcher(text);
        int indexCorrection = 0;

        while (matcher.find()) {
            replaceWithSubstring(matcher.start() - indexCorrection, matcher.end() - indexCorrection, "", str);
            indexCorrection += length;
        }

        this.text = str.toString();
    }

    public void removeNonWordCharacters() {
        text = text.replaceAll("[^A-Za-z ]", "");
    }

    private void replaceWithSubstring(int start, int end, String replacement, StringBuffer str){
        str.delete(start, end + 1);
        str.insert(start, replacement);
    }

    public void replaceWordWithSubstring(int length, String replacement) {
        StringBuffer str = new StringBuffer(text);
        Pattern pattern = Pattern.compile("\\b\\w+");
        Matcher matcher = pattern.matcher(text);
        int amountOfReplaced = 0;
        int indexCorrection = replacement.length() - length + amountOfReplaced;

        while (matcher.find()) {
            if (length == (matcher.end() - matcher.start())) {
                replaceWithSubstring(matcher.start() + indexCorrection*amountOfReplaced, matcher.end() - 1 + indexCorrection*amountOfReplaced, replacement, str);
                amountOfReplaced++;
            }
        }

        this.text = str.toString();
    }

    private void correctWord(int start, int end, StringBuffer str) {
        String word = str.subSequence(start, end).toString();
        Pattern pattern = Pattern.compile("PA");
        Matcher matcher = pattern.matcher(word);

        while (matcher.find()) {
            str.replace(matcher.start() + start + 1, matcher.end() + start, "O");
        }
    }

    public void correctMisprint() {
        StringBuffer str = new StringBuffer(text);
        Pattern pattern = Pattern.compile("\\b\\w+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            correctWord(matcher.start(), matcher.end(), str);
        }

        this.text = str.toString();
    }

    private void doReplacements(int start, int replacementIndex, char replacement, StringBuffer str) {
        int index = start + replacementIndex;
        str.replace(index, index + 1, Character.toString(replacement));
    }

    public void replaceAtPosition(int k, char replacement) {
        int replacementIndex = k - 1;
        StringBuffer str = new StringBuffer(text);
        Pattern pattern = Pattern.compile("\\b\\w+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            if (replacementIndex <= (matcher.end() - matcher.start() - 1)) {
                doReplacements(matcher.start(), replacementIndex, replacement, str);
            }
        }

        this.text = str.toString();
    }

    public TextHandlerRegEx() {

    }

    public TextHandlerRegEx(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "text='" + text +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextHandlerRegEx that = (TextHandlerRegEx) o;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }
}
