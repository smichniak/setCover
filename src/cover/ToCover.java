package cover;

import java.util.Set;
import java.util.HashSet;

public class ToCover {
    //Elementy, które jeszcze nie zostały pokryte
    private Set<Integer> notCovered;

    //Zbiór do pokrycia od 1 do max
    public ToCover(int max) {
        notCovered = new HashSet<>();
        for (int i = 1; i <= max; ++i) {
            notCovered.add(i);
        }
    }

    //Zbiór do pokrycia z konkretnych elementów
    public ToCover(Set<Integer> notCovered) {
        this.notCovered = notCovered;
    }

    public void cover(Set<Integer> elements) {
        notCovered.removeAll(elements);
    }

    public Set<Integer> getNotCovered() {
        return notCovered;
    }

    public boolean covered() {
        return notCovered.isEmpty();
    }

}
