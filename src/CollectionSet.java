import java.util.HashSet;
import java.util.Set;

public class CollectionSet extends Collection{
    private ElementCollection elementCollection;
    private Set<FiniteArithmeticCollection> finiteArithmetic;
    private Set<InfiniteArithmeticCollection> infiniteArithmetic;

    public CollectionSet() {
        elementCollection = new ElementCollection();
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

    @Override
    public int intersetion() {
        return 0;
    }

    public void addElement(int element) {
        elementCollection.add(element);
    }

    public void addFinite(FiniteArithmeticCollection collection) {
        finiteArithmetic.add(collection);
    }

    public void addInfinite(InfiniteArithmeticCollection collection) {
        infiniteArithmetic.add(collection);
    }

}
