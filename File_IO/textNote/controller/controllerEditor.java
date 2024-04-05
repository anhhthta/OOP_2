package File_IO.textNote.controller;

import File_IO.textNote.view.viewEditor;
import File_IO.textNote.view.viewFileTree;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class controllerEditor implements ActionListener {
    private viewEditor view;

    public controllerEditor(viewEditor view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        JFileChooser fileChooser = new JFileChooser();

        String fileName;
        if(command.equals("Save")){
            fileName = this.view.model.getFileName();
            if (fileName.length() > 0) {
                save(fileName);
            } else {
                int returnVal = fileChooser.showSaveDialog(this.view);

                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();

                    fileName = file.getAbsolutePath();

                    save(fileName);
                    this.view.setTitle(fileName);
                    this.view.model.setFileName(fileName);
                }
            }
        } else if(command.equals("Open...")) {
            int returnVal = fileChooser.showOpenDialog(this.view);

            if(returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                fileName = file.getAbsolutePath();
                    this.view.model.setFileName(fileName);
                    try {
                        FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
                        int data;
                        String iString = "";

                        while((data = fileInputStream.read()) != -1) {
                            iString += (char) data ;
                        }

                        this.view.setTitle(fileName);
                        this.view.textArea.setText(iString);
                        fileInputStream.close();
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                }
            }
        }  else if (command.endsWith("New File")) {
            fileName = this.view.model.getFileName();
            if(fileName.length() > 0) {
                this.view.model.setFileName("");
                this.view.setTitle("No Name");
            }
            this.view.textArea.setText("");
        } else if(command.equals("Files Tree")) {
            viewFileTree filetree = new viewFileTree(view);
            filetree.setVisible(true);
        }
    }

    private void save(String fileName){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            String data = this.view.textArea.getText();
            fileOutputStream.write(data.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
