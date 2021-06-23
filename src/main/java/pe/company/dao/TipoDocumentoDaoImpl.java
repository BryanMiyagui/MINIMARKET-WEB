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
import pe.company.model.TipoDocumento;

@Repository
public class TipoDocumentoDaoImpl implements TipoDocumentoDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    public TipoDocumentoDaoImpl() {
    }
    
    @Override
    public void insert(TipoDocumento tipoDocumento) {
        entityManager.persist(tipoDocumento);
    }

    @Override
    public void update(TipoDocumento tipoDocumento) {
        entityManager.merge(tipoDocumento);
    }

    @Override
    public void delete(Integer id_TipoDoc) {
         TipoDocumento tipoDocumento =entityManager.find(TipoDocumento.class, id_TipoDoc);
        entityManager.remove(tipoDocumento);
        
    }

    @Override
    public TipoDocumento findById(Integer id_TipoDoc) {
        return entityManager.find(TipoDocumento.class,id_TipoDoc);
    }

    @Override
    public Collection<TipoDocumento> findAll() {
        Query query=entityManager.createNativeQuery("select * from tipoDocumentos order by id_TipoDoc",TipoDocumento.class);
         return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_TipoDoc) {
        return this.findById(id_TipoDoc) != null;
    }
   
}
