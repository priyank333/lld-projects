/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.splitwise.controller;

import com.splitwise.model.Response;
import com.splitwise.requestbody.ExpenseReqBody;
import com.splitwise.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author priyank
 */
@RestController
@RequestMapping("splitwise/manage-expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;
    
    @PostMapping("add-expense")
    public ResponseEntity<Response> addExpense(
            @RequestBody ExpenseReqBody expenseReqBody) {
        Response response = expenseService.addExpense(expenseReqBody);
        ResponseEntity responseEntity = ResponseEntity.status(
                response.getStatusCode()).body(response);
        return responseEntity;
    }
    

    @GetMapping("view-amount-by-group")
    public ResponseEntity<Response> viewAmountByGroup(
            @RequestParam("groupId") String groupId) {
        Response response = expenseService.listGroupExpense(
                groupId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    

}
