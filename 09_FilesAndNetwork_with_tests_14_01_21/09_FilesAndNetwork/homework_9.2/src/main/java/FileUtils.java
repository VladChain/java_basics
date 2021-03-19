import java.io.*;
import java.nio.file.*;

public class FileUtils {
    public static void copyFolder(String sourceDirectory, String destinationDirectory) {
        // TODO: write code copy content of sourceDirectory to destinationDirectory
        try {
            File source = new File(sourceDirectory);
            File[] files = source.listFiles();
            Path destinationDir = Paths.get(destinationDirectory);
            if (files != null)
                for (File f : files) {
                    if (f.isDirectory()) {
                        File newFolder = new File(destinationDirectory + "/" + f.getName());
                        newFolder.mkdir();
                        copyFolder(f.getAbsolutePath(), newFolder.getAbsolutePath());
                    } else
                        Files.copy(f.toPath(), destinationDir.resolve(f.getName()),
                                StandardCopyOption.REPLACE_EXISTING);
                }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
