
package pe.company.dao;

import java.util.Collection;
import pe.company.model.DetalleCompra;
import pe.company.model.DetalleCompra2;


public interface DetalleCompraDao {
    
    public abstract void insert(DetalleCompra detalleCompra);
    public abstract void update(DetalleCompra detalleCompra);
    public abstract void delete(Integer id_detalleCompra);
    
    public abstract DetalleCompra findById(Integer id_detalleCompra);
    public abstract DetalleCompra findByProducto(Integer id_producto);
    public abstract Collection<DetalleCompra> findAll();
    public abstract boolean isExist(Integer id_detalleCompra);
    
    public abstract void insertJDBC(DetalleCompra2 detalleCompra);
    
}
