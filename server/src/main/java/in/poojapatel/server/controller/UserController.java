package in.poojapatel.server.controller;
import in.poojapatel.server.entity.User;
import in.poojapatel.server.entity.response.Response;
import in.poojapatel.server.entity.response.SignInResponse;
import in.poojapatel.server.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(path="/signin",method = RequestMethod.POST) // Map ONLY POST Requests
    public SignInResponse SignIn (@RequestBody User user) {
        return userService.SignIn(user);
    }
    @RequestMapping(path="/signup",method = RequestMethod.POST) // Map ONLY POST Requests
    public  Response SignUp (@RequestBody User user) {
        return  userService.SignUp(user);
    }
    @RequestMapping(path="/checkusersession",method = RequestMethod.POST) // Map ONLY POST Requests
    public Response CheckSession (@RequestBody User user) {
        return userService.CheckSession(user);
    }
    @RequestMapping(path="/getuserdetails",method = RequestMethod.POST) // Map ONLY POST Requests
    public Response GetUserDetails (@RequestBody User user) {
        return userService.GetUserDetails(user);
    }
    @RequestMapping(path="/edituserdetails",method = RequestMethod.POST) // Map ONLY POST Requests
    public Response EditUserDetails (@RequestBody User user) {
        return userService.EditUserDetails(user);
    }
}
