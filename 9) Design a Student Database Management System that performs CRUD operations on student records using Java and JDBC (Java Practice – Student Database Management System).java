import java.sql.*;
import java.util.Scanner;

public class StudentDBMS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/studentdb";
        String username = "root";
        String password = "root";

        try {

            Connection con = DriverManager.getConnection(url, username, password);

            int choice;

            do {

                System.out.println("\n===== STUDENT DATABASE MANAGEMENT SYSTEM =====");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Roll Number: ");
                        int roll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Course: ");
                        String course = sc.nextLine();

                        String insertQuery = "INSERT INTO student VALUES(?,?,?)";

                        PreparedStatement ps1 = con.prepareStatement(insertQuery);

                        ps1.setInt(1, roll);
                        ps1.setString(2, name);
                        ps1.setString(3, course);

                        ps1.executeUpdate();

                        System.out.println("Student Record Inserted Successfully.");
                        break;

                    case 2:

                        String selectQuery = "SELECT * FROM student";

                        Statement st = con.createStatement();

                        ResultSet rs = st.executeQuery(selectQuery);

                        System.out.println("\n--------------------------------------");
                        System.out.println("Roll\tName\tCourse");
                        System.out.println("--------------------------------------");

                        while (rs.next()) {

                            System.out.println(
                                    rs.getInt("roll") + "\t" +
                                    rs.getString("name") + "\t" +
                                    rs.getString("course"));
                        }

                        break;

                    case 3:

                        System.out.print("Enter Roll Number to Update: ");
                        int updateRoll = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter New Course: ");
                        String newCourse = sc.nextLine();

                        String updateQuery = "UPDATE student SET course=? WHERE roll=?";

                        PreparedStatement ps2 = con.prepareStatement(updateQuery);

                        ps2.setString(1, newCourse);
                        ps2.setInt(2, updateRoll);

                        int updated = ps2.executeUpdate();

                        if (updated > 0)
                            System.out.println("Student Record Updated Successfully.");
                        else
                            System.out.println("Student Record Not Found.");

                        break;

                    case 4:

                        System.out.print("Enter Roll Number to Delete: ");
                        int deleteRoll = sc.nextInt();

                        String deleteQuery = "DELETE FROM student WHERE roll=?";

                        PreparedStatement ps3 = con.prepareStatement(deleteQuery);

                        ps3.setInt(1, deleteRoll);

                        int deleted = ps3.executeUpdate();

                        if (deleted > 0)
                            System.out.println("Student Record Deleted Successfully.");
                        else
                            System.out.println("Student Record Not Found.");

                        break;

                    case 5:

                        System.out.println("Exiting Program...");
                        break;

                    default:

                        System.out.println("Invalid Choice.");

                }

            } while (choice != 5);

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
====================================================
MySQL Commands

CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE student(
    roll INT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50)
);

====================================================
*/
