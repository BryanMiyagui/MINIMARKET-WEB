
package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.dao.TipoDocumentoDao;
import pe.company.model.TipoDocumento;

@Service
public class TipoDocumentoServiceImpl implements TipoDocumentoService{
    
    @Autowired
    @Qualifier("tipoDocumentoDaoImpl")
    
    private TipoDocumentoDao tipoDocumentoDao;

    @Override
    @Transactional(readOnly = false)
    public void insert(TipoDocumento tipoDocumento) {
        tipoDocumentoDao.insert(tipoDocumento);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(TipoDocumento tipoDocumento) {
        tipoDocumentoDao.update(tipoDocumento);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_TipoDoc) {
       tipoDocumentoDao.delete(id_TipoDoc);
    }

    @Override
    @Transactional(readOnly = true)
    public TipoDocumento findById(Integer id_TipoDoc) {
        return tipoDocumentoDao.findById(id_TipoDoc);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<TipoDocumento> findAll(){
        return tipoDocumentoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_TipoDoc){
        return tipoDocumentoDao.isExist(id_TipoDoc);
    }
    
    
}
