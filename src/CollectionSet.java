import java.util.HashSet;
import java.util.Set;

public class CollectionSet extends Collection {
    private Set<Integer> elementCollection;
    private Set<FiniteArithmeticCollection> finiteArithmetic;
    private Set<InfiniteArithmeticCollection> infiniteArithmetic;

    public CollectionSet() {
        elementCollection = new HashSet<>();
        finiteArithmetic = new HashSet<>();
        infiniteArithmetic = new HashSet<>();
    }

    @Override
    public boolean contains(int element) {
        if (elementCollection.contains(element)) {
            return true;
        }
        for (FiniteArithmeticCollection collection : finiteArithmetic) {
            if (collection.contains(element)) {
                return true;
            }
        }
        for (InfiniteArithmeticCollection collection : infiniteArithmetic) {
            if (collection.contains(element)) {
                return true;
            }
        }
        return false;
    }

    //TODO
    //CollectionToCover in argument instead od Set
    @Override
    public Set<Integer> intersection(Set<Integer> collection) {
        Set<Integer> intersection = new HashSet<>(collection);
        intersection.retainAll(elementCollection);
        for (FiniteArithmeticCollection finiteCollection : finiteArithmetic) {
            if (intersection.size() == collection.size()) {
                break;
            }
            intersection.addAll(finiteCollection.intersection(collection));
        }
        for (InfiniteArithmeticCollection infiniteCollection : infiniteArithmetic) {
            if (intersection.size() == collection.size()) {
                break;
            }
            intersection.addAll(infiniteCollection.intersection(collection));
        }
        return intersection;

    }

    public void addBuffer(int[] buffer) {
        if (buffer[2] != 0) {
            if (buffer[1] == 0) {
                elementCollection.add(buffer[2]);
            } else if (buffer[0] == 0) {
                infiniteArithmetic.add(new InfiniteArithmeticCollection(buffer[1], -buffer[2]));
            } else {
                finiteArithmetic.add(new FiniteArithmeticCollection(buffer[0], -buffer[1], -buffer[2]));
            }
        }

    }
}
