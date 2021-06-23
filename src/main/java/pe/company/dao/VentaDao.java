
package pe.company.dao;

import java.util.Collection;
import pe.company.model.Venta;


public interface VentaDao {
    
    public abstract void insert(Venta venta);
    public abstract void update(Venta venta);
    public abstract void delete(Integer id_venta);
    
    public abstract Venta findById(Integer id_venta);
   
    public abstract Collection<Venta> findAll();
    public abstract boolean isExist(Integer id_venta); 
    
}
