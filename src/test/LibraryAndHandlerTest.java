import model.Handler;
import model.Library;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryAndHandlerTest {
    private static Handler trivialHandler = new Handler();
    Library trivialLibrary = new Library("trivialLibrary");

    @Test
    void testAddBook1() {
        trivialHandler.addBook("Operadaki Hayalet", "Gaston Leroux", 1, trivialLibrary);
        trivialHandler.addBook("Flamanların Evinde", "Georges Simenon", 3, trivialLibrary);
        trivialHandler.addBook("Yazarın Yolculuğu", "Christopher Vogler", 4, trivialLibrary);
        trivialHandler.addBook("Rotterdamlı Erasmus", "Stefan Zweig", 6, trivialLibrary);
        assertSame(trivialLibrary.getBooks().size(), 4);
    }

    @Test
    void testAddBook2() {
        trivialHandler.addBook("Operadaki Hayalet", "Gaston Leroux", 0, trivialLibrary);
        trivialHandler.addBook("Flamanların Evinde", "Georges Simenon", -3, trivialLibrary);
        trivialHandler.addBook("Yazarın Yolculuğu", "Christopher Vogler", 4, trivialLibrary);
        trivialHandler.addBook("Rotterdamlı Erasmus", "Stefan Zweig", 6, trivialLibrary);
        assertSame(trivialLibrary.getBooks().size(), 2);
    }

    @Test
    void testDeleteBook1() {
        trivialHandler.addBook("Operadaki Hayalet", "Gaston Leroux", 1, trivialLibrary);
        trivialHandler.addBook("Flamanların Evinde", "Georges Simenon", 3, trivialLibrary);
        trivialHandler.addBook("Yazarın Yolculuğu", "Christopher Vogler", 4, trivialLibrary);
        trivialHandler.addBook("Rotterdamlı Erasmus", "Stefan Zweig", 6, trivialLibrary);
        trivialHandler.deleteBook("Böyle Söyledi Zerdüşt", "Frecrich Neitszche", 1, trivialLibrary);
        assertSame(trivialLibrary.getBooks().size(), 4);
    }

    @Test
    void testDeleteBook2() {
        trivialHandler.addBook("Operadaki Hayalet", "Gaston Leroux", 1, trivialLibrary);
        trivialHandler.addBook("Flamanların Evinde", "Georges Simenon", 3, trivialLibrary);
        trivialHandler.addBook("Yazarın Yolculuğu", "Christopher Vogler", 4, trivialLibrary);
        trivialHandler.addBook("Rotterdamlı Erasmus", "Stefan Zweig", 6, trivialLibrary);
        trivialHandler.deleteBook("Rotterdamlı Erasmus", "Stefan Zweig", 6, trivialLibrary);
        assertSame(trivialLibrary.getBooks().size(), 3);
    }

    @Test
    void testDeleteBook3() {
        trivialHandler.addBook("Operadaki Hayalet", "Gaston Leroux", 1, trivialLibrary);
        trivialHandler.addBook("Flamanların Evinde", "Georges Simenon", 3, trivialLibrary);
        trivialHandler.addBook("Yazarın Yolculuğu", "Christopher Vogler", 4, trivialLibrary);
        trivialHandler.addBook("Rotterdamlı Erasmus", "Stefan Zweig", 6, trivialLibrary);
        trivialHandler.deleteBook("Albaya Mektup Yok", "Gabriel Garciel Marquez", -2, trivialLibrary);
        assertEquals(trivialLibrary.getBooks().size(), 4);
    }

    @Test
    void testDeleteBook4() {
        trivialHandler.addBook("Operadaki Hayalet", "Gaston Leroux", 1, trivialLibrary);
        trivialHandler.addBook("Flamanların Evinde", "Georges Simenon", 3, trivialLibrary);
        trivialHandler.addBook("Yazarın Yolculuğu", "Christopher Vogler", 4, trivialLibrary);
        trivialHandler.deleteBook("Flamanların Evinde", "Georges Simenon", -3, trivialLibrary);
        assertEquals(trivialLibrary.getBooks().size(), 3);
    }


}
