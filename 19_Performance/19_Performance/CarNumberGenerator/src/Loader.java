
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loader {

    public static void main(String[] args) throws Exception {

        long start = System.currentTimeMillis();

        PrintWriter writer1 = new PrintWriter("path.../res/numbers1.txt");
        PrintWriter writer2 = new PrintWriter("path.../res/numbers2.txt");
        PrintWriter writer3 = new PrintWriter("path.../res/numbers3.txt");
        PrintWriter writer4 = new PrintWriter("path.../res/numbers4.txt");

        char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

        for (int regionCode = 1; regionCode < 100; regionCode++) {
            StringBuilder builder = new StringBuilder();
            for (int number = 1; number < 1000; number++) {
                for (char firstLetter : letters) {
                    for (char secondLetter : letters) {
                        for (char thirdLetter : letters) {

                            builder.append(firstLetter);
                            builder.append(padNumber(number, 3));
                            builder.append(secondLetter);
                            builder.append(thirdLetter);
                            builder.append(padNumber(regionCode, 2));
                            builder.append("\n");
                        }
                    }
                }
            }

            String[] a = builder.toString().split("\\s+");
            int quarter = a.length / 4;
            int middle = a.length / 2;

            String[] numbers1 = Arrays.copyOfRange(a, 0, quarter);
            String[] numbers2 = Arrays.copyOfRange(a, quarter, middle);
            String[] numbers3 = Arrays.copyOfRange(a, middle, a.length - quarter);
            String[] numbers4 = Arrays.copyOfRange(a, a.length - quarter, a.length);

            ExecutorService executor = Executors
                    .newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            executor.execute(() -> {
                for (String number : numbers1) {
                    writer1.write(number + "\n");
                }
                for (String number : numbers2) {
                    writer2.write(number + "\n");
                }
                for (String number : numbers3) {
                    writer3.write(number + "\n");
                }
                for (String number : numbers4) {
                    writer4.write(number + "\n");
                }
            });
            executor.shutdown();
        }

        writer1.flush();
        writer2.flush();
        writer3.flush();
        writer4.flush();

        writer1.close();
        writer2.close();
        writer3.close();
        writer4.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder numberStr = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr.insert(0, '0');
        }
        return numberStr.toString();
    }
}
