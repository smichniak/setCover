package cover;

import java.util.HashSet;
import java.util.Set;

public class SetCollection extends Collection {
    private Set<Integer> elementCollection;
    private Set<ArithmeticCollection> arithmeticCollections;

    public SetCollection() {
        elementCollection = new HashSet<>();
        arithmeticCollections = new HashSet<>();
    }

    @Override
    public boolean contains(int element) {
        if (elementCollection.contains(element)) {
            return true;
        }
        for (ArithmeticCollection collection : arithmeticCollections) {
            if (collection.contains(element)) {
                return true;
            }
        }

        return false;
    }

    //TODO
    //CollectionToCover in argument instead od Set

    public Set<Integer> intersection(Set<Integer> collection) {
        Set<Integer> intersection = new HashSet<>();

        for (int element : collection) {
            if (this.contains(element)) {
                intersection.add(element);
            }
        }

        return intersection;
    }

    public void addBuffer(int[] buffer) {
        if (buffer[2] != 0) {
            if (buffer[1] == 0) {
                elementCollection.add(buffer[2]);
            } else if (buffer[0] == 0) {
                arithmeticCollections.add(new ArithmeticCollection(buffer[1], buffer[2]));
            } else {
                arithmeticCollections.add(new FiniteArithmetic(buffer[0], buffer[1], buffer[2]));
            }
        }

    }
}
