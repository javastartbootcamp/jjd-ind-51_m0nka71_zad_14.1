import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File("liczby.txt"))) {
            Map<Integer, Integer> numbers = new TreeMap<>();

            while (scanner.hasNextLine()) {
                int next;
                next = scanner.nextInt();
                if (numbers.containsKey(next)) {
                    numbers.put(next, numbers.get(next) + 1);
                } else {
                    numbers.put(next, 1);
                }
            }
            Set<Map.Entry<Integer, Integer>> entries = numbers.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                System.out.println(entry.getKey() + " - liczba wystąpień " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nie udało się odczytać pliku liczby.txt");
        }
    }
}
