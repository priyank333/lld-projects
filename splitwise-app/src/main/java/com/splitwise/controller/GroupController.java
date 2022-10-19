/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.controller;

import com.splitwise.model.Group;
import com.splitwise.model.Response;
import com.splitwise.service.GroupService;
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
@RequestMapping("splitwise/manage-group")
public class GroupController {

    @Autowired
    private GroupService groupService;
    
    @PostMapping("add-group")
    public ResponseEntity<Response> addGroup(@RequestBody Group group) {
        Response response = groupService.addGroup(group);
        ResponseEntity<Response> responseEntity = ResponseEntity.status(
                response.getStatusCode()).body(response);
        return responseEntity;
    }
}
