
public class UniversitySystem {


    public void changeUserName(Admin admin, User user, String newName) {
        if (admin == null) {
            throw new IllegalArgumentException("Admin cannot be empty.");
        }
        if (user == null) {
            throw new IllegalArgumentException("User cannot be empty.");
        }

        user.changeName(newName);
    }
}
