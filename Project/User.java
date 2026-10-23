import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {

    // Fields
    private final String userId;
    private String name;
    private String personalEmail;
    private String institutionalEmail;
    private String passwordHash;
    private AccountStatus accountStatus;

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    private static final String NAME_REGEX =
            "^[\\p{L}]+(?:[-'][\\p{L}]+)*(?: [\\p{L}]+(?:[-'][\\p{L}]+)*)*$";

    private static final Pattern NAME_PATTERN =
            Pattern.compile(NAME_REGEX);

    // Constructor
    protected User(
            String userId,
            String name,
            String institutionalEmail,
            String passwordHash
    ) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid Name.");
        }

        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "User ID cannot be empty."
            );
        }

        if (institutionalEmail == null
                || institutionalEmail.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Institutional Email cannot be empty."
            );
        }

        if (passwordHash == null || passwordHash.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Password Hash cannot be empty."
            );
        }

        if (!isValidStructure(institutionalEmail)) {
            throw new IllegalArgumentException(
                    "Invalid Institutional Email Address."
            );
        }

        this.userId = userId;
        this.name = name;
        this.institutionalEmail = institutionalEmail;
        this.passwordHash = passwordHash;
        this.accountStatus = AccountStatus.PENDING;
        this.personalEmail = null;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public String getInstitutionalEmail() {
        return institutionalEmail;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
        void activateAccountForDemo() {
           if (accountStatus != AccountStatus.PENDING) {
              throw new IllegalStateException(
                "Only pending accounts can be activated."
        );
    }

    accountStatus = AccountStatus.ACTIVE;
}
    }

    // Email validation
    public static boolean isValidStructure(String email) {
        if (email == null) {
            return false;
        }

        Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = emailPattern.matcher(email);

        return matcher.matches();
    }

    // Name validation
    private static boolean isValidName(String name) {
        return name != null
                && !name.trim().isEmpty()
                && name.length() >= 2
                && name.length() <= 50
                && containsLetter(name)
                && NAME_PATTERN.matcher(name).matches();
    }

    // Check a proposed name without changing the current name
    void validateNameChange(String newName) {
        if (!isValidName(newName)) {
            throw new IllegalArgumentException("Invalid New Name.");
        }

        if (newName.equalsIgnoreCase(this.name)) {
            throw new IllegalArgumentException(
                    "New name cannot be previous name."
            );
        }
    }

    // Apply the name change
    void changeName(String newName) {
        validateNameChange(newName);
        this.name = newName;
    }

    private static boolean containsLetter(String name) {
        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i))) {
                return true;
            }
        }

        return false;
    }
}
