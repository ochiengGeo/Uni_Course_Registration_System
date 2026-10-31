import java.util.ArrayList;
import java.util.List;

public class UniversitySystem {

    private final List<AuditRecord> auditRecords =
            new ArrayList<>();

    public void changeUserName(
            Admin admin,
            User user,
            String newName
    ) {
        if (admin == null) {
            throw new IllegalArgumentException(
                    "Admin cannot be empty."
            );
        }

        if (user == null) {
            throw new IllegalArgumentException(
                    "User cannot be empty."
            );
        }

        // 1. Validate without changing the student's name.
        user.validateNameChange(newName);

        // 2. Capture the existing value.
        String oldName = user.getName();

        // 3. Prepare an immutable audit record.
        AuditRecord event = AuditRecord.forNameChange(
                admin.getUserId(),
                user.getUserId(),
                oldName,
                newName
        );

        // 4. Apply the change.
        user.changeName(newName);

        // 5. Keep the corresponding audit record.
        auditRecords.add(event);
    }

    public List<AuditRecord> getAuditRecords() {
        return List.copyOf(auditRecords);
    }

    
private void verifyPermissionAssignmentAuthority(Admin requester) {
    if (requester == null) {
        throw new IllegalArgumentException(
                "Requester cannot be null."
        );
    }

    if (!requester.hasPermission(Permission.ASSIGN_PERMISSIONS)) {
        throw new SecurityException(
                "Admin is not authorized to assign permissions."
        );
    }
}

private void verifyNoSelfEscalation(
        Admin requester,
        Admin target) {

    if (requester == target) {
        throw new SecurityException(
                "Admins cannot approve their own privilege escalation."
        );
    }
}

}
