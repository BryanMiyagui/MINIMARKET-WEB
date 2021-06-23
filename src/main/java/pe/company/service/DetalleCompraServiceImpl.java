
package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.dao.DetalleCompraDao;
import pe.company.dao.DetalleCompraDaoImpl;
import pe.company.model.DetalleCompra;
import pe.company.model.DetalleCompra2;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService{
    
    @Autowired
    @Qualifier("detalleCompraDaoImpl")
    private DetalleCompraDao detalleCompraDao;
    
    private DetalleCompraDao dao=new DetalleCompraDaoImpl();
    
    @Override
    @Transactional(readOnly = false)
    public void insert(DetalleCompra detalleCompra) {
        detalleCompraDao.insert(detalleCompra);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(DetalleCompra detalleCompra) {
        detalleCompraDao.update(detalleCompra);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_detalleCompra) {
        detalleCompraDao.delete(id_detalleCompra);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleCompra findById(Integer id_detalleCompra) {
        return detalleCompraDao.findById(id_detalleCompra);
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleCompra findByProducto(Integer id_producto) {
        return detalleCompraDao.findByProducto(id_producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<DetalleCompra> findAll() {
        return detalleCompraDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_detalleCompra) {
        return detalleCompraDao.isExist(id_detalleCompra);
    }

    @Override
    public void insertJDBC(DetalleCompra2 detalleCompra) {
        dao.insertJDBC(detalleCompra);
    }    
}
