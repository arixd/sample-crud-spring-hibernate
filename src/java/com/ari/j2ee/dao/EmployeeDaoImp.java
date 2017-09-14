/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.j2ee.dao;

import com.ari.j2ee.entitas.Employee;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Ari
 */
@Repository
public class EmployeeDaoImp implements EmplyeeDao
{
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Employee> findList()
    {
        return sessionFactory.openSession().createCriteria(Employee.class).list();
    }
    
}
