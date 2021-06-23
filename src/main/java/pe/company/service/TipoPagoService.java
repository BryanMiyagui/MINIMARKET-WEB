/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company.service;

import java.util.Collection;
import pe.company.model.TipoPago;

public interface TipoPagoService {
    
    public abstract void insert(TipoPago tipoPago);
    public abstract void update(TipoPago tipoPago);
    public abstract void delete(Integer id_tipoPago);
    
    public abstract TipoPago findById(Integer id_tipoPago);
    public abstract Collection<TipoPago> findAll();
    public abstract boolean isExist(Integer id_tipoPago); 
    
}
