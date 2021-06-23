
package pe.company.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.company.model.RoleVo;


@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public RoleVo findById(Integer id_role) 
    {
        return entityManager.find(RoleVo.class, id_role);
    }

    @Override
    public void insert(RoleVo roleVo) {
        entityManager.persist(roleVo);
    }

    @Override
    public void update(RoleVo roleVo) {
        entityManager.merge(roleVo);
    }

    @Override
    public void delete(Integer id_role) {
        RoleVo roleVo =entityManager.find(RoleVo.class, id_role);
        entityManager.remove(roleVo);
    }
    
   @Override
    public RoleVo findByType(String type) {
        Query query=entityManager.createNamedQuery("Select * from role where type=:param",RoleVo.class);
        query.setParameter("param", type);
        return (RoleVo)query.getSingleResult();
    }

    @Override
    public Collection<RoleVo> findAll() 
    {
         Query query=entityManager.createNativeQuery("select * from roles order by id_role",RoleVo.class);
        return query.getResultList();
    
    }


    @Override
    public boolean isExist(Integer id_role) {
        return this.findById(id_role) != null;
    }
}
