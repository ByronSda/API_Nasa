package uce.edu.ec.view;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;

public class Window extends JFrame {
    public JComboBox<String> cameraComboBox;
    public JComboBox<String> roverComboBox;
    public JComboBox<Integer> solComboBox;
    public JEditorPane resultPane;
    public JButton searchButton;

    public Window() {
        setTitle("NASA Mars Photos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel filterPanel = new JPanel();
        filterPanel.setLayout(new GridLayout(4, 2));
        filterPanel.setBackground(Color.DARK_GRAY);

        JLabel cameraLabel = new JLabel("Camera:");
        cameraLabel.setForeground(Color.WHITE);
        cameraComboBox = new JComboBox<>(new String[]{"All", "FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM"});

        JLabel roverLabel = new JLabel("Rover:");
        roverLabel.setForeground(Color.WHITE);
        roverComboBox = new JComboBox<>(new String[]{"All", "Curiosity", "Opportunity", "Spirit"});

        JLabel solLabel = new JLabel("Sol:");
        solLabel.setForeground(Color.WHITE);
        solComboBox = new JComboBox<>(new Integer[]{1000, 1001, 1002});

        searchButton = new JButton("Search");

        filterPanel.add(cameraLabel);
        filterPanel.add(cameraComboBox);
        filterPanel.add(roverLabel);
        filterPanel.add(roverComboBox);
        filterPanel.add(solLabel);
        filterPanel.add(solComboBox);
        filterPanel.add(new JLabel());
        filterPanel.add(searchButton);

        resultPane = new JEditorPane();
        resultPane.setContentType("text/html");
        resultPane.setEditable(false);
        resultPane.addHyperlinkListener(e -> {
            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                try {
                    Desktop.getDesktop().browse(e.getURL().toURI());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(filterPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultPane), BorderLayout.CENTER);
        setVisible(true);
    }
}