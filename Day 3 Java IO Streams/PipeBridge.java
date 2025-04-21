import java.io.*;

public class PipeBridge {
    public static void main(String[] args) {
        try {
            PipedOutputStream emitter = new PipedOutputStream();
            PipedInputStream receiver = new PipedInputStream(emitter);

            Thread sender = new Thread(() -> {
                try {
                    String info = "Thread communication via stream";
                    emitter.write(info.getBytes());
                    emitter.close();
                } catch (IOException problem) {
                    System.out.println("Dispatch failed: " + problem.getMessage());
                }
            });

            Thread catcher = new Thread(() -> {
                try {
                    int signal;
                    while ((signal = receiver.read()) != -1) {
                        System.out.print((char) signal);
                    }
                    receiver.close();
                } catch (IOException glitch) {
                    System.out.println("Receive error: " + glitch.getMessage());
                }
            });

            sender.start();
            catcher.start();

            sender.join();
            catcher.join();

        } catch (IOException | InterruptedException hiccup) {
            System.out.println("Pipe setup failed: " + hiccup.getMessage());
        }
    }
}
