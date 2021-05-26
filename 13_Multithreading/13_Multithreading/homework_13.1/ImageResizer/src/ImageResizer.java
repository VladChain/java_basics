import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageResizer extends Thread {

    private File[] files;
    private int newWidth;
    private String dstFolder;
    private long start;

    public ImageResizer(File[] files, int newWidth, String dstFolder, long start) {
        this.files = files;
        this.newWidth = newWidth;
        this.dstFolder = dstFolder;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }

                int newHight = (int) Math.round(image.getHeight() /
                        (image.getWidth() / (double) newWidth));

                // Использование метода public static BufferedImage resize(BufferedImage src,
                // int targetWidth, int targetHeight, BufferedImageOp... ops) с функцией сглаживания:
                BufferedImage newImage = Scalr.resize(image, newWidth, newHight, Scalr.OP_ANTIALIAS);

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Finished after start: " +  (System.currentTimeMillis() - start) + "ms");
    }
}
