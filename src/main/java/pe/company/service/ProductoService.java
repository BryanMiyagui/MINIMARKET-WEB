/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.service;

import java.util.Collection;
import pe.company.model.Producto;

public interface ProductoService {
        public abstract void insert(Producto producto);
    public abstract void update(Producto producto);
    
    public abstract void updateIngresoStock(String id_producto, Integer stockIncrementar);
    
    public abstract void updateSalidaStock(String id_producto, Integer stockSalida);
    
    public abstract void delete(String id_producto);
    
    public abstract Producto findById(String id_producto);
    public abstract Collection<Producto> findAll();
    public abstract boolean isExist(String id_producto); 

    public abstract Collection<Producto>  findNombre(String nombre);
}
