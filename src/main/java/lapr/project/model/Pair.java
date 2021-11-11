package lapr.project.model;

public class Pair <U, V>{

    public final U first;       // the first field of a pair
    public final V second;      // the second field of a pair

    // Constructs a new pair with specified values
    private Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    // Factory method for creating a typed Pair immutable instance
    public static <U, V> Pair <U, V> of(U a, V b)
    {
        // calls private constructor
        return new Pair<>(a, b);
    }
}
