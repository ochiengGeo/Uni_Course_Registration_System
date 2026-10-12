import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract  class User {
    //fields 
    private final String userId;
    private String name;
    private String personalEmail;
    private String institutionalEmail;
    private String passwordHash;
    private AccountStatus accountStatus;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String NAME_REGEX = "^[\\p{L}'\\-,.\\s]{2,50}$";
    private static final Pattern pattern = Pattern.compile(NAME_REGEX);

    

    //constructor
    protected  User (String userId, String name, String institutionalEmail, String passwordHash) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be empty.");
        }
        if (institutionalEmail == null || institutionalEmail.trim().isEmpty()) {
            throw new IllegalArgumentException("Institutional Email cannot be empty.");
        }
        if (passwordHash == null || passwordHash.trim().isEmpty()) {
            throw new IllegalArgumentException("Password Hash cannot be empty.");
        }


        if (!isValidStructure(institutionalEmail)) {
            throw new IllegalArgumentException("Invalid Institutional Email Address.");
        }

        
        this.userId = userId;
        this.name  = name;
        this.institutionalEmail = institutionalEmail;
        this.passwordHash = passwordHash;
        this.accountStatus = AccountStatus.PENDING;
        this.personalEmail = null;

    }
    //methods

    public String getName () {
        return name;
    }

    public String getUserId () {
        return userId;
    }
    public String getPersonalEmail () {
        return personalEmail;
    }
    public String getInstitutionalEmail () {
        return institutionalEmail;
    }
    public static boolean isValidStructure(String email) {
        if (email == null) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public AccountStatus getAccountStatus() {
        return this.accountStatus;
    }

    void changeName (String newName) {
        if (newName == null || newName.trim().isEmpty()) {
            throw new IllegalArgumentException("New Name cannot be empty.");
        }
        if (!pattern.matcher(newName).matches()) {
            throw new IllegalArgumentException("Invalid New Name.");
        }
         if (newName.equalsIgnoreCase(this.name)) {
            throw new IllegalArgumentException("New name cannot be previous name.");
        }
        
        this.name = newName;
    }
}
