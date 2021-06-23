
package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.dao.MarcaDao;
import pe.company.model.Marca;

@Service

public class MarcaServiceImpl implements MarcaService{

    
    @Autowired
    @Qualifier("marcaDaoImpl")
    private MarcaDao marcaDao;
     
    @Override
    @Transactional(readOnly = false)
    public void insert(Marca marca) {
       marcaDao.insert(marca);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Marca marca) {
        marcaDao.update(marca);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_marca) {
        marcaDao.delete(id_marca);
    }

    @Override
    @Transactional(readOnly = true)
    public Marca findById(Integer id_marca) {
        return marcaDao.findById(id_marca);
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<Marca> findAll() {
        return  marcaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_marca) {
        return marcaDao.isExist(id_marca);
    }

    
}
