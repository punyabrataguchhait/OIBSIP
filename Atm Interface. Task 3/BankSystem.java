import java.util.HashMap;

public class BankSystem {
    private static HashMap<String, UserAccount> users = new HashMap<>();

    static {
        users.put("user01", new UserAccount("user01", "1234", 5000));
        users.put("user02", new UserAccount("user02", "2345", 10000));
        users.put("user03", new UserAccount("user03", "3456", 3000));
    }

    public static UserAccount login(String userId, String pin) {
        UserAccount user = users.get(userId);
        if (user != null && user.validatePin(pin)) {
            return user;
        }
        return null;
    }

    public static UserAccount findUser(String userId) {
        return users.get(userId);
    }
}

    

