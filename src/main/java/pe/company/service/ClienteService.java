
package pe.company.service;

import java.util.Collection;
import pe.company.model.Cliente;

public interface ClienteService {
    
   public abstract void insert(Cliente cliente);
    public abstract void update(Cliente cliente);
    public abstract void delete(Integer id_cliente);
    
    public abstract Cliente findById(Integer id_cliente);
   
    public abstract Collection<Cliente> findAll();
    public abstract boolean isExist(Integer id_cliente); 
    
}
