package by.epamtc.ivangavrilovich.runner;

import by.epamtc.ivangavrilovich.ex1.util.ArrayFiller;
import by.epamtc.ivangavrilovich.ex1.entity.Array;
import by.epamtc.ivangavrilovich.ex2.template.Sorter;
import by.epamtc.ivangavrilovich.ex2.util.JaggedArraySorter;
import by.epamtc.ivangavrilovich.ex3RegEx.util.TextHandlerRegEx;

import java.util.Arrays;

import static by.epamtc.ivangavrilovich.ex2.util.JaggedArraySorter.binarySearchAscending;
import static by.epamtc.ivangavrilovich.ex2.util.JaggedArraySorter.swap;

public class Runner {

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
        JaggedArraySorter.sort(tmp2, new Sorter() {
            @Override
            public int[] findCriteria() {
                int[] maxs = new int[tmp2.length];
                int currMax;

                for (int i = 0; i < tmp2.length; i++) {
                    currMax = tmp2[i][0];
                    for (int elem : tmp2[i]) {
                        if (elem > currMax) {
                            currMax = elem;
                        }
                    }
                    maxs[i] = currMax;
                }

                return maxs;
            }

            @Override
            public int[] findReplacements(int[] criteria) {
                int[] initial = criteria.clone();
                int[] replacements = new int[criteria.length];

                boolean isNotSorted = true;
                while (isNotSorted) {
                    isNotSorted = false;
                    for (int i = 0; i < initial.length -1; i++) {
                        if (initial[i] > initial[i + 1]) {
                            isNotSorted = true;
                            swap(initial, i, i + 1);
                        }
                    }
                }

                for (int i = 0; i < criteria.length; i++) {
                    replacements[i] = binarySearchAscending(initial, criteria[i]);
                }

                return replacements;
            }
        });

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
