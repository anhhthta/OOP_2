package Netword_sub_1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket s=new Socket("localhost",6666);
            DataInputStream dis = new DataInputStream(s.getInputStream());

            DataOutputStream dout=new DataOutputStream(s.getOutputStream());

            while(true){

                Scanner sc = new Scanner(System.in);
                String a = sc.nextLine();
                dout.writeUTF(a);


                String  str=(String)dis.readUTF();
                System.out.println("Server: "+str);
            }

        }catch(Exception e){System.out.println(e);}
    }
}  