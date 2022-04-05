package com.NwHead.Lab2Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    //http://localhost:8080/users?pageSize=20&pageNumber=1
    /*@RequestMapping("/users")
    @ResponseBody
    public Object getUsers(@RequestParam Integer pageNumber, @RequestParam Integer pageSize)
    {
        return pageNumber + " " + pageSize;
    }

    //http://localhost:8080/users?pageSize=20&pageNumber=1
    /*@RequestMapping("/users")
    @ResponseBody
    public Object getUsers(@RequestParam Integer pageNumber, @RequestParam Integer pageSize)
    {
        List<UserEntity> users = new ArrayList<>();

        users.add(new UserEntity(1L, "Fakuś"));
        users.add(new UserEntity(2L, "Fikuś"));
        users.add(new UserEntity(3L, "Fokuś"));
        users.add(new UserEntity(4L, "Fapuś"));
        return users;
*/
    private Map<Integer, UserEntity> userEntityMap = new HashMap<>(){{
      put(1,new UserEntity(1L,"Borys"));
      put(2,new UserEntity(2L,"Leon"));
      put(3,new UserEntity(3L,"Tina"));
    }};

    //http://localhost:8080/users
    @RequestMapping("/users")
    @ResponseBody
    public Object allUsers() {return userEntityMap;}

    //http://localhost:8080/users/3/get
    @RequestMapping("/users/{id}/get")
    @ResponseBody
    public Object takeUser(@PathVariable int id) {return userEntityMap.get(id);}

    //http://localhost:8080/user/add?id=4&name=Maciej
    @RequestMapping("/user/add")
    @ResponseBody
    public Object addUser(@RequestParam Long id, @RequestParam String name)
    {
        int showId = userEntityMap.size() + 1;
        userEntityMap.put(showId,new UserEntity(id,name));
        return userEntityMap.get(showId);
    }

    //http://localhost:8080/users/3/remove
    @RequestMapping("/users/{id}/remove")
    @ResponseBody
    public Object removeUser(@PathVariable int id) {return userEntityMap.remove(id);}
}
