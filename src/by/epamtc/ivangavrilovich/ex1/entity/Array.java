package by.epamtc.ivangavrilovich.ex1.entity;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    private int[] value;

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    public int length() {
        return this.value.length;
    }

    public Array() {

    }

    public Array(int ... value) {
        this.value = value;
    }

    public Array(Array arr) {
        this.value = arr.value;
    }

    public void insertionSort() {
        for (int i = 0; i < value.length; i++) {
            int current = value[i];
            int j = i;
            while (j > 0 && current < value[j - 1]) {
                value[j] = value[j - 1];
                j--;
            }
            value[j] = current;
        }
    }

    public void quickSort() {
        quickSort(0, value.length - 1);
    }

    private void quickSort(int low, int high) {
        if (value.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int pivot = value[middle];

        int i = low, j = high;
        while (i <= j) {
            while (value[i] < pivot) {
                i++;
            }

            while (value[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(low, j);

        if (high > i)
            quickSort(i, high);
    }

    public void enhancedBubbleSort() {
        boolean isNotSorted = true;
        while (isNotSorted) {
            isNotSorted = false;
            for (int i = 0; i < value.length -1; i++) {
                if (value[i] > value[i + 1]) {
                    isNotSorted = true;
                    swap(i, i + 1);
                }
            }
        }
    }

    private void swap(int firstIndex, int secondIndex) {
        value[secondIndex] ^= value[firstIndex];
        value[firstIndex] ^= value[secondIndex];
        value[secondIndex] ^= value[firstIndex];
    }

    public int get(int index) {
        return value[index];
    }


    /*
     * Sorts the array before search.
     * Returns -1 if the element is not present in the array.
     */
    public int binarySearch(int elem) {
        this.insertionSort();

        int low = 0;
        int high = value.length - 1;
        while (low <= high) {
            int pivot = low + (high - low) / 2;

            if (value[pivot] == elem) {
                return pivot;
            }

            if (value[pivot] < elem) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }

        return -1;
    }

    public int max() {
        int max = value[0];

        for (int curr : value) {
            if (curr > max) {
                max = curr;
            }
        }

        return max;
    }

    public int min() {
        int min = value[0];

        for (int curr : value) {
            if (curr < min) {
                min = curr;
            }
        }

        return min;
    }

    private boolean isPrime(int number) {
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int[] findPrimeNumbers() {
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int number : value) {
            if (isPrime(number)) {
                tmp.add(number);
            }
        }

        return copyToArray(tmp);
    }

    private boolean isFibonacci(int number) {
        return (Math.sqrt(Math.pow(number, 2) * 5 - 4)) % 1 == 0
                || (Math.sqrt(Math.pow(number, 2) * 5 + 4)) % 1 == 0;
    }

    public int[] findFibonacciNumbers() {
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int number : value) {
            if (isFibonacci(number)) {
                tmp.add(number);
            }
        }

        return copyToArray(tmp);
    }

    public boolean isUnique(int number) {
        String strNumber = Integer.toString(number);

        if (strNumber.length() != 3) {
            return false;
        }

        char[] charNumber = strNumber.toCharArray();

        for (int i = 0; i < charNumber.length; i++) {
            char curr = charNumber[i];
            for (int j = i + 1; j < charNumber.length; j++) {
                if (curr == charNumber[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public int[] findUniqueThreeDigitNumbers() {
        ArrayList<Integer> tmp = new ArrayList<>();

        for (int number : value) {
            if (isUnique(number)) {
                tmp.add(number);
            }
        }

        return copyToArray(tmp);
    }

    private int[] copyToArray(ArrayList<Integer> tmp) {
        int[] tmpArray = new int[tmp.size()];

        for (int i = 0; i < tmp.size(); i++) {
            tmpArray[i] = tmp.get(i);
        }
        return tmpArray;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Array that = (Array) obj;

        if (this.value.length != that.value.length) return false;
        for (int i = 0; i < this.value.length; i++) {
            if (this.value[i] != that.value[i]) return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "{" +
                "value = " + Arrays.toString(value) +
                "}";
    }
}
