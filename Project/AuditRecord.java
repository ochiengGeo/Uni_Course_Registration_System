import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record AuditRecord(
        String eventId,
        String adminId,
        String affectedUserId,
        String oldName,
        String newName,
        Instant timestamp
) {
    public AuditRecord {
        Objects.requireNonNull(eventId, "Event ID cannot be null.");
        Objects.requireNonNull(adminId, "Admin ID cannot be null.");
        Objects.requireNonNull(affectedUserId,
                "Affected user ID cannot be null.");
        Objects.requireNonNull(oldName, "Old name cannot be null.");
        Objects.requireNonNull(newName, "New name cannot be null.");
        Objects.requireNonNull(timestamp, "Timestamp cannot be null.");
    }

    public static AuditRecord forNameChange(
            String adminId,
            String affectedUserId,
            String oldName,
            String newName
    ) {
        return new AuditRecord(
                UUID.randomUUID().toString(),
                adminId,
                affectedUserId,
                oldName,
                newName,
                Instant.now()
        );
    }
}
