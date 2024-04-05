package File_IO.textNote.view;

import File_IO.textNote.controller.controllerTreeFile;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class viewFileTree extends JDialog {
    private final JFrame fram;
    public viewFileTree(JFrame fram){
        super(fram, true);
        this.fram = fram;
        setSize(new Dimension(300,400));
        setLocationRelativeTo(fram);
        File file = new File("C:\\NTKT\\OOP_2\\src\\File_IO\\textNote\\Node");
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(file.getName());
        JTree tree = new JTree(root);
        JTextField textField = new JTextField();

        ActionListener controller = new controllerTreeFile(file, tree, root, textField);

        getContentPane().add(tree, BorderLayout.CENTER);
        JPanel panel1 = new JPanel();
        getContentPane().add(panel1, BorderLayout.SOUTH);

        panel1.setLayout(new BorderLayout());
        panel1.add(textField, BorderLayout.CENTER);

        JPanel panelbtn = new JPanel();

        panelbtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        JButton btnDir = new JButton("New Dir");
        btnDir.addActionListener(controller);
        panelbtn.add(btnDir);

        JButton btnFile = new JButton("New File");
        btnFile.addActionListener(controller);
        panelbtn.add(btnFile);

        JButton btnDelete= new JButton("Delete");
        btnDelete.addActionListener(controller);
        panelbtn.add(btnDelete);

        panel1.add(panelbtn, BorderLayout.SOUTH);



    }
}
