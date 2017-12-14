import model.JSONReader;
import model.Library;

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
    }
}
