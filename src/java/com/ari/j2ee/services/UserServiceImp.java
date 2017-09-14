/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.j2ee.services;

import com.ari.j2ee.dao.UserDao;
import com.ari.j2ee.entitas.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ari
 * Annotasi @service digunakan untuk menunjukkan sebuah class yang akan digunakan sebagai pusat service dari
 * aplikasi yang akan dibangun. Pusat service yang dimaksud adalah semua proses yang berhubungan dengan 
 * business logic akan dilakukan pada class ini bukan pada controller ataupun DAO
 */
@Service("serviceUser")
@Transactional(readOnly = true)
public class UserServiceImp implements UserServices
{
    @Autowired
    private UserDao userDao;

    @Override
    public List<Users> findAll()
    {
        return userDao.findAll();
    }

    @Override
    public void save(Users users)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users findById(int id)
    {
        return userDao.findById(id);
    }
}
