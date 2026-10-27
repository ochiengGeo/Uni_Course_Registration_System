
import java.util.EnumSet;
import java.util.Set;

public class Admin extends User {

    private final Set<Permission> permissions =
            EnumSet.noneOf(Permission.class);
    
    public Admin(String userId, String name,
                 String institutionalEmail, String passwordHash) {
        super(userId, name, institutionalEmail, passwordHash);
    }

    
    public boolean hasPermission(Permission permission) {
       return permissions.contains(permission);
   }

}
