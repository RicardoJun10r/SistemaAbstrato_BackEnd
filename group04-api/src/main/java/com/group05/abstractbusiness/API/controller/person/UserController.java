package com.group05.abstractbusiness.API.controller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group05.abstractbusiness.helper.DTO.person.user.UserReq;
import com.group05.abstractbusiness.helper.DTO.person.user.UserRes;
import com.group05.abstractbusiness.helper.DTO.person.user.UserUpdate;
import com.group05.abstractbusiness.modules.service.Person.UserService;
    
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<UserRes> createUser(@RequestBody UserReq user){
        return new ResponseEntity<UserRes>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserRes> findByUsername(@PathVariable String email){
        return new ResponseEntity<UserRes>(userService.findUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<UserRes> updateUser(@RequestBody UserUpdate userUpdate){
        return new ResponseEntity<UserRes>(userService.updateUser(userUpdate), HttpStatus.OK);
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<UserRes> updatePassword(@RequestBody UserUpdate userUpdate){
        return new ResponseEntity<UserRes>(userService.updatePassword(userUpdate), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody UserReq userReq){
        return new ResponseEntity<String>(userService.deleteUser(userReq), HttpStatus.OK);
    }

}
