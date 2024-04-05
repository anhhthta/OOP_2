package File_IO.textNote.view;

import File_IO.textNote.controller.controllerEditor;
import File_IO.textNote.model.modelEditor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class viewEditor extends JFrame {
    private JPanel contentPane;
    public modelEditor model;
    public JTextArea textArea;

    public static void main(String[] args){
        List<String> a =  new ArrayList<String>();

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                viewEditor frame = new viewEditor();
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {

                }
                frame.setVisible(true);
            }
        });
    }

    public viewEditor(){
        this.model = new modelEditor();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 400);
        setTitle("No Name");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        textArea = new JTextArea();
        textArea.setFont(new Font("Calibri", Font.PLAIN,20));

        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        ActionListener actionListener = new controllerEditor(this);

//		==========================Menu Bar============================
        JMenuBar menuBar = new JMenuBar();
        contentPane.add(menuBar, BorderLayout.NORTH);

        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        JMenuItem btnNew = new JMenuItem("New File");
        btnNew.addActionListener(actionListener);
        menu.add(btnNew);

        JMenuItem btnOpen = new JMenuItem("Open...");
        btnOpen.addActionListener(actionListener);
        menu.add(btnOpen);

        JMenuItem btnSave = new JMenuItem("Save");
        btnSave.addActionListener(actionListener);
        menu.add(btnSave);

        JMenuItem fileTree = new JMenuItem("Files Tree");
        fileTree.addActionListener(actionListener);
        menu.add(fileTree);

//		==============================================================

    }
}
