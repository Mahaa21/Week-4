import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;

public class StreamSpeedCheck {
    public static void main(String[] arguments) {
        String original = "largefile.txt";
        String bufferedTarget = "copy_buffered.txt";
        String plainTarget = "copy_plain.txt";

        long t1, t2;

        try {
            t1 = System.nanoTime();
            bufferedMethod(original, bufferedTarget);
            t2 = System.nanoTime();
            System.out.println("Buffered Duration: " + (t2 - t1) + " ns");

            t1 = System.nanoTime();
            unbufferedMethod(original, plainTarget);
            t2 = System.nanoTime();
            System.out.println("Unbuffered Duration: " + (t2 - t1) + " ns");
        } catch (Exception ex) {
            System.out.println("Issue: " + ex.getMessage());
        }
    }

    public static void bufferedMethod(String inputPath, String outputPath) throws Exception {
        InputStream reader = new BufferedInputStream(new java.io.FileInputStream(new File(inputPath)));
        OutputStream writer = new BufferedOutputStream(new java.io.FileOutputStream(new File(outputPath)));
        byte[] chunk = new byte[4096];
        int length;
        while ((length = reader.read(chunk)) > 0) {
            writer.write(chunk, 0, length);
        }
        reader.close();
        writer.close();
    }

    public static void unbufferedMethod(String inputPath, String outputPath) throws Exception {
        InputStream reader = new java.io.FileInputStream(new File(inputPath));
        OutputStream writer = new java.io.FileOutputStream(new File(outputPath));
        byte[] piece = new byte[4096];
        int count;
        while ((count = reader.read(piece)) > 0) {
            writer.write(piece, 0, count);
        }
        reader.close();
        writer.close();
    }
}
