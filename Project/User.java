public class User {
    private String userName;
    private String userId;
    private String userEmail;

    public void setCredentials (String name, String userID, String email) {
        this.userName = name;
        this.userId = userID;
        this.userEmail = email;
        }
    
    public String getUserName () { // Kijana, all getter and setter methods must have rule(s) for them to b necessary.
        return userName;
    }
    public String getUserId () {
        return userId;
    }
    public String getUserEmail() {
        return userEmail;
    }
}
