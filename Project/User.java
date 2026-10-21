
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
    private static final String NAME_REGEX =  "^[\\p{L}]+(?:[-'][\\p{L}]+)*(?: [\\p{L}]+(?:[-'][\\p{L}]+)*)*$";
    private static final Pattern pattern = Pattern.compile(NAME_REGEX);

    

    //constructor
    protected  User (String userId, String name, String institutionalEmail, String passwordHash) {
        if  (isValidName(name) == false) {
            throw new IllegalArgumentException("Invalid Name.");
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


    private static boolean isValidName(String name) {
    return name != null
            && !name.trim().isEmpty()
            && name.length() >= 2
            && name.length() <= 50
            && containsLetter(name)
            && pattern.matcher(name).matches();
    }
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

void changeName(String newName) {
    validateNameChange(newName);
    this.name = newName;
}
        
         if (newName.equalsIgnoreCase(this.name)) {
            throw new IllegalArgumentException("New name cannot be previous name.");
        }
        
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
