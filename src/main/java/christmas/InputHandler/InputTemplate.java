package christmas.InputHandler;

public class InputTemplate {
    public static <T> T execute(InputCallback<T> callback) {
        while (true) {
            try {
                return callback.run();
            } catch (IllegalArgumentException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
