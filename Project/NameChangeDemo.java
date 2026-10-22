public class NameChangeDemo {

    public static void main(String[] args) {

        UniversitySystem universitySystem = new UniversitySystem();

        Admin admin = new Admin(
                "ADM-001",
                "System Admin",
                "admin@egerton.ac.ke",
                "demo-hash"
        );

        Student student = new Student(
                "S104",
                "George Ochieng",
                "george@egerton.ac.ke",
                "demo-hash"
        );

        System.out.println("Before: " + student.getName());

        universitySystem.changeUserName(
                admin, student, "George Otieno"
        );

        System.out.println("After: " + student.getName());

        System.out.println("\nAudit records:");

        for (AuditRecord record :
                universitySystem.getAuditRecords()) {
            System.out.println(record);
        }
    }
}
