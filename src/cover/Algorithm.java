package cover;

import java.util.ArrayList;

public abstract class Algorithm {
    //Zwraca rozwiązanie problemu pokrycia zbioru w postaci tablicy indeksów z rodziny zbiorów
    public abstract ArrayList<Integer> cover(ToCover toCover, ArrayList<SetCollection> collectionFamily);

}
