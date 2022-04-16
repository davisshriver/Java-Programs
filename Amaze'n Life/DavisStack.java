import java.util.*;


public class DavisStack<E> implements StackInterface<E> {
    private List<E> stack;
    int size;

    public DavisStack(){
        stack = new ArrayList<>();
    }

    // A method that allows you to push an object onto the stack

    @Override
    public void push(E data) {
        stack.add(data);
    }

    // A method that allows you to take the top item from the stack

    @Override
    public E pop() throws EmptyStackException {

        if(stack.size() == 0)   {
            throw new EmptyStackException();
        }
        E top = stack.remove(stack.size() - 1);
        return top;
    }

    // A method that lets you see the item on the top of the stack.

    @Override
    public E peek() throws EmptyStackException {
        if(stack.size() == 0)   {
            throw new EmptyStackException();
        }
        E top = stack.get(stack.size() - 1);
        return top;
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
