package File_IO.textNote.controller;

import File_IO.textNote.model.modelEditor;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class controllerTreeFile implements ActionListener {
    private File file;
    private JTree tree;
    private DefaultMutableTreeNode root;
    private JTextField textField;

    public controllerTreeFile(File file, JTree tree,  DefaultMutableTreeNode root,JTextField textField) {
        this.file = file;
        this.tree = tree;
        this.root = root;
        this.textField = textField;
        initData(file, root);
        tree.expandRow(0);
    }

    private void initData(File file, DefaultMutableTreeNode parentNode){
        if (file.isDirectory()) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new modelEditor(file.getName(), file.getAbsolutePath()));
            parentNode.add(childNode);
            List<File> list = List.of(file.listFiles());
            Stream<File> files = list.stream();
            if (files != null) {

                files.forEach(child -> {
                    initData(child, childNode);
                });
            }
        } else {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new modelEditor(file.getName(), file.getAbsolutePath()));
            parentNode.add(childNode);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if(btn.equals("New Dir")){
            try{
                String txt = textField.getText();
                if(!txt.isEmpty()){
                    String selectedFilePath;
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    Object userObject = selectedNode.getUserObject();
                    if (userObject instanceof modelEditor) {
                        modelEditor path = (modelEditor) userObject;
                        selectedFilePath = path.getPath();

                        File directory = new File(selectedFilePath + "\\"+txt);
                        boolean created = directory.mkdirs();
                        if(created) {
                            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new modelEditor(directory.getName(), directory.getAbsolutePath()));
                            selectedNode.add(newNode);
                            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                            model.reload();
                        } else {
                            System.out.println("err");
                        }
                    } else {
                        System.out.println("err");
                    }
                } else {
                    System.out.println("err");
                }
            } catch (NullPointerException ex) {
                System.out.println("err");
            }

        } else if(btn.equals("Delete")) {
            try{
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                if(selectedNode != tree.getModel().getRoot()){
                    String selectedFilePath;
                    Object userObject = selectedNode.getUserObject();
                    if (userObject instanceof modelEditor) {
                        modelEditor path = (modelEditor) userObject;
                        selectedFilePath = path.getPath();

                        File file = new File(selectedFilePath);
                        boolean deleted = file.delete();

                        if(deleted) {
                            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                            model.removeNodeFromParent(selectedNode);
                            model.reload();
                        } else {
                            System.out.println("err");
                        }
                    } else {
                        System.out.println("err");
                    }

                }
            } catch (NullPointerException ex) {
                System.out.println("err");
            }
        } else if(btn.equals("New File")){
            try{
                String txt = textField.getText();
                if(!txt.isEmpty()){
                    String selectedFilePath;
                    DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getSelectionPath().getLastPathComponent();
                    Object userObject = selectedNode.getUserObject();
                    if (userObject instanceof modelEditor) {
                        modelEditor path = (modelEditor) userObject;
                        selectedFilePath = path.getPath();

                        File file = new File(selectedFilePath + "\\"+txt);
                        boolean created = file.createNewFile();
                        if(created) {
                            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(new modelEditor(file.getName(), file.getAbsolutePath()));
                            selectedNode.add(newNode);
                            DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                            model.reload();
                        } else {
                            System.out.println("err");
                        }
                    } else {
                        System.out.println("err");
                    }
                } else {
                    System.out.println("err");
                }
            } catch (NullPointerException ex) {
                System.out.println("err");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
