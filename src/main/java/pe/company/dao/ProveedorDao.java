/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.dao;

import java.util.Collection;

import pe.company.model.Proveedor;

/**
 *
 * @author jbustillos
 */
public interface ProveedorDao {
    public abstract void insert(Proveedor proveedor);
    public abstract void update(Proveedor proveedor);
    public abstract void delete(Integer id_proveedor);
    
    public abstract Proveedor findById(Integer id_proveedor);
    public abstract Collection<Proveedor> findAll();
    public abstract boolean isExist(Integer id_proveedor); 
}
