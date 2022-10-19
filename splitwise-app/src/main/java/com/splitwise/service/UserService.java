/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.service;

import com.splitwise.dao.UserDAO;
import com.splitwise.model.Response;
import com.splitwise.model.User;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author priyank
 */
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public Response addUser(User user) {
        String userId = userDAO.addUser(user);
        Response response = new Response(HttpStatus.CREATED.value(), null);
        if (userId != null) {
            response.setResponse(Map.of("userId", userId));
        } else {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setResponse("Not able to fulfill the operation");
        }
        return response;
    }
}
