/**
 *
 * @author davisshriver
 * @param <E>
 */
public interface StackInterface<E> {
    void push(E data);
    E pop() throws EmptyStackException;
    E peek() throws EmptyStackException;
    boolean isEmpty();
}
