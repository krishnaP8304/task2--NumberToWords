import java.util.Scanner;

public class NumberToWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number:");
        int number = scanner.nextInt();
        scanner.close();

        String wordRepresentation = convertToWords(number);
        System.out.println("Sample Output:");
        System.out.println(wordRepresentation);
    }

    public static String convertToWords(int number) {
        String[] units = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        if (number == 0) {
            return "zero";
        }

        StringBuilder wordRepresentation = new StringBuilder();

        // Convert millions
        if (number >= 1000000) {
            wordRepresentation.append(convertToWords(number / 1000000)).append(" million ");
            number %= 1000000;
        }

        // Convert thousands
        if (number >= 1000) {
            wordRepresentation.append(convertToWords(number / 1000)).append(" thousand ");
            number %= 1000;
        }

        // Convert hundreds
        if (number >= 100) {
            wordRepresentation.append(units[number / 100]).append(" hundred ");
            number %= 100;
        }

        // Convert tens and units
        if (number >= 20) {
            wordRepresentation.append(tens[number / 10]).append(" ");
            number %= 10;
        } else if (number >= 10) {
            wordRepresentation.append(teens[number - 10]).append(" ");
            number = 0;
        }

        if (number > 0) {
            wordRepresentation.append(units[number]).append(" ");
        }

        return wordRepresentation.toString().trim();
    }
}
