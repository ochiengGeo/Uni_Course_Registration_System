import java.util.ArrayList;
import java.util.List;

public class Course {
   private String courseName;
   private String courseDpt; 
   private int maxCapacity = 5;
   private int vaccancy;
   private List<Student> enrolledStudents = new ArrayList<>();
   private List<Professor> lecsInCharge = new ArrayList<>();

   Course (String name, String dept) {
    this.courseName = name;
    this.courseDpt = dept;
   }

    public int getAvailableSeats () {
       this.vaccancy = maxCapacity - enrolledStudents.size() -1; 
       return maxCapacity - enrolledStudents.size();
    }

    public void enrollStudent (Student student) {
       if (getAvailableSeats() > 0) {
        enrolledStudents.add(student);
        System.out.println(student.getName() + " has been enrolled successfully.\n" + vaccancy + " seat(s) remaining.");
        vaccancy -= 1;
       } 
       else {
        System.out.println("Failed to add " + student.getName() + ". No more seats available in the course: " + courseName + ".");
       }
    }

    public void assignLec (Professor professor) {
        lecsInCharge.add(professor);
        System.out.println();
        System.out.println("Professor " + professor.getName());
    }
    
}
