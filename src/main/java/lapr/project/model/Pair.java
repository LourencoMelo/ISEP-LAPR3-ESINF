package lapr.project.model;

public class Pair <U, V>{

    /**
     * Fist
     */
    public final U first;       // the first field of a pair
    /**
     * Second
     */
    public final V second;      // the second field of a pair

    /**
     * Constructor of the class with the 2 values
     * @param first
     * @param second
     */
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    /**
     * Gets the First
     * @return first
     */
    public U getFirst() {
        return first;
    }

    /**
     * Gets the Second
     * @return second
     */
    public V getSecond() {
        return second;
    }

    /**
     * To String of the Class
     * @return
     */
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    /**
     * Factory method for creating a typed Pair immutable instance
     * @param a
     * @param b
     * @param <U>
     * @param <V>
     * @return pair
     */
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}
