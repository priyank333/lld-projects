/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.service;

import com.splitwise.dao.GroupDAO;
import com.splitwise.model.Group;
import com.splitwise.model.Response;
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
public class GroupService {

    @Autowired
    private GroupDAO groupDAO;

    @Transactional
    public Response addGroup(Group group) {
        String groupId = groupDAO.addGroup(group);
        Response response = new Response(HttpStatus.CREATED.value(), null);
        if (groupId != null) {
            response.setResponse(Map.of("groupId", groupId));
        } else {
            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setResponse("Not able to fulfill the operation");
        }
        return response;
    }
}
