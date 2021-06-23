/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.dao.UserDao;
import pe.company.model.UserVo;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao; //se inyecta el bean "userDaoImpl"

    @Override
    @Transactional(readOnly=false) //transacción fuerte
    public void insert(UserVo user) {
        userDao.insert(user);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void update(UserVo user) {
        userDao.update(user);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_user) {
        userDao.delete(id_user);
    }

    @Override
    @Transactional(readOnly=true)
    public UserVo findById(Integer id_user) {
        return userDao.findById(id_user);
    }

    @Override
    @Transactional(readOnly=true)
    public UserVo findByUsername(String username) {
        return userDao.findByUsername(username);
    }    

    @Override
    public Collection<UserVo> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean isExist(Integer id_user) {
        return userDao.isExist(id_user);
    }
}
