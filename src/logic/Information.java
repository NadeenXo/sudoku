package logic;

import java.util.HashMap;
import static logic.Database.setData;

public class Information {

    public static HashMap<String, User> user;

    public Information() {
        user = setData();
    }

    public static boolean add(String name, String email, String password) {

        User user = check(email, password);

        if (user == null) {

            User obj_add = new User();
            obj_add.setName(name);
            obj_add.setEmail(email);
            obj_add.setPassword(password);
            Information.user.put(obj_add.getEmail(), obj_add);

            return true;
        }

        return false;

    }

    /*Start check method */
    public static User check(String mail, String password) {
        User user = Information.user.get(mail);
        if (user != null) {
            if (mail.equals(user.getEmail()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
