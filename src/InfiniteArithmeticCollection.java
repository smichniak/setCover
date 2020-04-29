public class InfiniteArithmeticCollection extends Collection{
    private int first;
    private int difference;

    public InfiniteArithmeticCollection(int first, int difference) {
        this.first = first;
        this.difference = difference;
    }

    @Override
    public boolean contains(int element) {
        return element >= first && element % difference == first % difference;
    }

    @Override
    public int intersetion() {
        return 0;
    }

}
