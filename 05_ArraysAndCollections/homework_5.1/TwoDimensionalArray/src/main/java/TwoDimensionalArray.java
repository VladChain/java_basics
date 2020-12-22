import java.util.Arrays;
import java.util.stream.IntStream;

public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] arr = new char[size][size];
        IntStream.range(0, size * 51 + size - 51)
                .filter(i -> i % 51 < size)
                .forEach(i -> {
                    if (i / 51 == i % 51 || i / 51 + i % 51 == size - 1)
                        arr[i / 51][i % 51] = symbol;
                    else
                        arr[i / 51][i % 51] = ' ';
                });
        Arrays.stream(arr).map(Arrays::toString).forEach(System.out::println);

        return arr;
    }
}
