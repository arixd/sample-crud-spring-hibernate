/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.j2ee.controller;

import com.ari.j2ee.entitas.Employee;
import com.ari.j2ee.services.EmployeeServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ari
 */

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController
{
    @Autowired  
    private  EmployeeServices service;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String index(Model m)
    {
        m.addAttribute("list", service.findList());
        return "index";
    }
    
    public List<Employee> listEmployee()
    {
        return service.findList();
    }
}

