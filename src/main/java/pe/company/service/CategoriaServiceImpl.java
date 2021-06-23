
package pe.company.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Collection;
import pe.company.dao.CategoriaDao;
import pe.company.model.Categoria;

@Service

public class CategoriaServiceImpl implements CategoriaService{
       
    @Autowired
    @Qualifier("categoriaDaoImpl")
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(Categoria categoria) {
        categoriaDao.insert(categoria);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(Categoria categoria) {
        categoriaDao.update(categoria);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_categoria) {
        categoriaDao.delete(id_categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria findById(Integer id_categoria) {
        return  categoriaDao.findById(id_categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Categoria> findAll() {
        return  categoriaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isExist(Integer id_categoria) {
        return categoriaDao.isExist(id_categoria);
    }

 
}
