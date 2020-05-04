package cover;

import java.util.Set;
import java.util.HashSet;

public class ToCover {
    private Set<Integer> notCovered;

    public ToCover(int max) {
        notCovered = new HashSet<>();
        for (int i = 1; i <= max; ++i) {
            notCovered.add(i);
        }
    }

    public ToCover(Set<Integer> notCovered) {
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
