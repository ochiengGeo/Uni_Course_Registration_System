
import java.util.EnumSet;
import java.util.Set;

public class Admin extends User {

    public Admin(String userId, String name,
                 String institutionalEmail, String passwordHash) {
        super(userId, name, institutionalEmail, passwordHash);
    }
}
