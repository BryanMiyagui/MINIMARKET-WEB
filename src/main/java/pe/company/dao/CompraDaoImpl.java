
package pe.company.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.company.model.Compra;

@Repository
public class CompraDaoImpl implements CompraDao{
    @PersistenceContext
    
    private EntityManager entityManager;

    public CompraDaoImpl() {
    }
    
    @Override
    public void insert(Compra compra) {
        entityManager.persist(compra);
    }

    @Override
    public void update(Compra compra) {
        entityManager.merge(compra);
    }

    @Override
    public void delete(Integer id_compra) {
        Compra compra=entityManager.find(Compra.class, id_compra);
        entityManager.remove(compra);
                
    }

    @Override
    public Compra findById(Integer id_compra) {
        
        return entityManager.find(Compra.class, id_compra);
    }

    @Override
    public Collection<Compra> findAll() {
        Query query=entityManager.createNativeQuery("select * from compras order by id_compra",Compra.class);
        return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_compra) {
        return this.findById(id_compra) != null;
    }
    
}
