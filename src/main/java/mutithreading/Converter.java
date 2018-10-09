package mutithreading;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private static int result = 0;
    private static int finalResult = 0;

    public static Integer converterFromStringsToNumbers(String number) throws NumberFormatException{
        if (number == null || number.length() < 1) {
            throw new NumberFormatException();
        }
        finalResult = 0;
        result = 0;
        List<String> num = Arrays.asList(number.split(" "));
        num.forEach(Converter::digit);
        return finalResult += result;
    }

    private static void digit(String number) {
        if (number.equalsIgnoreCase("one")) {
            result += 1;
        } else if (number.equalsIgnoreCase("two")) {
            result += 2;
        } else if (number.equalsIgnoreCase("three")) {
            result += 3;
        } else if (number.equalsIgnoreCase("four")) {
            result += 4;
        } else if (number.equalsIgnoreCase("five")) {
            result += 5;
        } else if (number.equalsIgnoreCase("six")) {
            result += 6;
        } else if (number.equalsIgnoreCase("seven")) {
            result += 7;
        } else if (number.equalsIgnoreCase("eight")) {
            result += 8;
        } else if (number.equalsIgnoreCase("nine")) {
            result += 9;
        } else if (number.equalsIgnoreCase("ten")) {
            result += 10;
        } else if (number.equalsIgnoreCase("eleven")) {
            result += 11;
        } else if (number.equalsIgnoreCase("twelve")) {
            result += 12;
        } else if (number.equalsIgnoreCase("thirteen")) {
            result += 13;
        } else if (number.equalsIgnoreCase("fourteen")) {
            result += 14;
        } else if (number.equalsIgnoreCase("fifteen")) {
            result += 15;
        } else if (number.equalsIgnoreCase("sixteen")) {
            result += 16;
        } else if (number.equalsIgnoreCase("seventeen")) {
            result += 17;
        } else if (number.equalsIgnoreCase("eighteen")) {
            result += 18;
        } else if (number.equalsIgnoreCase("nineteen")) {
            result += 19;
        } else if (number.equalsIgnoreCase("twenty")) {
            result += 20;
        } else if (number.equalsIgnoreCase("thirty")) {
            result += 30;
        } else if (number.equalsIgnoreCase("forty")) {
            result += 40;
        } else if (number.equalsIgnoreCase("fifty")) {
            result += 50;
        } else if (number.equalsIgnoreCase("sixty")) {
            result += 60;
        } else if (number.equalsIgnoreCase("seventy")) {
            result += 70;
        } else if (number.equalsIgnoreCase("eighty")) {
            result += 80;
        } else if (number.equalsIgnoreCase("ninety")) {
            result += 90;
        } else if (number.equalsIgnoreCase("hundred")) {
            result *= 100;
        } else if (number.equalsIgnoreCase("thousand")) {
            result *= 1000;
            finalResult += result;
            result=0;
        } else {
            throw new NumberFormatException();
        }
    }
}
