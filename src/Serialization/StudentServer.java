package Serialization;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentServer {
    public static void main(String[] args) throws Exception {
        ArrayList<Student> stdt = new ArrayList<>();
        stdt.add(new Student("SUMIT", "02876687", "42Sumit.singh@gmail.com", "01", "CSIT"));
        stdt.add(new Student("SAMEER", "909774098", "Sameer123@hotmail.com", "02", "CSIT"));
        stdt.add(new Student("RAHUL", "9876543210", "RahulNakak@yahoo.com", "03", "CSIT"));
        stdt.add(new Student("ANKIT", "809756212", "Ak.2020@gmail.com", "04", "CSIT"));
        stdt.add(new Student("SUNITA", "809756215", "SunitaSingh@gmail.com", "05", "CSIT"));

        ServerSocket Serversocket = new ServerSocket(1024, 10);
        System.out.println("Contacts server is ready ....");

        while (true) {
            Socket client = Serversocket.accept();
            // take input and output streams
            Scanner scanner = new Scanner(client.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
            // find contact with the given name
            String name = scanner.nextLine();
            boolean found = false;
            for (Student st : stdt) {
                if (st.getName().equals(name)) {
                    found = true;
                    oos.writeObject(st); // serialize object and send to client
                }
            }
            if (!found) {
                // write Contact object only with name when name is not found
                oos.writeObject(new Student(name, null, null, null));
            }
            client.close();
        }
    }
}
