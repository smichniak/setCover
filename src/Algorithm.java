import java.util.ArrayList;

public abstract class Algorithm {
    protected CollectionToCover toCover;
    protected ArrayList<CollectionSet> collectionFamily;
    protected int[] result;

    public Algorithm(CollectionToCover toCover, ArrayList<CollectionSet> collectionFamily) {
        this.toCover = toCover;
        this.collectionFamily = collectionFamily;
        this.result = new int[collectionFamily.size()];
    }

    public abstract int[] cover();



}
