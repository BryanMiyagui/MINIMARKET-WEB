
package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.dao.CompraDao;
import pe.company.model.Compra;

@Service
public class CompraServiceImpl implements CompraService{
    @Autowired
    @Qualifier("compraDaoImpl")
    private CompraDao compraDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(Compra compra) {
        compraDao.insert(compra);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Compra compra) {
        compraDao.update(compra);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_compra) {
        compraDao.delete(id_compra);
    }

    @Override
    @Transactional(readOnly = true)
    public Compra findById(Integer id_compra) {
        return compraDao.findById(id_compra);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Compra> findAll() {
        return compraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_compra) {
        return compraDao.isExist(id_compra);
    }
    
}
