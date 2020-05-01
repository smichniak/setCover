package cover;

import java.util.Set;
import java.util.HashSet;

public class CollectionToCover extends FiniteArithmeticCollection {
    private Set<Integer> notCovered;

    public CollectionToCover(int max) {
        super(1, 1, max);
        notCovered = new HashSet<>();
        for (int i = 1; i <= max; ++i) {
            notCovered.add(i);
        }
    }

    public CollectionToCover(int max, Set<Integer> notCovered) {
        super(1, 1, max);
        this.notCovered = notCovered;
    }

    public void cover(Set<Integer> collection) {
        notCovered.removeAll(collection);
    }

    public Set<Integer> getNotCovered() {
        return notCovered;
    }

    public boolean covered() {
        return notCovered.isEmpty();
    }

}
