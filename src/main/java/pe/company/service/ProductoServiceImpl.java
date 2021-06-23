
package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.dao.ProductoDao;
import pe.company.model.Producto;

@Service
public class ProductoServiceImpl  implements ProductoService{
    @Autowired
    @Qualifier("productoDaoImpl")
    
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(Producto producto) {
        productoDao.insert(producto);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Producto producto) {
        productoDao.update(producto);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateIngresoStock(String id_producto, Integer stockIncrementar) {
        productoDao.updateIngresoStock( id_producto, stockIncrementar) ;
    }

    @Override
    @Transactional(readOnly = false)
    public void updateSalidaStock(String id_producto, Integer stockSalida) {
        productoDao.updateSalidaStock(id_producto, stockSalida);
    }
    
    
    
    @Override
    @Transactional(readOnly = false)
    public void delete(String id_producto) {
        productoDao.delete(id_producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findById(String id_producto) {
        return  productoDao.findById(id_producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Producto> findAll() {
        return productoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(String id_producto) {
        return  productoDao.isExist(id_producto);
    }

    @Override
    public Collection<Producto> findNombre(String nombre) {
        return productoDao.findNombre(nombre);
    }


}
