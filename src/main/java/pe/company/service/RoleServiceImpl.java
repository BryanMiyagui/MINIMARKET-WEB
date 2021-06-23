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
import pe.company.dao.RoleDao;
import pe.company.model.RoleVo;

@Service
public class RoleServiceImpl implements RoleService
{
    @Autowired
    @Qualifier("roleDaoImpl")
    private RoleDao roleDao;
 
    @Override
    @Transactional(readOnly = false)
    public void insert(RoleVo roleVo) {
        roleDao.insert(roleVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(RoleVo roleVo) {
        roleDao.update(roleVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_role) {
        roleDao.delete(id_role);
    }   
    @Override
    @Transactional(readOnly=true)
    public RoleVo findById(Integer id_role) {
        return roleDao.findById(id_role);
    }

    @Override
    @Transactional(readOnly=true)
    public RoleVo findByType(String type) {
        return roleDao.findByType(type);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<RoleVo> findAll() {
        return roleDao.findAll();
    }    


    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_role) {
        return roleDao.isExist(id_role);
    }
}
