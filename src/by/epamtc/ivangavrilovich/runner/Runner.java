package by.epamtc.ivangavrilovich.runner;

import by.epamtc.ivangavrilovich.ex1.util.ArrayFiller;
import by.epamtc.ivangavrilovich.ex1.entity.Array;
import by.epamtc.ivangavrilovich.ex2.util.JaggedArraySorter;
import by.epamtc.ivangavrilovich.ex3.util.TextHandler;
import by.epamtc.ivangavrilovich.ex3RegEx.util.TextHandlerRegEx;

import java.util.Arrays;

public class Runner {

    /*
     * TODO: return array
     */

    public static void main(String[] args) {
        Array array = new Array(16, 9, 7, 5, 9, 17);
        //Array array2 = ArrayFiller.fillFromConsole();
        Array array3 = ArrayFiller.fillFromFile("input/test.txt");
        System.out.println(array3);

        //System.out.println(array2);
        System.out.println(array);
        System.out.println(array.binarySearch(16));

        //array.enhancedBubbleSort();

        System.out.println(array);
        System.out.println(array.binarySearch(16));

        //int[] tmp = {1, 2, 3};

        System.out.println(array.isUnique(123));

        int[][] tmp = {{1, 2, 3}, {0, 0, 0, 0}, {16}, {1, 0, 4, -8}};
        int[][] tmp2 = {{1, 2, 3}, {0, 0, 0, 0}, {16, -16}, {1, 0, 4, -8}};

        JaggedArraySorter.sortByMinAscending(tmp);
        JaggedArraySorter.sortBySumDescending(tmp2);

        for(int[] line : tmp) {
            System.out.println(Arrays.toString(line));
        }

        for(int[] line : tmp2) {
            System.out.println(Arrays.toString(line));
        }

        TextHandlerRegEx txt = new TextHandlerRegEx("ab1 bbcd ab dbcd aPAx aP");

        txt.removeWordsStartingWithOdds(4);

        System.out.println(txt);
    }

}
