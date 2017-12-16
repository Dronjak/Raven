package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Handler{
    public Handler() {
        // TO DO
    }

    public void addBook(String name, String author, int quantity, Library library) {
        boolean exist = false;
        Book book = new Book(name,author,quantity);
        for(int i=0; i<library.getBooks().size(); i++){
            if(book.equals(library.getBooks().get(i))){
                library.getBooks().get(i).setQuantity(library.getBooks().get(i).getQuantity() + quantity);
                exist = true;
                break;
            }
        }
        if(!exist){
            library.getBooks().add(book);
        }
    }

    public void deleteBook(String name, String author, int quantity, Library library) {
        Book book = new Book(name,author,quantity);
        for(int i=0; i<library.getBooks().size(); i++){
            if(book.equals(library.getBooks().get(i))){
                if((library.getBooks().get(i).getQuantity()-quantity)> 0){
                    library.getBooks().get(i).setQuantity(library.getBooks().get(i).getQuantity() - quantity);
                }
                else if((library.getBooks().get(i).getQuantity()-quantity) == 0){
                    library.getBooks().remove(i);
                }
                else{
                    //gives error & please give a valid quantity
                }
                break;
            }
        }
    }

    public void getBooksByAuthor() {
        // TO DO
    }

    public void getBooksByName() {
        // TO DO
    }

    public void refreshDatabase (Library library) {
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
