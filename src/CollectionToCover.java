import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import java.util.HashSet;

public class CollectionToCover extends FiniteArithmeticCollection{
    private Set<Integer> intsCovered;
    private Set<CollectionSet> covered;


    public CollectionToCover(int max) {
        super(1, 1, max);
        intsCovered = new HashSet<>();
        covered = new HashSet<>();
    }

   /* public ElementCollection getElementCovered() {
        return elementCovered;
    }

    public Set<FiniteArithmeticCollection> getFiniteCovered() {
        return finiteCovered;
    }

    public Set<InfiniteArithmeticCollection> getInfiniteCovered() {
        return infiniteCovered;
    }*/

    public boolean covered(int element) {
       for (CollectionSet collection: covered) {
           if (collection.contains(element)) {
               return true;
           }
       }
       return false;
    }

    public void cover(CollectionSet collection) {
        covered.add(collection);
    }


}
