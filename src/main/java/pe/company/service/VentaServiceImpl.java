/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.company.dao.VentaDao;
import pe.company.model.Venta;

@Repository
public class VentaServiceImpl implements VentaService{
    
    @Autowired
    @Qualifier("ventaDaoImpl")
    private VentaDao ventaDao;
    

    @Override
    @Transactional(readOnly = false)
    public void insert(Venta venta) {
        ventaDao.insert(venta);
    }

    @Override
     @Transactional(readOnly = false)
    public void update(Venta venta) {
        ventaDao.update(venta);
    }

    @Override
     @Transactional(readOnly = false)
    public void delete(Integer id_venta) {
        ventaDao.delete(id_venta);
    }

    @Override
    @Transactional(readOnly = true)
    public Venta findById(Integer id_venta) {
        return ventaDao.findById(id_venta);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Venta> findAll() {
        return ventaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_venta) {
        return ventaDao.isExist(id_venta);
    }
    
}
