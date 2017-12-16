package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

/**
 * Created by Murathan on 14/12/2017.
 */
public class JSONReader {
    public static Library parseCountryFrom(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            JSONObject jsonObject = (JSONObject) JSONValue.parse(fileReader);
            Library library = new Library((String) jsonObject.get("name"));
            JSONArray books = (JSONArray) jsonObject.get("books");
            loadBooks(books, library);
            return library;
        } catch (Exception e) {
            System.err.println("Problem occurred while parsing " + fileName + ":");
            System.err.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static void loadBooks(JSONArray books, Library library) {
        for (int i = 0; i < books.size(); i++) {
            JSONObject book = (JSONObject) books.get(i);
            Book caughtBook = new Book((String) book.get("name"), (String) book.get("author"), ((Long) book.get("quantity")).intValue());
            if (!caughtBookExists(library.getBooks(), caughtBook)) {
                library.getBooks().add(caughtBook);
            } else {
                getBook(library.getBooks(), caughtBook).setQuantity(getBook(library.getBooks(), caughtBook).getQuantity()
                        + ((Long) book.get("quantity")).intValue());
            }
        }
    }

    private static boolean caughtBookExists(List<Book> books, Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (book.equals(books.get(i))) return true;
        }
        return false;
    }

    private static Book getBook(List<Book> books, Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (book.equals(books.get(i))) return books.get(i);
        }
        return null;
    }
}
