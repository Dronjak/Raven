package view;

import controller.LibraryController;
import model.Book;
import model.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static java.lang.Integer.parseInt;

/**
 * Created by Batzuhan on 14/12/2017.
 */

public class LibraryView extends JPanel {
    private LibraryController controller;
    public JPanel textFieldPanel = new JPanel();
    public JPanel infoPanel = new JPanel();
    private JTextField nameInput;
    private JTextField authorInput;
    private JTextField quantityInput;

    public LibraryView(LibraryController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        add(createButtonPanel(), BorderLayout.NORTH);
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new addButtonListener(controller));
        buttonPanel.add(addButton);
        JButton deleteButton = new JButton("Delete Book");
        deleteButton.addActionListener(new deleteButtonListener(controller));
        buttonPanel.add(deleteButton);
        JButton showInfoButton = new JButton("Search");
        showInfoButton.addActionListener(new showInfoButtonListener(controller));
        buttonPanel.add(showInfoButton);
        JButton listAllButton = new JButton("See Whole Library");
        listAllButton.addActionListener(new listAllButtonListener(controller));
        buttonPanel.add(listAllButton);
        return buttonPanel;
    }

    public void createTextFieldPanel() {
        textFieldPanel.setLayout(new GridLayout(2, 3));
        JLabel nameLabel = new JLabel("Enter books name: ");
        textFieldPanel.add(nameLabel);
        JLabel authorLabel = new JLabel("Enter authors name: ");
        textFieldPanel.add(authorLabel);
        JLabel quantityLabel = new JLabel("Enter quantity: ");
        textFieldPanel.add(quantityLabel);
        nameInput = new JTextField(13);
        textFieldPanel.add(nameInput);
        authorInput = new JTextField(13);
        textFieldPanel.add(authorInput);
        quantityInput = new JTextField(5);
        textFieldPanel.add(quantityInput);
        add(textFieldPanel, BorderLayout.CENTER);
    }

    public void createInfoPanel(List<Book> books) {
        infoPanel.setLayout(new GridLayout());
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < books.size(); i++) {
            listModel.addElement(books.get(i).toString());
        }
        JList bookList = new JList(listModel);
        bookList.setVisibleRowCount(20);
        JScrollPane listScroller = new JScrollPane();
        listScroller.setViewportView(bookList);
        infoPanel.add(listScroller);
        add(infoPanel, BorderLayout.SOUTH);
    }


    class addButtonListener implements ActionListener {
        private final LibraryController controller;


        addButtonListener(LibraryController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.addButtonClicked(getNameInput(), getAuthorInput(), getParseInput(getQuantityInput()));
        }
    }

    class deleteButtonListener implements ActionListener {
        private final LibraryController controller;

        deleteButtonListener(LibraryController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.deleteButtonClicked(getNameInput(), getAuthorInput(), getParseInput(getQuantityInput()));
        }
    }

    class showInfoButtonListener implements ActionListener {
        private final LibraryController controller;

        showInfoButtonListener(LibraryController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.showInfoButtonClicked(getNameInput(), getAuthorInput());
        }
    }

    class listAllButtonListener implements ActionListener {
        private final LibraryController controller;

        listAllButtonListener(LibraryController controller) {
            this.controller = controller;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.listAllButtonClicked();
        }
    }

    private String getNameInput() {
        String name;
        try {
            name = nameInput.getText();
        } catch (NullPointerException e) {
            return "";
        }
        return name;
    }

    private String getAuthorInput() {
        String author;
        try {
            author = authorInput.getText();
        } catch (NullPointerException e) {
            return "";
        }
        return author;
    }

    private String getQuantityInput() {
        String quantity;
        try {
            quantity = quantityInput.getText();
        } catch (NullPointerException e) {
            return "0";
        }
        return quantity;
    }

    private int getParseInput(String quantity) {
        int parseInput = 0;
        try {
            parseInput += parseInt(quantity);
        } catch (NumberFormatException e) {
            return 0;
        }
        return parseInput;
    }

}
