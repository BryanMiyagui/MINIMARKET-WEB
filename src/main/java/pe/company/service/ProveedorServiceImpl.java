
package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.dao.ProveedorDao;
import pe.company.model.Proveedor;

/**
 *
 * @author jbustillos
 */
@Service
public class ProveedorServiceImpl implements ProveedorService
{
    @Autowired
    @Qualifier("proveedorDaoImpl")
    private ProveedorDao proveedorDao;

    @Override
    @Transactional(readOnly = false)
    public void insert(Proveedor proveedor) {
        proveedorDao.insert(proveedor);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Proveedor proveedor) {
        proveedorDao.update(proveedor);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_proveedor) {
        proveedorDao.delete(id_proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public Proveedor findById(Integer id_proveedor) {
        return proveedorDao.findById(id_proveedor);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Proveedor> findAll() {
        return proveedorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_proveedor) {
        return proveedorDao.isExist(id_proveedor);
    }
    
}
