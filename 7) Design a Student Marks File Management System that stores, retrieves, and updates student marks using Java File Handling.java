import java.io.*;
import java.util.*;

public class StudentMarksFile {

    static final String FILE_NAME = "students.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("\n----- Student Marks File Management -----");
            System.out.println("1. Store Student Marks");
            System.out.println("2. Display Student Records");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    storeMarks();
                    break;
                case 2:
                    displayMarks();
                    break;
                case 3:
                    updateMarks();
                    break;
                case 4:
                    System.out.println("Program Ended.");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void storeMarks() throws IOException {

        FileWriter fw = new FileWriter(FILE_NAME, true);

        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        sc.nextLine();

        fw.write(id + "," + name + "," + marks + "\n");
        fw.close();

        System.out.println("Record Saved Successfully.");
    }

    static void displayMarks() throws IOException {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No Records Found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;

        System.out.println("\nStudent Records:");
        while ((line = br.readLine()) != null) {
            String data[] = line.split(",");
            System.out.println("ID: " + data[0] +
                    "  Name: " + data[1] +
                    "  Marks: " + data[2]);
        }

        br.close();
    }

    static void updateMarks() throws IOException {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            System.out.println("No Records Found.");
            return;
        }

        System.out.print("Enter Student ID to Update: ");
        String searchId = sc.nextLine();

        File temp = new File("temp.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {

            String data[] = line.split(",");

            if (data[0].equals(searchId)) {

                System.out.print("Enter New Marks: ");
                int newMarks = sc.nextInt();
                sc.nextLine();

                bw.write(data[0] + "," + data[1] + "," + newMarks);
                bw.newLine();

                found = true;

            } else {

                bw.write(line);
                bw.newLine();
            }
        }

        br.close();
        bw.close();

        file.delete();
        temp.renameTo(file);

        if (found)
            System.out.println("Marks Updated Successfully.");
        else
            System.out.println("Student ID Not Found.");
    }
}
