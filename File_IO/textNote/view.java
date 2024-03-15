package File_IO.textNote;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class view extends JFrame {
    private JPanel contentPane;
    public model model;
    public JTextArea textArea;

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                view frame = new view();
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {

                }
                frame.setVisible(true);
            }
        });
    }

    public view(){
        this.model = new model();

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

        ActionListener actionListener = new controller(this);

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

//		==============================================================

    }
}
