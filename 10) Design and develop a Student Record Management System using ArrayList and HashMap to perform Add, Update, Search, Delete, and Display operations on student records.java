import java.util.*;

class Student {
    int roll;
    String name;
    String course;

    Student(int roll, String name, String course) {
        this.roll = roll;
        this.name = name;
        this.course = course;
    }

    public String toString() {
        return "Roll No: " + roll + "\nName: " + name + "\nCourse: " + course;
    }
}

public class StudentRecordManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Student> studentList = new ArrayList<>();
        HashMap<Integer, Student> studentMap = new HashMap<>();

        int choice;

        do {
            System.out.println("\n===== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();

                    if (studentMap.containsKey(roll)) {
                        System.out.println("Student already exists.");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student s = new Student(roll, name, course);

                    studentList.add(s);
                    studentMap.put(roll, s);

                    System.out.println("Student Added Successfully.");
                    break;

                case 2:

                    System.out.print("Enter Roll Number to Update: ");
                    roll = sc.nextInt();
                    sc.nextLine();

                    if (studentMap.containsKey(roll)) {

                        Student st = studentMap.get(roll);

                        System.out.print("Enter New Name: ");
                        st.name = sc.nextLine();

                        System.out.print("Enter New Course: ");
                        st.course = sc.nextLine();

                        System.out.println("Student Updated Successfully.");

                    } else {

                        System.out.println("Student Not Found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Roll Number to Search: ");
                    roll = sc.nextInt();

                    if (studentMap.containsKey(roll)) {
                        System.out.println(studentMap.get(roll));
                    } else {
                        System.out.println("Student Not Found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Roll Number to Delete: ");
                    roll = sc.nextInt();

                    if (studentMap.containsKey(roll)) {

                        Student st = studentMap.remove(roll);
                        studentList.remove(st);

                        System.out.println("Student Deleted Successfully.");

                    } else {

                        System.out.println("Student Not Found.");
                    }

                    break;

                case 5:

                    if (studentList.isEmpty()) {

                        System.out.println("No Student Records.");

                    } else {

                        System.out.println("\n===== Student Records =====");

                        for (Student st : studentList) {
                            System.out.println(st);
                            System.out.println("--------------------------");
                        }
                    }

                    break;

                case 6:

                    System.out.println("Program Ended.");
                    break;

                default:

                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
