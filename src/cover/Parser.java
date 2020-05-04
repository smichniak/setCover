package cover;

import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    //Bufor do przechowywania maksymalnie trzech poprezdnich liczb z wejścia
    private int[] buffer;
    private Scanner scanner;
    //Rodzina zbiorów, którymi będziemy pokrywać
    private ArrayList<SetCollection> collectionFamily;

    public Parser() {
        buffer = new int[3];
        scanner = new Scanner(System.in);
        collectionFamily = new ArrayList<>();
    }

    public void parseInput() {
        //Zbiór z rodziny, który akutalnie konstruujemy
        SetCollection setCollection = new SetCollection();
        int input;
        while (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input == 0) {
                //0 oznacza, że kończymy konstruować zbiór
                //Dodajemy bufor do zbioru i zbiór do rodziny zbiorów
                setCollection.addBuffer(buffer);
                collectionFamily.add(setCollection);
                setCollection = new SetCollection();
                buffer = new int[3];
            } else if (input < 0) {
                if (buffer[2] == 0) {
                    //Ujemne wejście i pusty bufor oznaczają Zapytanie
                    ToCover toCover = new ToCover(-input);
                    int algorithmId = scanner.nextInt();
                    useAlgorithm(toCover, algorithmId);
                } else {
                    //Kontynuacja opisu elementu zbioru
                    buffer[0] = buffer[1];
                    buffer[1] = buffer[2];
                    buffer[2] = -input;
                }
            } else {
                //Dodatnie wejście oznacza, że cały opis poprzednego elementu zbioru znajduje się w buforze
                setCollection.addBuffer(buffer);
                buffer = new int[3];
                buffer[2] = input;
            }

        }
    }

    private void useAlgorithm(ToCover toCover, int algorithmId) {
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
            //Pusty wynik oznacza brak możliwości pokrycia zbioru
            System.out.println(0);
        } else {
            for (int setId : result) {
                System.out.printf("%d ", setId);
            }
            System.out.print("\n");
        }
    }

}
