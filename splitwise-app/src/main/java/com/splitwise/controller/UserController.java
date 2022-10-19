/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.controller;

import com.splitwise.model.Response;
import com.splitwise.model.User;
import com.splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author priyank
 */
@RestController
@RequestMapping("splitwise/manage-user")
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping("add-user")
    public ResponseEntity<Response> addUser(@RequestBody User user) {
        Response response = userService.addUser(user);
        ResponseEntity<Response> responseEntity = ResponseEntity.status(
                response.getStatusCode()).body(response);
        return responseEntity;
    }
}
