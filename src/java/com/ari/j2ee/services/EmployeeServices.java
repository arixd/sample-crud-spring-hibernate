/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.j2ee.services;

import com.ari.j2ee.entitas.Employee;
import java.util.List;

/**
 * @author Ari
 */
public interface EmployeeServices
{
    List<Employee> findList(); 
}
