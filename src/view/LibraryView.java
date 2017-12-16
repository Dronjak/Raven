package view;

import controller.LibraryController;
import model.Book;
import model.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

/**
 * Created by Batzuhan on 14/12/2017.
 */

public class LibraryView extends JPanel {
    private LibraryController controller;
    private JPanel buttonPanel;
    private JPanel textFieldPanel = new JPanel();
    private JPanel infoPanel = new JPanel();
    public JTextField nameInput;
    public JTextField authorInput;
    public JTextField quantityInput;

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
        addButton.addActionListener(new addButtonListener(controller));
        buttonPanel.add(addButton);
        JButton deleteButton = new JButton("Delete Book");
        deleteButton.addActionListener(new deleteButtonListener(controller));
        buttonPanel.add(deleteButton);
        JButton showInfoButton = new JButton("Show Info");
        showInfoButton.addActionListener(new showInfoButtonListener(controller));
        buttonPanel.add(showInfoButton);
        JButton listAllButton = new JButton("List all the books");
        listAllButton.addActionListener(new listAllButtonListener(controller));
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
        nameInput = new JTextField("Enter books name: ");
        nameInput.addActionListener(new addButtonListener(controller));
        textFieldPanel.add(nameInput);
        authorInput = new JTextField("Enter authors name: ");
        authorInput.addActionListener(new addButtonListener(controller));
        textFieldPanel.add(authorInput);
        quantityInput = new JTextField("Enter quantity: ");
        quantityInput.addActionListener(new addButtonListener(controller));
        textFieldPanel.add(quantityInput);
        return textFieldPanel;
    }

    class addButtonListener implements ActionListener {
        private final LibraryController controller;

        addButtonListener(LibraryController controller) {
            this.controller = controller;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.addButtonClicked();
            String name = nameInput.getText();
            String author = authorInput.getText();
            int quantity = parseInt(quantityInput.getText());

        }
    }
    class deleteButtonListener implements ActionListener {
        private final LibraryController controller;

        deleteButtonListener(LibraryController controller) {
            this.controller = controller;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.deleteButtonClicked();
        }
    }
    class showInfoButtonListener implements ActionListener {
        private final LibraryController controller;

        showInfoButtonListener(LibraryController controller) {
            this.controller = controller;

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.showInfoButtonClicked();
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
}
