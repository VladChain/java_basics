import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(splitTextInToWords(text));
    }

    public static String splitTextInToWords(String text) {

        text = text.replaceAll("[\\d,.;]", "")
                .replaceAll("-", " ");
        String[] output = text.split("\\s+");
        StringBuilder words = new StringBuilder();
        for (int i = 0; i < output.length; i++) {
            if (i != output.length - 1) {
                words.append(output[i]).append("\r\n");
            } else
                words.append(output[i]);
        }
        return words.toString();
    }
}



