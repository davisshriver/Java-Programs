public class EmptyStackException extends Exception {

    public EmptyStackException() {
        System.out.println("Stack is empty");
    }

    public EmptyStackException(String msg) {
        super(msg);
    }
}
