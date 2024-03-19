package Homework4_sub1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static FileWriter fi;

    static {
        try {
            fi = new FileWriter("C:\\NTKT\\OOP_2\\src\\Homework4_sub1\\output.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


     static void avg(ArrayList<Student> l){

         try{
             FileWriter f = fi;
             f.write("-> Thực hiện tính trung bình: \n" );
             l.forEach((e) -> {
                 System.out.println("name: " + e.getName());
                 System.out.println("avg: " + e.getAvg());
                 try {
                     f.write("name: " + e.getName() + ", ");
                     f.write("avg: " + e.getAvg() + "\n");
                 } catch (IOException ex) {
                     throw new RuntimeException(ex);
                 }
             });
         } catch (IOException ex) {
             throw new RuntimeException(ex);
         }
    }

    static void s1(ArrayList<Student> l){
        try{
            FileWriter f = fi;
            f.write("-> Thực hiện in danh sách người đậu: \n" );

            l.forEach((e) -> {
                if(e.getRsl().equals("dau")){
                    System.out.println(e.toString());
                    try {
                        f.write(e.toString() + "\n");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static void s2(ArrayList<Student> l){

        try{
            FileWriter f = fi;
            f.write("-> Thực hiện in danh sách người trượt: \n" );

            l.forEach((e) -> {
                if(e.getRsl().equals("truot")){
                    System.out.println(e.toString());
                    try {
                        f.write(e.toString() + "\n");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static void print(ArrayList<Student> l){
        try{
            FileWriter f = fi;
            f.write("-> Thực hiện in danh sách: \n" );
            l.forEach((e) -> {
                System.out.println(e.toString() + ", " +  e.getAvg() + ", " + e.getRsl());

                try {
                    f.write(e.toString() + ", " +  e.getAvg() + ", " + e.getRsl() + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static void find(ArrayList<Student> l, String name){
        try{
            FileWriter f = fi;
            f.write("-> Thực hiện tìm kiếm người tên: " + name + "\n" );
            Boolean[] a = {true};

            l.forEach((e) -> {
                if(e.getName().equals(name)){
                    System.out.println(e.toString());
                    try {
                        f.write(e.toString() + "\n");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    a[0] = false;
                }
            });
            if(a[0]){
                System.out.println("Not Found!");
                try {
                    f.write("Not Found!" + "\n");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    static void arg(ArrayList<Student> l){

        try{
            FileWriter f = fi;
            f.write("-> Thực hiện sắp xếp: \n" );
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        for(int i = 0; i < l.size() - 1; i ++ ){
            for(int j = i + 1; j < l.size(); j ++){
                if(l.get(j).getAvg() >  l.get(i).getAvg()){
                    Student temp = l.get(i);
                    l.set(i, l.get(j));
                    l.set(j, temp);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Input i = new Input();
        i.nhapFile();

        Boolean c = true;

        while(c){
            System.out.println("1: Average: ");
            System.out.println("2: Print student: ");
            System.out.println("3: Arrange: ");
            System.out.println("4: Find by name ");
            System.out.println("5: shows those who passed");
            System.out.println("6: shows those who failed");
            System.out.println("other: exit");

            Scanner sc = new Scanner(System.in);
            String a = sc.nextLine();

            switch (a){

                case "1":{
                    avg(i.getL());
                    break;
                }
                case "2":{
                    print(i.getL());
                    break;
                }
                case "3":{
                    arg(i.getL());
                    break;
                }
                case "4":{
                    System.out.print("enter name: ");
                    String name = sc.nextLine();
                    find(i.getL(), name);
                    break;
                }
                case "5":{
                    s1(i.getL());
                    break;
                }
                case "6":{
                    s2(i.getL());
                    break;
                }
                default:{
                    fi.close();
                    c = false;
                    break;
                }
            }
        }
    }
}
