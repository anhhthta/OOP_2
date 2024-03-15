package File_IO.bai1;

import java.io.*;
import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) throws IOException {
        Boolean c = true;
        file file = new file();


        do{
            Scanner sc = new Scanner(System.in);
            System.out.println("=========Menu=========");
            System.out.println("1. New file");
            System.out.println("2. Save");
            System.out.println("3. Write");
            System.out.println("4. Read");
            System.out.println("5. Get file path");
            System.out.println("6. Delete");
            System.out.println("7. New folder");
            System.out.println("other. Exit");
            System.out.println("======================");

            String i = sc.nextLine();
            switch (i) {
                case "1": {
                    System.out.print("Enter file's name: ");
                    String name = sc.nextLine();
                    file.setName(name);
                    FileOutputStream fileOutputStream = new FileOutputStream(file.getName());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    System.out.println(" ==> select 3 to write content");
                    break;
                }
                case "2": {
                    FileOutputStream fileOutputStream = new FileOutputStream(file.getName());
                    fileOutputStream.write(file.getContent().getBytes());
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    break;
                }
                case "3":{
                    System.out.println("Enter content:");
                    String content = sc.nextLine();
                    file.setContent(content);
                    System.out.println(" ==> select 2 to save");
                    break;
                }
                case "4": {
                    String j;
                    String name = "";
                    System.out.println("==================");
                    System.out.println("1. Read current file");
                    System.out.println("2. Read other file");
                    System.out.println("other: Do not read file");
                    j = sc.nextLine();
                    if(j.equals("1")){
                        name = file.getName();
                    } else if(j.equals("2")) {
                        System.out.print("File's fath: ");
                        name = sc.nextLine();
                    }

                    if(name.length() > 0){
                        FileInputStream fileInputStream = new FileInputStream(name);
                        int data;
                        while((data = fileInputStream.read()) != -1){
                            System.out.print((char) data);
                        }
                        fileInputStream.close();
                    }

                    System.out.println("");
                    break;
                }
                case "5":{
                    File file1 = new File(file.getName());
                    System.out.println("Current file" + file1.getAbsolutePath());
                    break;
                }
                case "6":{
                    String j;
                    String name1 = "";
                    System.out.println("==================");
                    System.out.println("1. Delete current file");
                    System.out.println("2. Delete other file");
                    System.out.println("other: Do not delete file");
                    j = sc.nextLine();
                    if(j.equals("1")){
                        name1 = file.getName();
                    } else if(j.equals("2")) {
                        System.out.print("File's fath: ");
                        name1 = sc.nextLine();
                    }
                    System.out.println(name1.length());

                    if(name1.length() > 0){
                        File file1 = new File(name1);
                        System.out.println(name1 + " i");
                        if(file1.exists()){
                            System.out.println(name1);
                            file1.delete();
                            System.out.println("Done");
                            if(j.equals("1")){
                                file.setName("");
                                file.setContent("");
                            }
                        }
                    }
                    break;
                } case "7":{
                    String name;
                    System.out.println("Enter folder's name");
                    name = sc.nextLine();
                    file.setNameFolder(name);
                    File d = new File(file.getNameFolder());
                    d.mkdir();
                    break;
                }
                default:{
                    c = false;
                    break;
                }
            }

        } while (c);
    }
}
