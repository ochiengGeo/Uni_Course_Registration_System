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
        System.out.println("\n--- Testing Invalid Name ---");

int recordsBefore = universitySystem.getAuditRecords().size();

try {
    universitySystem.changeUserName(
            admin, student, "George!!"
    );
} catch (IllegalArgumentException e) {
    System.out.println("Change rejected: " + e.getMessage());
}

System.out.println("Current name: " + student.getName());

System.out.println(
        "Audit records before: " + recordsBefore
);

System.out.println(
        "Audit records after: "
                + universitySystem.getAuditRecords().size()
);
        System.out.println("\n--- Testing Second Name Change ---");

universitySystem.changeUserName(
        admin, student, "George Kamau"
);

System.out.println("Current name: " + student.getName());
System.out.println(
        "Total audit records: "
                + universitySystem.getAuditRecords().size()
);

System.out.println("\nAll audit records:");

for (AuditRecord record : universitySystem.getAuditRecords()) {
    System.out.println(record);
}
    }
}
