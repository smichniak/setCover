package cover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class Greedy extends Algorithm {
    @Override
    public ArrayList<Integer> cover(ToCover toCover, ArrayList<SetCollection> collectionFamily) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> emptyIntersection = new HashSet<>();
        while (!toCover.covered() && emptyIntersection.size() < collectionFamily.size()) {
            Set<Integer> maxSet = new HashSet<>();
            int maxSetIndex = -1;
            for (int i = 0; i < collectionFamily.size(); ++i) {
                if (!emptyIntersection.contains(i)) {
                    Set<Integer> intersection = collectionFamily.get(i).intersection(toCover.getNotCovered());
                    if (intersection.size() > maxSet.size()) {
                        maxSet = intersection;
                        maxSetIndex = i;
                    } else if (intersection.size() == 0) {
                        emptyIntersection.add(i);
                    }
                }
            }

            result.add(maxSetIndex + 1);
            toCover.cover(maxSet);
        }

        if (toCover.covered()) {
            Collections.sort(result);
            return result;
        }
        return new ArrayList<>();
    }
}
