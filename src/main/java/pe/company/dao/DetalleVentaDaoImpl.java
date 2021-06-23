
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
import pe.company.model.DetalleVenta;
import pe.company.model.DetalleVenta2;

@Repository
public class DetalleVentaDaoImpl implements DetalleVentaDao{
  
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;    
    
    @PersistenceContext
    private EntityManager entityManager;

    public DetalleVentaDaoImpl() {
    }
    
        
  
    @Override
    public void insert(DetalleVenta detalleVenta) {
        entityManager.persist(detalleVenta);
    }

    @Override
    public void update(DetalleVenta detalleVenta) {
        entityManager.merge(detalleVenta);
    }

    @Override
    public void delete(Integer id_detalleVenta) {
        
        DetalleVenta detalleVenta=entityManager.find(DetalleVenta.class, id_detalleVenta);
        entityManager.remove(detalleVenta);
    }

    @Override
    public DetalleVenta findById(Integer id_detalleVenta) {
        return  entityManager.find(DetalleVenta.class, id_detalleVenta);
    }

    @Override
    public DetalleVenta findByProducto(Integer id_producto) {
        Query query=entityManager.createNativeQuery("select * from detalleVentas where id_producto=:param",DetalleVenta.class);
        query.setParameter("param",id_producto);
        
        return (DetalleVenta) query.getSingleResult();  
        
        
    }

    @Override
    public Collection<DetalleVenta> findAll() {
        Query query=entityManager.createNativeQuery("select * from detalleVentas order by id_detalleVenta",DetalleVenta.class);
        return query.getResultList();
    }

    @Override
    public boolean isExist(Integer id_detalleVenta) {
        return this.findById(id_detalleVenta)!= null;
    }

    @Override
    public void insertJDBC(DetalleVenta2 detalleVenta) {
         try
        {
            conn=ConnectionJDBC.MySQL();
            
         
            ps=conn.prepareStatement("insert into detalleVentas(id_venta, id_producto, cantidad, precio, valor_neto, IGV, Total) values(?,?,?,?,?,?,?)");
            ps.setInt(1,detalleVenta.getId_venta());
            ps.setString(2,detalleVenta.getId_producto());
            ps.setInt(3,detalleVenta.getCantidad());
  
            ps.setDouble(4,detalleVenta.getPrecio());
            ps.setDouble(5,detalleVenta.getValorneto());
            ps.setDouble(6,detalleVenta.getIgv());            
            ps.setDouble(7,detalleVenta.getTotal());  
            
            int rows=ps.executeUpdate();
            
            if(rows!=1)
                throw new Exception("Error Insert el detalle!");
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }       
    }
    
    
    
}
