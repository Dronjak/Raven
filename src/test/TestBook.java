
import model.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestBook {

    @Test
    void testBook1() {
        Book snowman = new Book("Snowman", "Jo Nesbo", 3);
        assertTrue (snowman.equals(new Book("Snowman", "Jo Nesbo", 4)));
    }

    @Test
    void testBook2() {
        Book bat = new Book("", "Jo Nesbo", 7);
        assertSame(bat.getName(), "");
    }

    @Test
    void testBook3() {
        Book computerNetworks = new Book("Computer Networks", "Andrew Tanenbaum", 5);
        Book imitationComputerNetworks = new Book (computerNetworks.getName(), computerNetworks.getAuthor(), computerNetworks.getQuantity());

        assertTrue(computerNetworks.equals(imitationComputerNetworks));
    }

    @Test
    void testBook4() {
        assertThrows(IllegalArgumentException.class, () -> { new Book(null, "John Le Carre", 8); });
    }

    @Test
    void testBook5() {
        Book bat = new Book("Bat", "", 9);
        assertSame(bat.getAuthor(), "");
    }

    @Test
    void testPrint() {
        Book blindness = new Book ("Blindness", "Jose Saramago", 1);
        assertEquals(blindness.toString(), "Book{" +
                "name='" + blindness.getName() + '\'' +
                ", author='" + blindness.getAuthor() + '\'' +
                ", quantity=" + blindness.getQuantity() +
                '}');
    }
}


