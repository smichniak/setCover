import java.util.HashSet;
import java.util.Set;

public class CollectionSet extends Collection{
    public Set<Integer> elementCollection;
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
        for (FiniteArithmeticCollection collection: finiteArithmetic) {
            if (collection.contains(element)) {
                return true;
            }
        }
        for (InfiniteArithmeticCollection collection: infiniteArithmetic) {
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
        for (FiniteArithmeticCollection finiteCollection: finiteArithmetic) {
            if (intersection.size() == collection.size()) {
                break;
            }
            intersection.addAll(finiteCollection.intersection(collection));
        }
        for (InfiniteArithmeticCollection infiniteCollection: infiniteArithmetic) {
            if (intersection.size() == collection.size()) {
                break;
            }
            intersection.addAll(infiniteCollection.intersection(collection));
        }
        return intersection;

    }

    public void addElements(Set<Integer> elementCollection) {
        this.elementCollection.addAll(elementCollection);
    }

    public void addfinite(FiniteArithmeticCollection finite) {
        this.finiteArithmetic.add(finite);
    }

    public void addInfinite(InfiniteArithmeticCollection infinite) {
        this.infiniteArithmetic.add(infinite);
    }



}
