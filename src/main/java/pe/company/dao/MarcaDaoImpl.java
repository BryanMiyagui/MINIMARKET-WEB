
package pe.company.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.company.model.Marca;

@Repository
public class MarcaDaoImpl implements MarcaDao{
    @PersistenceContext
    private EntityManager entityManager;

    public MarcaDaoImpl() {
    }
     
    @Override
    public void insert(Marca marca) {
        entityManager.persist(marca);
    }

    @Override
    public void update(Marca marca) {
        entityManager.merge(marca);
    }

    @Override
    public void delete(Integer id_marca) {
        Marca marca =entityManager.find(Marca.class, id_marca);
        entityManager.remove(marca);
    }

    @Override
    public Marca findById(Integer id_marca) {
         return entityManager.find(Marca.class, id_marca);
    }

    @Override
    public Collection<Marca> findAll() {
        
         Query query=entityManager.createNativeQuery("select * from marcas order by id_marca",Marca.class);
        return query.getResultList();    }

    @Override
    public boolean isExist(Integer id_marca) {
        return this.findById(id_marca) != null;
    }


}
