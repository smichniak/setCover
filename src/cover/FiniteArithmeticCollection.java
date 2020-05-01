package cover;

import java.util.Set;
import java.util.HashSet;

public class FiniteArithmeticCollection extends Collection {
    private int first;
    private int difference;
    private int maximum;

    public FiniteArithmeticCollection(int first, int difference, int maximum) {
        this.first = first;
        this.difference = difference;
        this.maximum = maximum;
    }

    @Override
    public boolean contains(int element) {
        return element >= first && element <= maximum && element % difference == first % difference;
    }

    @Override
    public Set<Integer> intersection(Set<Integer> collection) {
        Set<Integer> intersection = new HashSet<>();
        int length = (maximum - first) / difference;
        if (collection.size() < length) {
            for (int element : collection) {
                if (this.contains(element)) {
                    intersection.add(element);
                }
            }
        } else {
            for (int element = first; element <= maximum; element += difference) {
                if (collection.contains(element)) {
                    intersection.add(element);
                }
            }
        }
        return intersection;
    }

    public int getMaximum() {
        return maximum;
    }


}
