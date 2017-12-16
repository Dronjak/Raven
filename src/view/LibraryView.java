package view;

import controller.LibraryController;
import model.Book;
import model.Library;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Batzuhan on 14/12/2017.
 */

public class LibraryView extends JPanel {
    private LibraryController controller;
    private JPanel buttonPanel;
    private JPanel textFieldPanel = new JPanel();
    private JPanel infoPanel = new JPanel();

    public LibraryView(LibraryController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        add(createButtonPanel(), BorderLayout.NORTH);
        add(createInfoPanel(controller.getLibrary()), BorderLayout.SOUTH);
        add(createTextFieldPanel(), BorderLayout.CENTER);

    }
    private JPanel createButtonPanel() {
        this.buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton addButton = new JButton("Add Book");
        buttonPanel.add(addButton);
        JButton deleteButton = new JButton("Delete Book");
        buttonPanel.add(deleteButton);
        JButton infoButton = new JButton("Show Info");
        buttonPanel.add(infoButton);
        JButton listAllButton = new JButton("List all the books");
        buttonPanel.add(listAllButton);
        return buttonPanel;
    }
    private JPanel createInfoPanel(Library library) {
        this.infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout());
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < library.getBooks().size();i++){
            listModel.addElement(library.getBooks().get(i).toString());
        }
        JList bookList = new JList(listModel);
        infoPanel.add(bookList);
        return infoPanel;
    }
    private  JPanel createTextFieldPanel() {
        this.textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new FlowLayout());
        JTextField nameInput = new JTextField("Enter books name: ");
        textFieldPanel.add(nameInput);
        JTextField authorInput = new JTextField("Enter authors name: ");
        textFieldPanel.add(authorInput);
        JTextField quantityInput = new JTextField("Enter quantity: ");
        textFieldPanel.add(quantityInput);

        return textFieldPanel;
    }
}
