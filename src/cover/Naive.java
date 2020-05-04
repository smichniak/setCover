package cover;

import java.util.ArrayList;
import java.util.Set;


public class Naive extends Algorithm {
    @Override
    public ArrayList<Integer> cover(ToCover toCover, ArrayList<SetCollection> collectionFamily) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < collectionFamily.size() && !toCover.covered(); ++i) {
            //Sprawdzamy przecięcie kolejnych zbiorów z rodziny ze zbiorem do pokrycia
            Set<Integer> intersection = collectionFamily.get(i).intersection(toCover.getNotCovered());
            if (intersection.size() > 0) {
                result.add(i + 1);
                toCover.cover(intersection);
            }
        }
        if (toCover.covered()) {
            return result;
        }
        //Jeśli nie udało się pokryć, to zwracamy pustą tablicę
        return new ArrayList<>();
    }


}
