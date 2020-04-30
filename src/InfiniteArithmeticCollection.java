import java.util.Set;
import java.util.HashSet;

public class InfiniteArithmeticCollection extends Collection {
    private int first;
    private int difference;

    public InfiniteArithmeticCollection(int first, int difference) {
        this.first = first;
        this.difference = difference;
    }

    @Override
    public boolean contains(int element) {
        return element >= first && element % difference == first % difference;
    }

    @Override
    public Set<Integer> intersection(Set<Integer> collection) {
        Set<Integer> intersection = new HashSet<>();
        for (int element : collection) {
            if (this.contains(element)) {
                intersection.add(element);
            }
        }

        return intersection;
    }
}

