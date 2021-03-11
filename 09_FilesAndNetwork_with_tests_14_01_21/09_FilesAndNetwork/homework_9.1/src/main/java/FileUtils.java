import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileUtils {

    public static long calculateFolderSize(String path) {
        long size = 0;
        Path pathSize = Paths.get(path);
        try (Stream<Path> walk = Files.walk(pathSize)) {
            size = walk.filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            System.out.printf("Невозможно получить размер файла %s%n%s", p, e);
                            return 0L;
                        }
                    })
                    .sum();
        } catch (IOException e) {
            System.out.printf("Ошибка при подсчёте размера директории %s", e);
        }
        return size;
    }
}
