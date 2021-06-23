
package pe.company.service;

import java.util.Collection;
import pe.company.model.DetalleVenta;
import pe.company.model.DetalleVenta2;

public interface DetalleVentaService {
    
    public abstract void insert(DetalleVenta detalleVenta);
    public abstract void update(DetalleVenta detalleVenta);
    public abstract void delete(Integer id_detalleVenta);
    
    public abstract DetalleVenta findById(Integer id_detalleVenta);
    public abstract DetalleVenta findByProducto(Integer id_producto);
    public abstract Collection<DetalleVenta> findAll();
    public abstract boolean isExist(Integer id_detalleVenta);
    
    public abstract void insertJDBC(DetalleVenta2 detalleVenta);
}
