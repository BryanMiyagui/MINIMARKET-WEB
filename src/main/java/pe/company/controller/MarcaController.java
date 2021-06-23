
package pe.company.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.model.Marca;
import pe.company.service.MarcaService;


@Controller
public class MarcaController {
    
       
    @Autowired
    @Qualifier("marcaServiceImpl")
    private MarcaService marcaService;


      // Mantenimiento de Marca
    @RequestMapping(value="/marca",method=RequestMethod.GET)
    public String marca_GET(Map map) {
        //llamo al listado de roles para realizar el mantenimiento
        //a la pagina
        map.put("marca",marcaService.findAll());        
        return "marca";
    }    
    
    @RequestMapping(value="/marca", method = RequestMethod.POST, params = "btnIndex")
      public String marca_POST()
      {
        return "redirect:Listar/index";
      }

    // Mantenimiento de marca (Nuevo)    
    // cuando se llama a la ventana nuevo marca   (GET) 
    @RequestMapping(value = "/marca_nuevo" ,method=RequestMethod.GET)
    public String marca_nuevo_GET(Model model){

        //Creamos la variable de registro de Marca en blanco tabla Marca
        Marca modelMarca= new Marca();
       
        // Envias por parametro a la pagina WEB, renombrando la variable creada como (Marca)
        model.addAttribute("marca", modelMarca);
  
        return "marca_nuevo";
    }
    
    // cuando dar guardar en la ventana registrar role   (POST)
    @RequestMapping(value = "/marca_nuevo", method = RequestMethod.POST)
    //public String roles_nuevo_Post(){
    public String marca_nuevo_Post(Marca marca){
    
        // recibe la variable (marca) y lo envia al servicio insert
        marcaService.insert(marca);           

        return "redirect:/marca";

    }
    
    // Mantenimiento de marca (editar)    
   @RequestMapping(value = "/marca_editar/{id_marca}")
    public String marca_editar_GET(Model model, @PathVariable("id_marca") Integer id_marca)
    {
        Marca modelMarca = marcaService.findById(id_marca);
        
        model.addAttribute("marca", modelMarca);
        return "marca_editar";
    }
    
    @RequestMapping(value = "/marca_editar/{id_marca}", method = RequestMethod.POST)
    public String marca_editar_Post(Marca marca)
    {
        marcaService.update(marca);
        return "redirect:/marca";
    }
    
      
   // Mantenimiento de Marca (Eliminar)    
   @RequestMapping(value = "/marca_eliminar/{id_marca}")
    public String marca_eliminar_GET(Model model, @PathVariable("id_marca") Integer id_marca)
    {
        
        Marca modelMarca = marcaService.findById(id_marca);
        
        model.addAttribute("marca", modelMarca);
        return "marca_eliminar";
    }
    
    @RequestMapping(value = "/marca_eliminar/{id_marca}", method = RequestMethod.POST)
    public String marca_eliminar_Post(Marca marca)
    {
        
        marcaService.delete(marca.getId_marca());
        return "redirect:/marca";
    }
}
