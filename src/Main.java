import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        names.add("Kasia");
        names.add("Ania");
        names.add("Ania");
        names.add("Wojtek");
        names.add("Zuza");
        names.add("Zuza");

        int setSize = names.size();
        System.out.println("Number of names: " + setSize);
        boolean isThereAnia = names.contains("Ania");
        System.out.println("Is Ania in this set? " + isThereAnia);
        for (String name : names) {
            System.out.println(name);
        }
        names.remove("Ania");
        isThereAnia = names.contains("Ania");
        System.out.println("Is Ania in this set? " + isThereAnia);

    }
}
