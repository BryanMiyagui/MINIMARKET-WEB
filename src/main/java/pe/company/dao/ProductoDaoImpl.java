
package pe.company.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import pe.company.model.Producto;

@Repository
public class ProductoDaoImpl implements ProductoDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    public ProductoDaoImpl() {
    }
    
    @Override
    public void insert(Producto producto) {
        entityManager.persist(producto);
    }

    @Override
    public void update(Producto producto) {
        entityManager.merge(producto);
    }


    @Override
    public void updateIngresoStock(String id_producto, Integer stockIncrementar) {
        String SQL="update productos set stock =  stock  + "+stockIncrementar+" where id_producto = '"+id_producto+"'";
        
        entityManager.createQuery(SQL);
     
    }

    @Override
    public void updateSalidaStock(String id_producto, Integer stockSalida) {
          
        String SQL="update productos set stock =  stock  - "+stockSalida+" where id_producto = '"+id_producto+"'";
        
        entityManager.createQuery(SQL);       
    }
    
    
    @Override
    public void delete(String id_producto) {
        Producto producto=entityManager.find(Producto.class, id_producto);
        
        entityManager.remove(producto);
    }

    @Override
    public Producto findById(String id_producto) {
        return entityManager.find(Producto.class,id_producto);

    }

    @Override
    public Collection<Producto> findAll() {
        Query query=entityManager.createNativeQuery("select * from productos order by id_producto",Producto.class);
         return query.getResultList();
    }

    @Override
    public boolean isExist(String id_producto) {
        return this.findById(id_producto) != null;
    }

    
    @Override
    public Collection<Producto> findNombre(String nombre)         
    {    
       String SQL="select * from productos  where nombre like '%"+nombre+"%'";
        
        Query query=entityManager.createNativeQuery(SQL,Producto.class);
        
        
        return query.getResultList();
        
         
    }

    
}
