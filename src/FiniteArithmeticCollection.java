public class FiniteArithmeticCollection extends Collection {
    private int first;
    private int difference;
    private int maximum;

    public FiniteArithmeticCollection(int first, int difference, int maximum) {
        this.first = first;
        this.difference = difference;
        this.maximum = maximum;
    }

    @Override
    public boolean contains(int element) {
        return element >= first && element <= maximum && element % difference == first % difference;
    }

    @Override
    public int intersetion() {
        return 0;
    }

    public int getMaximum() {
        return maximum;
    }
}
