package mutithreading;

public class Converter {

    public static String converterFromNumberToString(final int n) {
        String[] units = {"", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};

        String[] tens = {
                "",        // 0
                "",            // 1
                "twenty",    // 2
                "thirty",    // 3
                "forty",    // 4
                "fifty",    // 5
                "sixty",    // 6
                "seventy",    // 7
                "eighty",    // 8
                "ninety"    // 9
        };

        if (n < 20) {
            return units[n];
        }

        if (n < 100) {
            return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
        }

        if (n < 1000) {
            return units[n / 100] + " hundred" + ((n % 100 != 0) ? " " : "") + converterFromNumberToString(n % 100);
        }

        if (n < 100000) {
            return converterFromNumberToString(n / 1000) + " thousand" + ((n % 10000 != 0) ? " " : "") + converterFromNumberToString(n % 1000);
        }
        throw new NumberFormatException();
    }

    public static Integer converterFromStringToNumber(String number) throws NumberFormatException {
        if (number == null || number.length() < 1) {
            throw new NumberFormatException();
        }

        int finalResult = 0;
        int result = 0;
        String[] num = number.split(" ");
        for (String str : num) {
            result = digit(str, result);
            if (str.equalsIgnoreCase("thousand")) {
                finalResult += result;
                result = 0;
            }
        }
        return finalResult + result;
    }

    private static int digit(String number, int result) {
        if (number.equalsIgnoreCase("one")) {
            return result + 1;
        } else if (number.equalsIgnoreCase("two")) {
            return result + 2;
        } else if (number.equalsIgnoreCase("three")) {
            return result + 3;
        } else if (number.equalsIgnoreCase("four")) {
            return result + 4;
        } else if (number.equalsIgnoreCase("five")) {
            return result + 5;
        } else if (number.equalsIgnoreCase("six")) {
            return result + 6;
        } else if (number.equalsIgnoreCase("seven")) {
            return result + 7;
        } else if (number.equalsIgnoreCase("eight")) {
            return result + 8;
        } else if (number.equalsIgnoreCase("nine")) {
            return result + 9;
        } else if (number.equalsIgnoreCase("ten")) {
            return result + 10;
        } else if (number.equalsIgnoreCase("eleven")) {
            return result + 11;
        } else if (number.equalsIgnoreCase("twelve")) {
            return result + 12;
        } else if (number.equalsIgnoreCase("thirteen")) {
            return result + 13;
        } else if (number.equalsIgnoreCase("fourteen")) {
            return result + 14;
        } else if (number.equalsIgnoreCase("fifteen")) {
            return result + 15;
        } else if (number.equalsIgnoreCase("sixteen")) {
            return result + 16;
        } else if (number.equalsIgnoreCase("seventeen")) {
            return result + 17;
        } else if (number.equalsIgnoreCase("eighteen")) {
            return result + 18;
        } else if (number.equalsIgnoreCase("nineteen")) {
            return result + 19;
        } else if (number.equalsIgnoreCase("twenty")) {
            return result + 20;
        } else if (number.equalsIgnoreCase("thirty")) {
            return result + 30;
        } else if (number.equalsIgnoreCase("forty")) {
            return result + 40;
        } else if (number.equalsIgnoreCase("fifty")) {
            return result + 50;
        } else if (number.equalsIgnoreCase("sixty")) {
            return result + 60;
        } else if (number.equalsIgnoreCase("seventy")) {
            return result + 70;
        } else if (number.equalsIgnoreCase("eighty")) {
            return result + 80;
        } else if (number.equalsIgnoreCase("ninety")) {
            return result + 90;
        } else if (number.equalsIgnoreCase("hundred")) {
            return result * 100;
        } else if (number.equalsIgnoreCase("thousand")) {
            return result * 1000;
        } else {
            throw new NumberFormatException();
        }
    }
}
