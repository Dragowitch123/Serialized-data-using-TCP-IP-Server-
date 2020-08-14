package Serialization;

import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class StudentClient {
    public static void main(String[] args) throws Exception {
        Socket Socket = new Socket("localhost", 1024);
        Scanner Scanner = new Scanner(System.in);
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        // take name from keyboard
        System.out.print("Enter person name : ");
        String name = Scanner.nextLine();

        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
        pw.println(name);

        Student stdt = (Student) ois.readObject();

        if (stdt.getMobile() == null) // contact not found
            System.out.printf("Sorry! %s not found\n", name);
        else {
            System.out.println("Mobile   : " + stdt.getMobile());
            System.out.println("Email    : " + stdt.getEmail());
            System.out.println("Name     : " + stdt.getName());
            System.out.println("Rollno   : " + stdt.getRollno());
            System.out.println("Course   : " + stdt.getCourse());
        }
    }
}
