import controller.LibraryController;
import model.JSONReader;
import model.Library;

import javax.swing.*;
import java.awt.*;
import java.io.File;
/**
 * Created by Murathan on 13/12/2017.
 */
public class Main {
    public static void main(String[] args) {
        Library library = JSONReader.parseCountryFrom("library.json");
        //deneme amaçlı.
        for(int i=0; i<library.getBooks().size(); i++) {
            System.out.println(library.getBooks().get(i));
        }
        initializeScreen(library);
    }

    public static void initializeScreen(Library library){
        LibraryController controller = new LibraryController(library);

        JFrame frame = new JFrame(library.getName());
        frame.setLayout(new BorderLayout());
        frame.add(controller.getView(), BorderLayout.CENTER);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
