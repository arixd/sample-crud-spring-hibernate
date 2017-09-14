/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ari.j2ee.dao;

import com.ari.j2ee.entitas.Users;
import java.util.List;

/**
 *
 * @author Ari
 */

public interface UserDao
{
    public List<Users> findAll();
    public Users findById(int id);
}
