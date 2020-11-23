import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        int[] sum = new int [1 + 2 + 3];
//        int[] sum = new int [3]; // укороченный вариант
        int k = -1;

        StringBuffer total = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            char wage = text.charAt(i);
            if (wage > 47 && wage < 58) {
                total.append(wage);
                if (text.charAt(i + 1) == ' ') {
                    System.out.println(text.charAt(i + 1));
                   sum [++k] = Integer.parseInt(total.toString());
                    total = new StringBuffer();
                }
            }
        }
        IntStream intStream = IntStream.of(sum);
        int totalSum = intStream.sum();
        System.out.println(totalSum);
//        System.out.println(IntStream.of(sum).sum()); // укороченный вариант вывовда ответа
    }
}