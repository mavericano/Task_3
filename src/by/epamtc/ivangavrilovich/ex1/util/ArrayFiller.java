package by.epamtc.ivangavrilovich.ex1.util;

import by.epamtc.ivangavrilovich.ex1.entity.Array;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayFiller {

    public static Array fillFromFile(String path) throws IllegalArgumentException {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException();
        }

        return new Array(copyToArray(lines));
    }

    private static int[] copyToArray(ArrayList<String> tmp) {
        int[] tmpArray = new int[tmp.size()];

        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i).matches("^-*[1-9][0-9]*$")) {
                tmpArray[i] = Integer.parseInt(tmp.get(i));
            }
        }
        return tmpArray;
    }

    public static Array fillFromConsole() {
        ArrayList<Integer> tmp = new ArrayList<>();

        int length = readNumber("^[1-9][0-9]*$");
        return new Array(readArray(length));
    }

    private static int[] readArray(int length) {
        int[] array = new int[length];

        for (int i = 0; i < length; i++) {
            array[i] = readNumber("^-*[1-9][0-9]*$");
        }

        return array;
    }

    private static int readNumber(String regex) {
        String input;
        Scanner scanner = new Scanner(System.in);

        do {
            input = scanner.nextLine();
        } while (!input.matches(regex));

        return Integer.parseInt(input);
    }

}
