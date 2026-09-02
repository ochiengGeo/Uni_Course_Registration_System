import java.util.Scanner;

public class Professor extends User {
    private String assignedDpt;
    private String officeHours;
    Professor (String name, String Id, String email, String department, String offhours) {
        setCredentials (name, Id, email);
        this.officeHours = offhours;
        this.assignedDpt = department;
    }


    public static void main (String[] args) {
       Scanner cin = new Scanner(System.in);
       System.out.println();

       System.out.println("LECTURER");
       System.out.println(); 
       System.out.print("Enter your Name: ");
       String name = cin.nextLine();
       System.out.print("Enter Staff ID number for " + name +" : ");
       String staffID = cin.nextLine();
       System.out.print("Enter their Email Address: ");
       String email = cin.nextLine();
       System.out.print("Enter their Department: ");
       String department = cin.nextLine();
       Department dpt1 = new Department(department);
       System.out.print("Enter their Office Hours: ");
       String officehours = cin.nextLine();
       Professor p1 = new Professor(name, staffID, email, department, officehours);
       Course courseCompSci = new Course("Computer Science", department);
       courseCompSci.assignLec(p1);

       System.out.println();
       int choice;

       do {
       System.out.println("What Would You like to do, Professor " + name + "? ");
       System.out.println("  1. Enroll a Student.\n  2. See Students in the Department of " +department+ ".\n  3. Sign Out.");
       System.out.print("Enter Your Pick: ");
       choice = cin.nextInt();
       cin.nextLine();
       


       if (choice == 1) {
        System.out.println();
        System.out.println("STUDENT ENROLLMENT");
        System.out.println();
        System.out.print("Enter the Full Name of the Student : ");
        String sname = cin.nextLine();
        System.out.print("Enter " + sname + "'s Registration Number : ");
        String regNo = cin.nextLine();
        System.out.print("Enter the Student's Email Address: ");
        String sEmail = cin.nextLine();
        Student s1 = new Student(sname, regNo, sEmail);
        courseCompSci.enrollStudent(s1);
        dpt1.enrollToDpt(s1);
        System.out.println();
       }
       else if (choice == 2) {
        System.out.println();
        dpt1.getDptStudents();
       }
       else if (choice == 3) {
        System.out.println("Signed Out Successfully.");
        System.out.println();
       }
       else {
        System.out.println("Invalid Choice!");
       }
    } while (
        choice != 3
    );
       cin.close();
    }
}

