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
import pe.company.model.TipoPago;


@Repository
public class TipoPagoDaoImpl implements TipoPagoDao {

   @PersistenceContext
   
   private EntityManager entityManager;

    public TipoPagoDaoImpl() {
    }

    @Override
    public void insert(TipoPago tipoPago) {
        entityManager.persist(tipoPago);
    }

    @Override
    public void update(TipoPago tipoPago) {
        entityManager.merge(tipoPago);
    }

    @Override
    public void delete(Integer id_tipoPago) {
         TipoPago tipoPago =entityManager.find(TipoPago.class, id_tipoPago);
        entityManager.remove(tipoPago);
    }

    @Override
    public TipoPago findById(Integer id_tipoPago) {
        return  entityManager.find(TipoPago.class, id_tipoPago);
    }

    @Override
    public Collection<TipoPago> findAll() {
          Query query=entityManager.createNativeQuery("select * from tipoPagos order by id_tipoPago",TipoPago.class);
         return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_tipoPago) {
        return this.findById(id_tipoPago) !=null;
    }
    
}
