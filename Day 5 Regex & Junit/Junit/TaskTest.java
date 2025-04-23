package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    Task task = new Task();

    @Test
    @Timeout(value = 4, unit = TimeUnit.SECONDS) 
    void testTimeout() throws InterruptedException {
        task.longRunningTask();
        assertTrue(true); 
    }
}
