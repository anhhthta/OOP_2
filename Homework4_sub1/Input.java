package Homework4_sub1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    private ArrayList<Student> l;
    private Student[] s;
    public Input() {
        l = new ArrayList<Student>();
    }

    public void nhapFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students");
        int n = Integer.parseInt(sc.nextLine());

        s = new Student[n];

        for(int i = 0; i < n; i++){
            s[i] = new Student();
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("mPython: ");
            String mp = sc.nextLine();
            System.out.print("mJava: ");
            String mj = sc.nextLine();

            s[i].setAll(id, name, gender, mp, mj);
            l.add(s[i]);
        }

        try(FileWriter fi = new FileWriter("C:\\NTKT\\OOP_2\\src\\Homework4_sub1\\input.txt");){
            l.forEach(e -> {
                try {
                    fi.write(e.toString() + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);

                }
            });

            fi.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<Student> getL() {
        return l;
    }

    public void setL(ArrayList<Student> l) {
        this.l = l;
    }
}
