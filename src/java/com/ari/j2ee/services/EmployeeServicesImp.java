/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.j2ee.services;

import com.ari.j2ee.dao.EmplyeeDao;
import com.ari.j2ee.entitas.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ari
 */
@Service("employeeServices")
public class EmployeeServicesImp implements EmployeeServices
{
    private EmplyeeDao dao;

    @Autowired
    public EmployeeServicesImp(EmplyeeDao dao)
    {
        this.dao = dao;
    }
    
    @Override
    public List<Employee> findList()
    {
        List<Employee> l = dao.findList();
        return l;
    }
}
