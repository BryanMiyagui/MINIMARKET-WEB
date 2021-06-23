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
import pe.company.dao.DetalleVentaDao;
import pe.company.dao.DetalleVentaDaoImpl;
import pe.company.model.DetalleVenta;
import pe.company.model.DetalleVenta2;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService{
    
    @Autowired
    @Qualifier("detalleVentaDaoImpl")
    private DetalleVentaDao detalleVentaDao;
    private DetalleVentaDao dao=new DetalleVentaDaoImpl();
    
    
    @Override
    @Transactional(readOnly = false)
    public void insert(DetalleVenta detalleVenta) {
        detalleVentaDao.insert(detalleVenta);
    }

    @Override
     @Transactional(readOnly = false)
    public void update(DetalleVenta detalleVenta) {
        detalleVentaDao.update(detalleVenta);
    }

    @Override
     @Transactional(readOnly = false)
    public void delete(Integer id_detalleVenta) {
         detalleVentaDao.delete(id_detalleVenta);
    }

    @Override
     @Transactional(readOnly = true)
    public DetalleVenta findById(Integer id_detalleVenta) {
        return detalleVentaDao.findById(id_detalleVenta);
    }

    @Override
     @Transactional(readOnly = true)
    public DetalleVenta findByProducto(Integer id_producto) {
        return detalleVentaDao.findByProducto(id_producto);
    }

    @Override
     @Transactional(readOnly = true)
    public Collection<DetalleVenta> findAll() {
        return detalleVentaDao.findAll();
    }

    @Override
     @Transactional(readOnly = true)
    public boolean isExist(Integer id_detalleVenta) {
       return detalleVentaDao.isExist(id_detalleVenta);
    }

    @Override
    public void insertJDBC(DetalleVenta2 detalleVenta) {
        dao.insertJDBC(detalleVenta);
    }
    
    
    
}
