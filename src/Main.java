import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>();
        s1.add(1);
        s1.add(2);
        s1.add(4);
        CollectionSet c1 = new CollectionSet();
        c1.addElements(s1);
        c1.addInfinite(new InfiniteArithmeticCollection(1, 2));

        Set<Integer> s2 = new HashSet<>();
        s2.add(2);
        s2.add(4);
        CollectionSet c2 = new CollectionSet();
        c2.addElements(s2);

        Set<Integer> s3 = new HashSet<>();
        s3.add(3);
        s3.add(1);
        s3.add(2);
        CollectionSet c3 = new CollectionSet();
        c3.addElements(s3);

        Set<Integer> s4 = new HashSet<>();
        s4.add(5);
        s4.add(1);
        CollectionSet c4 = new CollectionSet();
        c4.addElements(s4);

        Set<Integer> s5 = new HashSet<>();
        s5.add(6);
        s5.add(2);
        CollectionSet c5 = new CollectionSet();
        c5.addElements(s5);

        ArrayList<CollectionSet> family = new ArrayList<>();
        family.add(c1);
        family.add(c2);
        family.add(c3);
        family.add(c4);
        family.add(c5);


        CollectionToCover toCover = new CollectionToCover(5);

        Algorithm naive = new Naive();
       /* System.out.println(toCover.getNotCovered());
        System.out.println(c1.intersection(toCover.getNotCovered()));

        System.out.println(c5.intersection(toCover.getNotCovered()));

        System.out.println(toCover.getNotCovered());*/
        System.out.println(naive.cover(toCover, family));

    }
}
