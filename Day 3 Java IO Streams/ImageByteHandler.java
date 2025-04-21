import java.io.*;

public class ImageByteHandler {
    public static void main(String[] items) {
        String inputImage = "original.jpg";
        String outputImage = "replica.jpg";

        try {
            File source = new File(inputImage);
            InputStream streamIn = new FileInputStream(source);
            ByteArrayOutputStream memoryOut = new ByteArrayOutputStream();

            int part;
            byte[] segment = new byte[2048];
            while ((part = streamIn.read(segment)) != -1) {
                memoryOut.write(segment, 0, part);
            }
            streamIn.close();

            byte[] fullArray = memoryOut.toByteArray();

            ByteArrayInputStream memoryIn = new ByteArrayInputStream(fullArray);
            OutputStream streamOut = new FileOutputStream(outputImage);

            while ((part = memoryIn.read(segment)) != -1) {
                streamOut.write(segment, 0, part);
            }
            memoryIn.close();
            streamOut.close();

            System.out.println("Image processed and copied successfully.");
        } catch (IOException issue) {
            System.out.println("Process failed: " + issue.getMessage());
        }
    }
}
