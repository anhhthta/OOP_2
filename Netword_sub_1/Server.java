package Netword_sub_1;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args){
        try{
            ServerSocket ss=new ServerSocket(6666);
            Socket s=ss.accept();//establishes connection

            DataInputStream dis=new DataInputStream(s.getInputStream());
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());

            while(true){

                Scanner sc = new Scanner(System.in);
                String a = sc.nextLine();

                String  str=(String)dis.readUTF();
                System.out.println("Client: "+str);

                dout.writeUTF(a);

            }

        }catch(Exception e){System.out.println(e);}
    }
}