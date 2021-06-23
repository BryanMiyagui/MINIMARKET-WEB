
package pe.company.dao;

import java.util.Collection;
import pe.company.model.Producto;

public interface ProductoDao {
    
    public abstract void insert(Producto producto);
    public abstract void update(Producto producto);
    
    
    public abstract void updateIngresoStock(String id_producto, Integer stockIncrementar);
    
    public abstract void updateSalidaStock(String id_producto, Integer stockSalida);
    
    
    public abstract void delete(String id_producto);
    
    public abstract Producto findById(String id_producto);
    public abstract Collection<Producto> findAll();
    public abstract boolean isExist(String id_producto); 
    
    public abstract Collection<Producto>  findNombre(String nombre);
}
