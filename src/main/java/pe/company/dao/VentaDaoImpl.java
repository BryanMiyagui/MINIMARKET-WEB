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
import pe.company.model.Venta;

@Repository
public class VentaDaoImpl implements VentaDao{
    
    @PersistenceContext
    
    private EntityManager entityManager;

    public VentaDaoImpl() {
    }
    
    

    @Override
    public void insert(Venta venta) {
        entityManager.persist(venta);
    }

    @Override
    public void update(Venta venta) {
        entityManager.merge(venta);
    }

    @Override
    public void delete(Integer id_venta) {
       Venta venta=entityManager.find(Venta.class, id_venta);
        
        entityManager.remove(venta);
    }

    @Override
    public Venta findById(Integer id_venta) { 
        
       return entityManager.find(Venta.class, id_venta);
    }

    @Override
    public Collection<Venta> findAll() {
        Query query=entityManager.createNativeQuery("select * from ventas order by id_venta",Venta.class);
        return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_venta) {
        return this.findById(id_venta)!=null;
    }
    
}
