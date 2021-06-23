/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.company.auxiliar.ConnectionJDBC;
import pe.company.model.DetalleCompra;
import pe.company.model.DetalleCompra2;


@Repository
public class DetalleCompraDaoImpl implements DetalleCompraDao
{
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
   @PersistenceContext    
    private EntityManager entityManager;

    public DetalleCompraDaoImpl() {
    }

    @Override
    public void insert(DetalleCompra detalleCompra) {
        entityManager.persist(detalleCompra);
    }

    @Override
    public void update(DetalleCompra detalleCompra) {
        entityManager.merge(detalleCompra);
    }

    @Override
    public void delete(Integer id_detalleCompra) {
       DetalleCompra detalleCompra=entityManager.find(DetalleCompra.class, id_detalleCompra);
        entityManager.remove(detalleCompra);
    }

    @Override
    public DetalleCompra findById(Integer id_detalleCompra) {
        
        return entityManager.find(DetalleCompra.class, id_detalleCompra);
    }

    @Override
    public DetalleCompra findByProducto(Integer id_producto) {
        Query query=entityManager.createNativeQuery("select * from detalleCompras where id_producto=:param",DetalleCompra.class);
        query.setParameter("param",id_producto);
        
        return (DetalleCompra) query.getSingleResult();    
    }

    @Override
    public Collection<DetalleCompra> findAll() {
        Query query=entityManager.createNativeQuery("select * from detalleCompras order by id_detalleCompra",DetalleCompra.class);
        return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_detalleCompra) {
  
        return this.findById(id_detalleCompra) != null;
    }

    @Override
    public void insertJDBC(DetalleCompra2 detalleCompra)
    {
        try
        {
            conn=ConnectionJDBC.MySQL();
            
            ps=conn.prepareStatement("insert into detalleCompras(id_compra,id_producto,cantidad) values(?,?,?)");
            ps.setInt(1,detalleCompra.getId_compra());
            ps.setString(2,detalleCompra.getId_producto());
            ps.setInt(3,detalleCompra.getCantidad());
            
            int rows=ps.executeUpdate();
            
            if(rows!=1)
                throw new Exception("Error Insert!");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
