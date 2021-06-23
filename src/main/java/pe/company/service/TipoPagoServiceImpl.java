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
import pe.company.dao.TipoPagoDao;
import pe.company.model.TipoPago;

@Service
public class TipoPagoServiceImpl implements TipoPagoService{

    @Autowired
    @Qualifier("tipoPagoDaoImpl")
    
    private TipoPagoDao tipoPagoDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(TipoPago tipoPago) {
        tipoPagoDao.insert(tipoPago);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(TipoPago tipoPago) {
        tipoPagoDao.update(tipoPago);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_tipoPago) {
        tipoPagoDao.delete(id_tipoPago);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoPago findById(Integer id_tipoPago) {
        return tipoPagoDao.findById(id_tipoPago);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<TipoPago> findAll() {
        return tipoPagoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_tipoPago) {
        return tipoPagoDao.isExist(id_tipoPago);
    }
    
}
