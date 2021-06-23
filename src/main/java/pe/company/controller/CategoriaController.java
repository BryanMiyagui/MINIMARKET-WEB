
package pe.company.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.model.Categoria;
import pe.company.service.CategoriaService;


@Controller
public class CategoriaController {
      
    @Autowired
    @Qualifier("categoriaServiceImpl")
    private CategoriaService categoriaService;


      // Mantenimiento de Marca
    @RequestMapping(value="/categoria",method=RequestMethod.GET)
    public String categoria_GET(Map map) {
        //llamo al listado de roles para realizar el mantenimiento
        //a la pagina
        map.put("categoria",categoriaService.findAll());        
        return "categoria";
    }    
    
    @RequestMapping(value="/categoria", method = RequestMethod.POST, params = "btnIndex")
      public String categoria_POST()
      {
        return "redirect:Listar/index";
      }
    
    // Mantenimiento de marca (Nuevo)    
    // cuando se llama a la ventana nuevo marca   (GET) 
    @RequestMapping(value = "/categoria_nuevo" ,method=RequestMethod.GET)
    public String categoria_nuevo_GET(Model model){

        //Creamos la variable de registro de categoria en blanco tabla categoria
        Categoria modelCategoria= new Categoria();
       
        // Envias por parametro a la pagina WEB, renombrando la variable creada como (categoria)
        model.addAttribute("categoria", modelCategoria);
  
        return "categoria_nuevo";
    }
    
    // cuando dar guardar en la ventana registrar role   (POST)
    @RequestMapping(value = "/categoria_nuevo", method = RequestMethod.POST)
    //public String roles_nuevo_Post(){
    public String categoria_nuevo_Post(Categoria categoria){
    
        // recibe la variable (categoria) y lo envia al servicio insert
        categoriaService.insert(categoria);           

        return "redirect:/categoria";

    }
   // Mantenimiento de Categoria (editar)    
   @RequestMapping(value = "/categoria_editar/{id_categoria}")
    public String categoria_editar_GET(Model model, @PathVariable("id_categoria") Integer id_categoria)
    {
        Categoria modelCategoria = categoriaService.findById(id_categoria);
        
        model.addAttribute("categoria", modelCategoria);
        return "categoria_editar";
    }
    
    @RequestMapping(value = "/categoria_editar/{id_categoria}", method = RequestMethod.POST)
    public String categoria_editar_Post(Categoria categoria)
    {
        categoriaService.update(categoria);
        return "redirect:/categoria";
    }
       // Mantenimiento de Categoria (Eliminar)    
   @RequestMapping(value = "/categoria_eliminar/{id_categoria}")
    public String categoria_eliminar_GET(Model model, @PathVariable("id_categoria") Integer id_categoria)
    {
        
        Categoria modelCategoria = categoriaService.findById(id_categoria);
        
        model.addAttribute("categoria", modelCategoria);
        return "categoria_eliminar";
    }
    
    @RequestMapping(value = "/categoria_eliminar/{id_categoria}", method = RequestMethod.POST)
    public String categoria_eliminar_Post(Categoria categoria)
    {
        
        categoriaService.delete(categoria.getId_categoria());
        return "redirect:/categoria";
    } 
}
