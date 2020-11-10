import java.util.HashMap;

public class SomethingLikeSessionBase {

    private static HashMap<String, String> users = new HashMap<String, String>();

    SomethingLikeSessionBase() {
        this.users.put("admin", "adminpass");
    }

    public boolean userExist(String user) {
        if (users.containsKey(user)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean addUser(String user, String password) {
        if (userExist(user)) {
            return false;
        }
        users.put(user, password);
        return true;
    }

    public boolean passCorrect(String user,String password){
        if (users.get(user).equals(password)){
            return true;
        }
        return false;
    }

}
