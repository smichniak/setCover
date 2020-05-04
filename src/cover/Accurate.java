package cover;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Accurate extends Algorithm {
    @Override
    public ArrayList<Integer> cover(ToCover toCover, ArrayList<SetCollection> collectionFamily) {
        return coverAux(toCover, collectionFamily, 0);
    }

    //W każdym wywołaniu rozważamy, czy uwzględnić w pokryciu zbiór na pozycji startingIndex
    private ArrayList<Integer> coverAux(ToCover toCover, ArrayList<SetCollection> collectionFamily, int startingIndex) {
        if (startingIndex == collectionFamily.size()) {
            //Doszliśmy do końca rodziny, nie mamy więcej zbiorów
            return new ArrayList<>();
        }
        Set<Integer> intersection = collectionFamily.get(startingIndex).intersection(toCover.getNotCovered());

        if (intersection.size() == 0) {
            //Przy pusty przecięciu na pewno nie chcemy skorzystać z aktualnego zbioru
            return coverAux(toCover, collectionFamily, startingIndex + 1);
        }

        //Kopiujemy zbiór, bo w różnych wywołaniach będzie ulegał różnym modyfikacjom
        Set<Integer> copy = new HashSet<>(toCover.getNotCovered());
        ToCover toCoverCopy = new ToCover(copy);

        toCover.cover(intersection);
        ArrayList<Integer> withCurrent = new ArrayList<>();

        if (toCover.covered()) {
            //Udało się pokryć cały zbiór aktualnym, jest on wynikiem, bo dalsze pokrycia nie mogą być krótsze niż 1
            //i mniejsze leksykograficznie
            withCurrent.add(startingIndex + 1);
            return withCurrent;
        }

        withCurrent = coverAux(toCover, collectionFamily, startingIndex + 1);

        if (withCurrent.size() == 0) {
            //Jeśli nie da się pokryć zbioru z uwzględnieniem aktualnego, to na pewno nie da się go pokryć bez niego
            return new ArrayList<>();
        }

        withCurrent.add(0, startingIndex + 1);
        ArrayList<Integer> withoutCurrent = coverAux(toCoverCopy, collectionFamily, startingIndex + 1);

        if (withoutCurrent.size() == 0) {
            return withCurrent;
        }
        return withCurrent.size() <= withoutCurrent.size() ? withCurrent : withoutCurrent;
    }

}