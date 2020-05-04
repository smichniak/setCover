package cover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class Greedy extends Algorithm {
    @Override
    public ArrayList<Integer> cover(ToCover toCover, ArrayList<SetCollection> collectionFamily) {
        ArrayList<Integer> result = new ArrayList<>();
        //Tablica indeksów zbiorów z rodziny, których przecięcie ze zbiorem do pokrycia jest puste
        Set<Integer> emptyIntersection = new HashSet<>();
        while (!toCover.covered() && emptyIntersection.size() < collectionFamily.size()) {
            //Największe przecięcie wśród zbiorów z rodziny
            Set<Integer> maxIntersection = new HashSet<>();
            int maxIntersectionIndex = -1;
            for (int i = 0; i < collectionFamily.size(); ++i) {
                //Sprawdzamy tylko zbiory, które mają szansę mieć niepuste przecięcie
                if (!emptyIntersection.contains(i)) {
                    Set<Integer> intersection = collectionFamily.get(i).intersection(toCover.getNotCovered());
                    if (intersection.size() > maxIntersection.size()) {
                        maxIntersection = intersection;
                        maxIntersectionIndex = i;
                    } else if (intersection.size() == 0) {
                        emptyIntersection.add(i);
                    }
                }
            }

            result.add(maxIntersectionIndex + 1);
            toCover.cover(maxIntersection);
        }

        if (toCover.covered()) {
            Collections.sort(result);
            return result;
        }
        //Jeśli nie udało się pokryć, to zwracamy pustą tablicę
        return new ArrayList<>();
    }
}
