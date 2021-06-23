
package pe.company.dao;

import java.util.Collection;
import pe.company.model.TipoPago;


public interface TipoPagoDao {
    
    public abstract void insert(TipoPago tipoPago);
    public abstract void update(TipoPago tipoPago);
    public abstract void delete(Integer id_tipoPago);
    
    public abstract TipoPago findById(Integer id_tipoPago);
    public abstract Collection<TipoPago> findAll();
    public abstract boolean isExist(Integer id_tipoPago); 
    
}
