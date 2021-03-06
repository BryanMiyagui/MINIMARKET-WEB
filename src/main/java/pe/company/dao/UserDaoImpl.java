/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import pe.company.model.UserVo;

@Repository
public class UserDaoImpl implements UserDao
{
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void insert(UserVo user) 
    {
        String bCrypt=passwordEncoder.encode(user.getPassword());
        user.setPassword(bCrypt);
        
        entityManager.persist(user);
    }
      @Override
    public void update(UserVo user) {
        entityManager.merge(user);
    }
        @Override
    public void delete(Integer id_user) {
        UserVo user=entityManager.find(UserVo.class, id_user);
        
        entityManager.remove(user);
    }

    @Override
    public UserVo findById(Integer id_user) {
        return entityManager.find(UserVo.class,id_user);
    }

    @Override
    public UserVo findByUsername(String username) 
    {
        Query query=entityManager.createNativeQuery("select * from users where username=:param",UserVo.class);
        query.setParameter("param",username);
        
        return (UserVo)query.getSingleResult();
    }    

  


    @Override
    public Collection<UserVo> findAll() {
        Query query=entityManager.createNativeQuery("select * from users order by id_user",UserVo.class);
        return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_user) {
        return this.findById(id_user) != null;
    }
}
