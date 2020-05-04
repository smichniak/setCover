package cover;


public class ArithmeticCollection extends Collection {
    private int first;
    private int difference;

    public ArithmeticCollection(int first, int difference) {
        this.first = first;
        this.difference = difference;
    }

    @Override
    public boolean contains(int element) {
        return element >= first && element % difference == first % difference;
    }

}
