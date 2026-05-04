import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

 class Student {
    public String studentName;
    public double studentGrade;
    public double studentAverage;

    public Student(String name, double grade) {
        this.studentName = name;
        this.studentGrade = grade;
    }

    // Getter methods - now properly inside the Student class
    public String getStudentName() {
        return studentName;
    }

    public double getStudentGrade() {
        return studentGrade;
    }

    public double getStudentAverage() {
        return studentAverage;
    }
}

// Separate class - not an inner class
 public class StudentGradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("-------Student Information-------");
            System.out.println("1. Add Student Name ");
            System.out.println("2. View all students ");
            System.out.println("3. Calculate Average Grade ");
            System.out.println("4. Exit ");
            System.out.println("Please select an option:  ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:  
                    System.out.println("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter Student Grade:  ");
                    double grade = scanner.nextDouble();
                    Student student = new Student(name, grade);
                    students.add(student);
                    System.out.println("Student added successfully.");
                    break;

                case 2: 
                    System.out.println("Viewing all students...");
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            System.out.println("Name: " + s.getStudentName());
                            System.out.println("Grade: " + s.getStudentGrade());
                        }
                    }
                    break;

                case 3: 
                    System.out.println("Calculating average grade...");
                    if (students.isEmpty()) {
                        System.out.println("No students to calculate average.");
                    } else {
                        double total = 0;
                        for (Student s : students) {
                            total += s.getStudentGrade();
                        }
                        double average = total / students.size();
                        System.out.println("Average grade: " + average);
                    }
                    break;

                case 4: 
                    System.out.println("Exiting.. Good-Bye! ");
                    scanner.close();
                    return; // Exit the program

                default: 
                    System.out.println("Invalid option. Please try again.");
            } 
        }
    }
}
