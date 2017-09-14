/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.j2ee.dao;

import com.ari.j2ee.entitas.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ari
 * Repository adalah anotasi yang digunakan 
 * untuk menunjukkan sebuah class akan dijadian DAO, 
 * pada class ini proses query logic seharusnya dibuat
 * 
 */
@Component
@Repository
public class UserDaoImp implements UserDao
{

//    untuk menyederhanakan penggunaa setter method untuk memanggil sebuah class pada depedency inejction
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List<Users> findAll()
    {
        return sessionFactory.getCurrentSession().createQuery("from Users").list();
    }

    @Override
    public Users findById(int id)
    {
        String sql="select * FROM users WHERE id=:id";
        Users users=null;
        try
        {
            Query query=sessionFactory.getCurrentSession().createSQLQuery(sql).setParameter("id", id);
            users= (Users) query.list().get(0);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return users;
    }
    
}
