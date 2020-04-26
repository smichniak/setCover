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
