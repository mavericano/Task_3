package by.epamtc.ivangavrilovich.ex2.util;

import by.epamtc.ivangavrilovich.ex2.template.Sorter;

import java.util.Arrays;

public class JaggedArraySorter {

    public static void swap(int[] source, int firstIndex, int secondIndex) {
        source[secondIndex] ^= source[firstIndex];
        source[firstIndex] ^= source[secondIndex];
        source[secondIndex] ^= source[firstIndex];
    }

    public static int binarySearchAscending(int[] source, int elem) {
        int low = 0;
        int high = source.length - 1;
        while (low <= high) {
            int pivot = low + (high - low) / 2;

            if (source[pivot] == elem) {
                return pivot;
            }

            if (source[pivot] < elem) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }

        return -1;
    }

    public static int binarySearchDescending(int[] source, int elem) {
        int low = 0;
        int high = source.length - 1;
        while (low <= high) {
            int pivot = low + (high - low) / 2;

            if (source[pivot] == elem) {
                return pivot;
            }

            if (source[pivot] > elem) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }

        return -1;
    }

    private static int[] bubbleSortAscending(int[] source) {
        int[] initial = source.clone();
        int[] replacements = new int[source.length];

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

        for (int i = 0; i < source.length; i++) {
            replacements[i] = binarySearchAscending(initial, source[i]);
        }

        return replacements;
    }

    private static int[] bubbleSortDescending(int[] source) {
        int[] initial = source.clone();
        int[] replacements = new int[source.length];

        boolean isNotSorted = true;
        while (isNotSorted) {
            isNotSorted = false;
            for (int i = 0; i < initial.length -1; i++) {
                if (initial[i] < initial[i + 1]) {
                    isNotSorted = true;
                    swap(initial, i, i + 1);
                }
            }
        }

        for (int i = 0; i < source.length; i++) {
            replacements[i] = binarySearchDescending(initial, source[i]);
        }

        return replacements;
    }

    private static int[] computeSums(int[][] source) {
        int[] sums = new int[source.length];
        int currSum;

        for (int i = 0; i < source.length; i++) {
            int[] line = source[i];
            currSum = 0;
            for (int elem: line) {
                currSum += elem;
            }
            sums[i] = currSum;
        }

        return sums;
    }

    public static void sortBySumAscending(int[][] source) {
        int[] sums = computeSums(source);

        int[] replacements = bubbleSortAscending(sums);

        doReplacements(source, replacements);
    }

    public static void sortBySumDescending(int[][] source) {
        int[] sums = computeSums(source);

        int[] replacements = bubbleSortDescending(sums);

        doReplacements(source, replacements);
    }

    private static int[] findMins(int[][] source) {
        int[] mins = new int[source.length];
        int currMin;

        for (int i = 0; i < source.length; i++) {
            currMin = source[i][0];
            for (int elem : source[i]) {
                if (elem < currMin) {
                    currMin = elem;
                }
            }
            mins[i] = currMin;
        }

        return mins;
    }

    public static void sortByMinAscending(int[][] source) {
        int[] mins = findMins(source);

        int[] replacements = bubbleSortAscending(mins);

        doReplacements(source, replacements);
    }

    public static void sortByMinDescending(int[][] source) {
        int[] mins = findMins(source);

        int[] replacements = bubbleSortDescending(mins);

        doReplacements(source, replacements);
    }

    private static int[] findMaxs(int[][] source) {
        int[] maxs = new int[source.length];
        int currMax;

        for (int i = 0; i < source.length; i++) {
            currMax = source[i][0];
            for (int elem : source[i]) {
                if (elem > currMax) {
                    currMax = elem;
                }
            }
            maxs[i] = currMax;
        }

        return maxs;
    }

    public static void sortByMaxAscending(int[][] source) {
        int[] maxs = findMaxs(source);

        int[] replacements = bubbleSortAscending(maxs);

        doReplacements(source, replacements);
    }

    public static void sortByMaxDescending(int[][] source) {
        int[] maxs = findMaxs(source);

        int[] replacements = bubbleSortDescending(maxs);

        doReplacements(source, replacements);
    }

    private static void doReplacements(int[][] source, int[] replacements) {
        int[][] tmp = source.clone();
        for (int i = 0; i < source.length; i++) {
            source[replacements[i]] = tmp[i];
        }
    }

    public static void sort(int[][] source, Sorter sorter) {
        int[] criteria = sorter.findCriteria();

        int[] replacements = sorter.findReplacements(criteria);

        doReplacements(source, replacements);
    }
}
