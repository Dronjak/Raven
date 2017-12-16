package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Handler {
    public Handler() {
        // TO DO
    }

    public void addBook(String name, String author, int quantity, Library library) {
        boolean exist = false;
        Book book = new Book(name, author, quantity);
        for (int i = 0; i < library.getBooks().size(); i++) {
            if (book.equals(library.getBooks().get(i))) {
                library.getBooks().get(i).setQuantity(library.getBooks().get(i).getQuantity() + quantity);
                exist = true;
                break;
            }
        }
        if (!exist) {
            library.getBooks().add(book);
        }
    }

    public void deleteBook(String name, String author, int quantity, Library library) {
        Book book = new Book(name, author, quantity);
        boolean exist = false;
        for (int i = 0; i < library.getBooks().size(); i++) {
            if (book.equals(library.getBooks().get(i))) {
                if ((library.getBooks().get(i).getQuantity() - quantity) > 0) {
                    library.getBooks().get(i).setQuantity(library.getBooks().get(i).getQuantity() - quantity);
                } else if ((library.getBooks().get(i).getQuantity() - quantity) == 0) {
                    library.getBooks().remove(i);
                } else {
                    //gives error & please give a valid quantity
                }
                exist = true;
                break;
            }
        }
        if (!exist) {
            //There is no such book
        }
    }

    public List<Book> getBooksByAuthor(String author, Library library) {
        List<Book> list = new List<Book>;

        for (int i = 0; i < library.getBooks().size(); i++) {
            if (author.equals(library.getBooks().get(i).getAuthor())) {
                list.add(library.getBooks().get(i));
            }
        }
        return list;
    }

    public List<Book> getBooksByName(String name, Library library) {
        List<Book> list = new List<Book>;

        for (int i = 0; i < library.getBooks().size(); i++) {
            if (name.equals(library.getBooks().get(i).getName())) {
                list.add(library.getBooks().get(i));
            }
        }
        return list;
    }

    public void refreshDatabase(Library library) {
        try {
            FileWriter file = new FileWriter("library.json");
            JSONObject obj = new JSONObject();
            obj.put("name", "Raven Library");
            JSONArray books = new JSONArray();
            System.out.println(library.getBooks().size());
            for (int i = 0; i < library.getBooks().size(); i++) {
                JSONObject tmp = new JSONObject();
                tmp.put("name", library.getBooks().get(i).getName());
                tmp.put("author", library.getBooks().get(i).getAuthor());
                tmp.put("quantity", library.getBooks().get(i).getQuantity());
                books.add(tmp);
            }
            obj.put("books", books);
            file.write(obj.toJSONString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
