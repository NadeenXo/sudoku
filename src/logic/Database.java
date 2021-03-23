
package logic;

import java.util.HashMap;

public class Database {
    public static HashMap setData(){ 
        HashMap<String,User> users = new HashMap<>();
        User obj1 = new User();
         User obj2 = new User();
          User obj3 = new User();
        
          /* User 1*/
       obj1.setName("admin");
       obj1.setEmail("admin123");
       obj1.setPassword("admin123456");
                      
               
       /*User 2*/
       obj2.setName("aadmin");
       obj2.setEmail("aadmin123");
       obj2.setPassword("aadmin123456");
       
       /* User 3*/
       obj3.setName("addmin");
       obj3.setEmail("addmin123");
       obj3.setPassword("addmin123456");
       
       
       users.put(obj1.getEmail(), obj1);
        users.put(obj2.getEmail(), obj2);
         users.put(obj3.getEmail(), obj3);
         
         return users;
    }
   
}
