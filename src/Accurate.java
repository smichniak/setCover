import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Accurate extends Algorithm {
    @Override
    public ArrayList<Integer> cover(CollectionToCover toCover, ArrayList<CollectionSet> collectionFamily) {
        return coverAux(toCover, collectionFamily, 0);
    }


    private static ArrayList<Integer> coverAux(CollectionToCover toCover, ArrayList<CollectionSet> collectionFamily, int startingIndex) {
        if (toCover.covered() || startingIndex == collectionFamily.size()) {
            return new ArrayList<>();
        }

        Set<Integer> copy = new HashSet<>(toCover.getNotCovered());
        int max = toCover.getMaximum();
        CollectionToCover toCoverCopy = new CollectionToCover(max, copy);
        ArrayList<Integer> withoutFirst = coverAux(toCoverCopy, collectionFamily, startingIndex + 1);

        Set<Integer> intersection = collectionFamily.get(startingIndex).intersection(toCover.getNotCovered());
        ArrayList<Integer> withFirst = new ArrayList<>();
        toCover.cover(intersection);

        if (toCover.covered()) {
            withFirst.add(startingIndex + 1);
        } else if (intersection.size() > 0) {
            withFirst = coverAux(toCover, collectionFamily, startingIndex + 1);
            if (withFirst.size() > 0) {
                withFirst.add(0, startingIndex + 1);
            }
        }


        if (withoutFirst.size() == 0) {
            return withFirst;
        }
        if (withFirst.size() == 0) {
            return withoutFirst;
        }
        if (withFirst.size() <= withoutFirst.size()) {
            return withFirst;
        }
        return withoutFirst;

    }
}