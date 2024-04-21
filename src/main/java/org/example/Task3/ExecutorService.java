package org.example.Task3;

public class ExecutorService {
    public static void service() {
        CustomThreadPool custom = new CustomThreadPool(4);
        for (int i = 0; i < 10; i++) {
            custom.execute(() -> {
                System.out.println(4);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(5);
            });
        }

        custom.shutDown();
    }
}
