/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.company.model.Proveedor;

/**
 *
 * @author jbustillos
 */
@Repository
public class ProveedorDaoImpl implements ProveedorDao{
    @PersistenceContext
    
    private EntityManager entityManager;

    public ProveedorDaoImpl() {
    }
    
    
    @Override
    public void insert(Proveedor proveedor) {
        entityManager.persist(proveedor);
    }

    @Override
    public void update(Proveedor proveedor) {
        entityManager.merge(proveedor);
    }

    @Override
    public void delete(Integer id_proveedor) {
        Proveedor proveedor=entityManager.find(Proveedor.class, id_proveedor);
        entityManager.remove(proveedor);
    }

    @Override
    public Proveedor findById(Integer id_proveedor) {
        return entityManager.find(Proveedor.class, id_proveedor);
    }

    @Override
    public Collection<Proveedor> findAll() {
        Query query=entityManager.createNativeQuery("select * from proveedores order by id_proveedor",Proveedor.class);
        return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_proveedor) {
        return this.findById(id_proveedor) != null;
    }
    
}
