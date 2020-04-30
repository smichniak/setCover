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
        ArrayList<Integer> withFirst;
        if (intersection.size() > 0) {
            toCover.cover(intersection);
            withFirst = coverAux(toCover, collectionFamily, startingIndex + 1);
            withFirst.add(0, startingIndex);
        } else {
            withFirst = new ArrayList<>();
        }

        if (withFirst.size() <= withoutFirst.size() && withFirst.size() > 0) {
            return withFirst;
        }
        if (withoutFirst.size() > 0) {
            return withoutFirst;
        }
        return new ArrayList<>();

    }
}