import models.Author;
import models.Book;
import models.Theme;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        CustomService customService = new CustomService();

        Scanner scanner = new Scanner(System.in);
        while(true){
            int num = scanner.nextInt();
            if(num == 1){
                System.out.println("\tList");
                customService.getAllBooks();
                System.out.println("S1 "+customService.getAllBooks().size());
            }
            if(num == 2){
                customService.addBook(new Book(new Author("Alex","M"), "WEQK", new ArrayList<>()));
                customService.getAllBooks();
                System.out.println("S2 "+customService.getAllBooks().size());
            }
            if(num == 3){
                customService.addTheme(1, new Theme("Alex", "Alex"));
                System.out.println("S3 "+customService.getAllThemes(0).size());
            }
            if(num == 4){
                customService.deleteTheme(0, 0);
                System.out.println("S3 "+customService.getAllThemes(0).size());
            }
            if(num == 5){
                customService.changeTheme(0, 0, new Theme("M", "M"));
                System.out.println("S3 "+customService.getAllThemes(0).size());
            }
        }
    }
}
