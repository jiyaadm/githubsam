package com.User.Controller;

import com.User.Model.AuthenticationReq;
import com.User.Model.Image;
import com.User.Model.JwtAuthResponse;
import com.User.Model.UserModel;
import com.User.Security.JwtToken;
import com.User.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    protected JwtToken jwtTokenUtil;

    @RequestMapping("/")
    public String home(){
        return "Welcome page";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestParam("username") String username,
                                                       @RequestParam("password") String password) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = service.loadUserByUsername(username);
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtAuthResponse(jwt));
    }


    @PostMapping("/register")
    public UserModel createUser(@RequestBody UserModel user) {
       return service.createMyUser(user);
    }

    @PostMapping("/register/photo")
    public String createUser(@RequestParam("username") String username,
                            @RequestParam("imagepath") MultipartFile imagedata) {
        return service.savemyphoto(username,imagedata);
    }
    @GetMapping("/users")
    public List<UserModel> findAllProducts() {
        return service.getUser();
    }

    @GetMapping("/UserById/{id}")
    public UserModel findUsertById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/ImageByUser/{username}")
    public Image findImageById(@PathVariable String username) {
        return service.getImageByUsername(username);
    }

    @GetMapping("/UserByusername/{username}")
    public UserModel findUsertById(@PathVariable String username) {
        return service.getUserByusername(username);
    }

    @PutMapping("/user/update")
    public UserModel updateUser(@RequestBody UserModel user) {
        return service.updateUser(user);
    }

    @PutMapping("/user/updateImage/{user}")
    public String updateUser(@PathVariable String olduser,@RequestParam("username") String username,
                                @RequestParam("imagepath") MultipartFile imagedata) {
        return service.updateImage(olduser,username,imagedata);
    }

    @DeleteMapping("/user/delete")
    public String deleteUser(@RequestParam Integer id,
                             @RequestParam("username") String username) {
        return service.deleteUser(id,username);
    }

}
