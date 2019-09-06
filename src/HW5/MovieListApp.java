package HW5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MovieListApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        ArrayList<Movie> movies = new ArrayList<>();

        System.out.println("Welcome to the HW5.Movie List Application!");
        System.out.println("\nThere are 100 movies in this list.\n");

        for (int i = 1; i <= 100; i++) {
            Movie m = MovieIO.getMovie(i);
            movies.add(m);
        }
        Collections.sort(movies);
        while (choice.equalsIgnoreCase("y")) {
            System.out.print("What category are you interested in ? ");
            String category = sc.next();

            for (Movie movie : movies) {
                if (category.equalsIgnoreCase(movie.category)) {
                    System.out.println(movie.title);
                }
            }
            System.out.print("\nContinue? (y/n): ");
            choice = sc.next();
        }
    }
}
