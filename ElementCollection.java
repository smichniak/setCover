import java.util.Set;
import java.util.HashSet;

public class ElementCollection extends Collection {
    private Set<Integer> elements;

    public ElementCollection() {
        elements = new HashSet<>();
    }

    public void add(int element) {
        elements.add(element);
    }

    @Override
    public boolean contains(int element) {
        return elements.contains(element);
    }

    @Override
    public int intersetion(ElementCollection collection) {
        return 0;
    }

    protected Set<Integer> getElements() {
        return elements;
    }

}
