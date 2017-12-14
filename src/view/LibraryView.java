package view;

import controller.LibraryController;

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
        add(createButtonPanel(), BorderLayout.WEST);

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
}
