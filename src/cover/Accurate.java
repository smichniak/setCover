package cover;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Accurate extends Algorithm {
    @Override
    public ArrayList<Integer> cover(CollectionToCover toCover, ArrayList<CollectionSet> collectionFamily) {
        return coverAux(toCover, collectionFamily, 0);
    }


    private ArrayList<Integer> coverAux(CollectionToCover toCover, ArrayList<CollectionSet> collectionFamily, int startingIndex) {
        if (startingIndex == collectionFamily.size()) {
            return new ArrayList<>();
        }
        Set<Integer> intersection = collectionFamily.get(startingIndex).intersection(toCover.getNotCovered());

        if (intersection.size() == 0) {
            return coverAux(toCover, collectionFamily, startingIndex + 1);
        }

        Set<Integer> copy = new HashSet<>(toCover.getNotCovered());
        int max = toCover.getMaximum();
        CollectionToCover toCoverCopy = new CollectionToCover(max, copy);

        toCover.cover(intersection);
        ArrayList<Integer> withFirst = new ArrayList<>();

        if (toCover.covered()) {
            withFirst.add(startingIndex + 1);
            return withFirst;
        }

        withFirst = coverAux(toCover, collectionFamily, startingIndex + 1);
        ArrayList<Integer> withoutFirst = coverAux(toCoverCopy, collectionFamily, startingIndex + 1);

        if (withFirst.size() == 0) {
            return withoutFirst;
        }

        withFirst.add(0, startingIndex + 1);

        if (withoutFirst.size() == 0) {
            return withFirst;
        }
        return withFirst.size() <= withoutFirst.size() ? withFirst : withoutFirst;
    }

}