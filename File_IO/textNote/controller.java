package File_IO.textNote;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class controller implements ActionListener {
    private view view;

    public controller(view view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("txt files (*.txt)", "txt", "doc", "docx", "pfd");
        fileChooser.addChoosableFileFilter(txtFilter);
        fileChooser.setFileFilter(txtFilter);

        String fileName;
        if(command.equals("Save")){
            fileName = this.view.model.getFileName();
            if (fileName.length() > 0) {
                save(fileName);
            } else {
                int returnVal = fileChooser.showSaveDialog(this.view);

                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    if(!file.getName().toLowerCase().endsWith(".txt") &&
                            !file.getName().toLowerCase().endsWith(".doc") &&
                            !file.getName().toLowerCase().endsWith(".doc") &&
                            !file.getName().toLowerCase().endsWith(".pfd")){
                        file = new File(file.getParentFile(), file.getName() + ".txt");
                    }
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

                if(fileName.endsWith(".txt") || fileName.endsWith(".doc") ||
                        fileName.endsWith(".docx") || fileName.endsWith(".pdf")
                ){
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
            }
        }  else if (command.endsWith("New File")) {
            fileName = this.view.model.getFileName();
            if(fileName.length() > 0) {
                this.view.model.setFileName("");
                this.view.setTitle("No Name");
            }
            this.view.textArea.setText("");
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
