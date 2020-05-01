import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    private int[] buffer;
    private Scanner scanner;
    private ArrayList<CollectionSet> collectionFamily;
    private CollectionSet collectionSet;

    public Parser() {
        buffer =  new int[3];
        scanner = new Scanner(System.in);
        collectionFamily = new ArrayList<>();
        collectionSet = new CollectionSet();
    }


    public void parse() {
        int input;
        while (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input == 0) {
                collectionSet.addBuffer(buffer);
                collectionFamily.add(collectionSet);
                collectionSet = new CollectionSet();
                buffer = new int[3];
            } else if (input < 0) {
                if (buffer[2] == 0) {
                    CollectionToCover toCover = new CollectionToCover(-input);
                    int algorithmId = scanner.nextInt();
                    useAlgorithm(toCover, algorithmId);
                } else {
                    buffer[0] = buffer[1];
                    buffer[1] = buffer[2];
                    buffer[2] = input;
                }
            } else {
                collectionSet.addBuffer(buffer);
                buffer = new int[3];
                buffer[2] = input;
            }

        }
    }

    private void useAlgorithm(CollectionToCover toCover, int algorithmId) {
        ArrayList<Integer> result;
        Algorithm algorithm;
        if (algorithmId == 1) {
            algorithm = new Accurate();
        } else if (algorithmId == 2) {
            algorithm = new Greedy();
        } else {
            algorithm = new Naive();
        }
        result = algorithm.cover(toCover, collectionFamily);
        if (result.size() == 0) {
            System.out.println(0);
        } else {
            for (int setId: result) {
                System.out.printf("%d ",setId);

            }
            System.out.print("\n");
        }
    }




}
