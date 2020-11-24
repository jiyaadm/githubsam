package com.User.Service;

import com.User.Model.UserModel;
import com.User.Model.Image;

import com.User.repository.ImageRepository;
import com.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ImageRepository imageRepository;


    public UserModel createMyUser(UserModel user)
    {
        return userRepository.save(user);
    }

    public String savemyphoto(String username, MultipartFile imagedata)
    {
        Image user = new Image();
        String fileName = StringUtils.cleanPath(imagedata.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("Image not valid");
        }
        try {
            user.setImagepath(Base64.getEncoder().encodeToString(imagedata.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setUsername(username);
        user.setImagename(fileName);
        imageRepository.save(user);
        return user.getImagename();
    }
    public List<UserModel> createMyUsers(List<UserModel> users){
        return userRepository.saveAll(users);
    }

    public List<UserModel> getUser(){
        return userRepository.findAll();
    }

    public UserModel getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }

    public Image getImageByUsername(String username){
        return imageRepository.findByUsername(username);
    }

    public UserModel getUserByusername(String username){
        return userRepository.findByusername(username);
    }


    public String deleteUser(int id, String username) {
        userRepository.deleteById(id);
        imageRepository.deleteByUsername(username);
        return "User removed !! " + id;
    }

    public String updateImage(String olduser,String username, MultipartFile imagedata) {
        Image existingImage = imageRepository.findByUsername(olduser);
        String fileName = StringUtils.cleanPath(imagedata.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("Image not valid");
        }
        try {
            existingImage.setImagepath(Base64.getEncoder().encodeToString(imagedata.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        existingImage.setUsername(username);
        existingImage.setImagename(fileName);
        imageRepository.save(existingImage);
        return existingImage.getImagename();
    }

    public UserModel updateUser(UserModel user) {
        UserModel existingUser = userRepository.findById(user.getId()).orElse(null);
        existingUser.setUsername(user.getUsername());
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setPassword(user.getPassword());
        existingUser.setDate(user.getDate());
        return userRepository.save(existingUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userRepository.findByusername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
    }
}
