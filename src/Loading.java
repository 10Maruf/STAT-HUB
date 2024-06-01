package src;

public class Loading implements StatGraphics {
    public void art() {
        System.out.print("Loading");

        for (int i = 0; i < 10; i++) {
            try {
                // Sleep for a short duration to create a delay
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Print a dot to indicate progress
            System.out.print(".");
            System.out.flush();
        }

        System.out.println("\nLoading complete!");
    }
}