package by.epamtc.ivangavrilovich.ex3RegEx.util;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TextHandlerRegExTest {
    @Test
    public void removeWordsStartingWithOdds_Test() {
        TextHandlerRegEx txt = new TextHandlerRegEx("ab1 bbcd ab dbcd aPAx aP");
        String expected = "ab1 ab aPAx aP";

        txt.removeWordsStartingWithOdds(4);
        String actual = txt.getText();

        assertEquals(expected, actual);
    }

    @Test
    public void removeNonWordCharacters_Test() {
        TextHandlerRegEx txt = new TextHandlerRegEx("ab1 bbcd ab db1cd aPAx aP");
        String expected = "ab bbcd ab dbcd aPAx aP";

        txt.removeNonWordCharacters();
        String actual = txt.getText();

        assertEquals(expected, actual);
    }

    @Test
    public void replaceWordWithSubstring_Test() {
        TextHandlerRegEx txt = new TextHandlerRegEx("abc bbcd ab dbcd aPAx aP");
        String expected = "abc 12345 ab 12345 12345 aP";

        txt.replaceWordWithSubstring(4, "12345");
        String actual = txt.getText();

        assertEquals(expected, actual);
    }

    @Test
    public void correctMisprint_Test() {
        TextHandlerRegEx txt = new TextHandlerRegEx("abc bbcd ab dbcd aPAx aP");
        String expected = "abc bbcd ab dbcd aPOx aP";

        txt.correctMisprint();
        String actual = txt.getText();

        assertEquals(expected, actual);
    }

    @Test
    public void replaceAtIndex_Test() {
        TextHandlerRegEx txt = new TextHandlerRegEx("abc bbcd ab dbcd aPAx aP");
        String expected = "ab1 bb1d ab db1d aP1x aP";

        txt.replaceAtPosition(3, '1');
        String actual = txt.getText();

        assertEquals(expected, actual);
    }
}