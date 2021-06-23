
package pe.company.dao;

import java.util.Collection;
import pe.company.model.Compra;


public interface CompraDao {
    
    public abstract void insert(Compra compra);
    public abstract void update(Compra compra);
    public abstract void delete(Integer id_compra);
    
    public abstract Compra findById(Integer id_compra);
   
    public abstract Collection<Compra> findAll();
    public abstract boolean isExist(Integer id_compra); 
}
