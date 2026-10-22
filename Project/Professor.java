import java.util.Scanner;
import java.util.InputMismatchException;

public class Professor extends User {
    private String assignedDpt;
    public Professor(
        String name,
        String Id,
        String email,
        String department,
        String passwordHash
) {
    super(Id, name, email, passwordHash);
    this.assignedDpt = department;
}

    public static boolean checkName (String name) {
        String namePattern = "^[a-zA-Z\\s]+$";
        if (name == null || !name.matches(namePattern)) {
            return false;
        }
        return true;

    }

    public static String fName (String name) {
        //Split the full name into words
        String[] words = name.trim().split("\\s+");
        StringBuilder formattedName = new StringBuilder();

        for (int i = 0; i < words.length; i++) { // for each word
            String word = words[i];
        
            // Capitalize first letter, lowercase the rest
            String formattedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
        
            // Append the formatted word to our result
            formattedName.append(formattedWord);
        
            // Add a space between names, but not after the very last name
            if (i < words.length - 1) {
               formattedName.append(" ");
          }
        }
        return formattedName.toString(); // fix here, 
    }

    public static boolean checkEmail(String input) {
    if (input == null) return false;

    String pattern = ".*(@gmail.com|@yahoo.com|@outlook.com)$";
    return input.toLowerCase().matches(pattern);
}

    public static boolean checkSEmail(String input) {
    if (input == null) return false;

    String pattern = ".*(@student.ac.ke|@gmail.com|@yahoo.com|@outlook.com)$";
    return input.toLowerCase().matches(pattern);
}


    public static void main (String[] args) {
       Scanner cin = new Scanner(System.in);
       System.out.println();

       System.out.println("LECTURER");
       System.out.println();

       // Check for invalid names, use while loop instead of do-while loop
       String name;
       do {
       System.out.print("Enter your Full Name: ");
       name = cin.nextLine();
       if (!checkName(name)) {
        System.out.println("Please enter a valid Name!\n");
       }
       }
       while (!checkName(name));
       name = fName(name);
       
       
       System.out.print("Enter Staff ID number for " + name +" : ");
       String staffID = cin.nextLine();

       //Check for invalid email address
       String email = "1";
       while (!checkEmail(email)) {
       System.out.print("Enter their Personal Email Address: ");
       email = cin.nextLine();
       if (!checkEmail(email)) {System.out.println("Invalid Email Address!\n");}
       }

       //Check for invalid department names
       String department = "1";
       while (!checkName(department)) {
       System.out.print("Enter their Department: ");
       department = cin.nextLine();
       if (!checkName(department)) {System.out.println("Please enter a valid Depatment Name!\n");}}
       department = fName(department);

       Department dpt1 = new Department(department);

       Professor p1 = new Professor(
        name,
        staffID,
        email,
        department,
        "DEMO_ONLY_PLACEHOLDER"
);
       Course courseCompSci = new Course("Computer Science", department);
       courseCompSci.assignLec(p1);

       System.out.println();
       int choice = 9;

       do {
       System.out.println("What Would You like to do, Professor " + name + "? ");
       System.out.println("  1. Enroll a Student.\n  2. See Students in the Department of " +department+ ".\n  3. Sign Out.");
       System.out.print("Enter Your Pick: ");
       try {
       choice = cin.nextInt();
       cin.nextLine();
       }
       catch (InputMismatchException e) {
        System.out.println("Invalid Choice!\n");
        cin.nextLine();
        continue;
       }
       

       if (choice == 1) {
        System.out.println();
        System.out.println("STUDENT ENROLLMENT");
        System.out.println();

        //student name
        String sname = "123";
        while (!checkName(sname)) {
        System.out.print("Enter the Full Name of the Student : ");
        sname = cin.nextLine();
        if (!checkName(sname)) {System.out.println("Invalid name!");}
        }
        sname = fName(sname);

        //student reg no.
        System.out.print("Enter " + sname + "'s Registration Number : ");
        String regNo = cin.nextLine();

        //student email
        String sEmail = "1";
        while (!checkSEmail(sEmail)) {
        System.out.print("Enter the Student's Email Address: ");
        sEmail = cin.nextLine();
        if (!checkSEmail(sEmail)) {System.out.println("Invalid Email Address!\n");}
        }

        Student s1 = new Student(
        regNo,
        sname,
        sEmail,
        "DEMO_ONLY_PLACEHOLDER"
);
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

