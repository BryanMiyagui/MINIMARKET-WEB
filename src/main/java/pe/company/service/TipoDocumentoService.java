
package pe.company.service;

import java.util.Collection;
import pe.company.model.TipoDocumento;


public interface TipoDocumentoService {
    public abstract void insert(TipoDocumento tipoDocumento);
    public abstract void update(TipoDocumento tipoDocumento);
    public abstract void delete(Integer id_TipoDoc);
    
    public abstract TipoDocumento findById(Integer id_TipoDoc);
    public abstract Collection<TipoDocumento> findAll();
    public abstract boolean isExist(Integer id_TipoDoc); 
}
