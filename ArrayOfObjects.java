import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Robin Dupuis
 */
public class ArrayOfObjects {

    private String[] games;

    public ArrayOfObjects() {
    }

    public static int menu() {
        Scanner input = new Scanner(System.in);

        int numberOfGames = 0;

        do {
            System.out.println("Enter the number of games that you have or -1 to quit : ");
            numberOfGames=input.nextInt();
            if (numberOfGames == 0) {
                System.out.println("number of games cannot be 0");
            }
            return numberOfGames;
        } while (numberOfGames != -1);
    }

    public String[] readGames(int numberOfGames) {
        Scanner input = new Scanner(System.in);
        
        games = new String[numberOfGames];
        for (int i = 0; i < numberOfGames; ++i) {
            System.out.println("enter name " + (i + 1) + " of " + numberOfGames);
            games[i] = input.next();
        }

        return games;
    }

    public static String[] sortGames(String[] ar) {
        for (int i = 0; i < ar.length - 1; ++i) {
            for (int j = i + 1; j < ar.length; ++j) {
                if (ar[i].compareTo(ar[j]) > 0) {
                    String temp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = temp;
                }
            }
        }
        return ar;
    }

    public static void print(String[] ar) {
        for (int i = 0; i < ar.length; ++i) {
            System.out.println(ar[i]);

        }
    }

    public static void main(String[] args) {
        ArrayOfObjects array = new ArrayOfObjects();
        int choice = menu();
        while (choice != -1) {
            array.readGames(choice);
            System.out.println("---Original Array---");
            print(array.games);
            String[] copyOfgames = Arrays.copyOf(array.games, array.games.length);
            copyOfgames = sortGames(copyOfgames);
            System.out.println("---Sorted Array---");
            print(copyOfgames);
            choice = menu();
            System.out.println("------------------");

        }
        System.out.println("Goobye!");
    }

}
