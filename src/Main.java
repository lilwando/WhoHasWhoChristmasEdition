import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner consoleReader = new Scanner(System.in);
        System.out.println("Wprowadz imiona biorące udział w losowaniu oddzielając je przecinkiem ");
        String nameInput = consoleReader.nextLine();
        String[] availableNames = nameInput.split(", ");
        Random randomNumberGenerator = new Random();
        List usedNumbers = new ArrayList();

        for (int i=0; i < availableNames.length; i++) {
            File plik = new File (availableNames[i] + ".txt");
            int n = randomNumberGenerator.nextInt(availableNames.length);
            while (usedNumbers.contains(n) || i == n)
            {
                n = randomNumberGenerator.nextInt(availableNames.length);
            }
            usedNumbers.add(n);
            PrintWriter zapis = new PrintWriter(availableNames[i] + ".txt");
            zapis.println("Wylosowana osoba to " + availableNames[n]);
            zapis.close();
            }

        }
    }
