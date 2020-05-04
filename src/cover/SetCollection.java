package cover;

import java.util.HashSet;
import java.util.Set;

public class SetCollection extends Collection {
    //Zbiór skałda się z pojedyńczych elementów i ciągów arytmetycznych
    private Set<Integer> elements;
    private Set<ArithmeticCollection> arithmeticCollections;

    public SetCollection() {
        elements = new HashSet<>();
        arithmeticCollections = new HashSet<>();
    }

    @Override
    public boolean contains(int element) {
        //Sprawdzany element może być jednym z pojedyńczych elementów lub w dowolnym ciągu arytmetycznym
        if (elements.contains(element)) {
            return true;
        }
        for (ArithmeticCollection collection : arithmeticCollections) {
            if (collection.contains(element)) {
                return true;
            }
        }

        return false;
    }


    public Set<Integer> intersection(Set<Integer> collection) {
        Set<Integer> intersection = new HashSet<>();

        //W przecięciu zostawiamy tylko elementy, które należą do zbioru
        for (int element : collection) {
            if (this.contains(element)) {
                intersection.add(element);
            }
        }

        return intersection;
    }


    public void addBuffer(int[] buffer) {
        //Pusty bufor nic nie zmienia
        if (buffer[2] != 0) {
            if (buffer[1] == 0) {
                //Bufor z pojedyńczym elementem
                elements.add(buffer[2]);
            } else if (buffer[0] == 0) {
                //Bufor z dwoma elementami to nieskończony ciąg arytmetyczny
                arithmeticCollections.add(new ArithmeticCollection(buffer[1], buffer[2]));
            } else {
                //Bufor z trzema elementami to skończony ciąg arytmetyczny
                arithmeticCollections.add(new FiniteArithmetic(buffer[0], buffer[1], buffer[2]));
            }
        }

    }
}
