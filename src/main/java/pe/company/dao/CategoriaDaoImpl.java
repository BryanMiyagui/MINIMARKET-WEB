
package pe.company.dao;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.company.model.Categoria;

@Repository
public class CategoriaDaoImpl implements CategoriaDao{

    @PersistenceContext
    private EntityManager entityManager;

    public CategoriaDaoImpl() {
    }
    
    @Override
    public void insert(Categoria categoria) {
        entityManager.persist(categoria);
    }

    @Override
    public void update(Categoria categoria) {
        entityManager.merge(categoria);
    }

    @Override
    public void delete(Integer id_categoria) {
        Categoria categoria=entityManager.find(Categoria.class, id_categoria);
        
        entityManager.remove(categoria);
    }

    @Override
    public Categoria findById(Integer id_categoria) {
         return  entityManager.find(Categoria.class, id_categoria);
    }

    @Override
    public Collection<Categoria> findAll() {
         Query query=entityManager.createNativeQuery("select * from categorias order by id_categoria",Categoria.class);
        return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_categoria) {
       return this.findById(id_categoria) != null;
    }
  
    
}
