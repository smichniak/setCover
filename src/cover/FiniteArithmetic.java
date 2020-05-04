package cover;


public class FiniteArithmetic extends ArithmeticCollection {
    //Skończony ciąg arytmetyczny, którego elementy są <= od maximum
    private int maximum;

    public FiniteArithmetic(int first, int difference, int maximum) {
        super(first, difference);
        this.maximum = maximum;
    }

    @Override
    public boolean contains(int element) {
        return element <= maximum && super.contains(element);
    }

}
