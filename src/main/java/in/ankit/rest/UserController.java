package in.ankit.rest;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ankit.bind.Users;

@RestController
public class UserController {
       private HashOperations<String, Integer, Users> hashOps;
       
       public UserController(RedisTemplate<String, Users> redisTemplate) {
    	   hashOps = redisTemplate.opsForHash();
       }
	
       @PostMapping("/store")
       public String storeUser(@RequestBody Users user) {
    	   hashOps.put("Users",user.getUid(),user);
    	   return "success";
       }
       
       @GetMapping("/user/{uid}")
       public Users getUsers(@PathVariable Integer uid) {
    	   Users users = hashOps.get("Users", uid);
		   return users;
       }
       
       @GetMapping("/users")
       public List<Users> getAllUsers(@PathVariable Integer uid) {
    	   List<Users> values = hashOps.values("Users");
		   return values;
       }
       
       @DeleteMapping("/user/{uid}")
       public String deleteUsers(@PathVariable Integer uid) {
    	   hashOps.delete("Users", uid);
		   return "User deleted";
       }
       
       
       
}
