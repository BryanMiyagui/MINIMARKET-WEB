
package pe.company.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.model.TipoDocumento;
import pe.company.service.TipoDocumentoService;

@Controller
public class TipoDocumentoComtroller {
    
    @Autowired
    @Qualifier("tipoDocumentoServiceImpl")
    private TipoDocumentoService tipoDocumentoService;
    
      // Mantenimiento de TipoDocumento
    @RequestMapping(value="/tipoDocumento",method=RequestMethod.GET)
    public String tipoDocumento_GET(Map map) {
        //llamo al listado de TipoDocumento para realizar el mantenimiento
        //a la pagina
        map.put("LtipoDocumento",tipoDocumentoService.findAll());        
        return "tipoDocumento";
    }    
    
    @RequestMapping(value="/tipoDocumento", method = RequestMethod.POST, params = "btnIndex")
      public String tipoDocumento_POST()
      {
        return "redirect:Listar/index";
      }    
    
     // Mantenimiento de registro tipoDocumento_nuevo
    @RequestMapping(value="/tipoDocumento_nuevo",method=RequestMethod.GET)
    public String tipoDocumento_nuevo_GET(Model model) {
        //Creamos la variable de registro de TipoDocumento en blanco tabla TipoDocumento
        TipoDocumento  modelTipoDocumento= new TipoDocumento();
       
        // Envias por parametro a la pagina WEB, renombrando la variable creada como (categoria)
        model.addAttribute("tipoDocumento", modelTipoDocumento);
  
        return "tipoDocumento_nuevo";
    } 
    
    // cuando dar guardar en la ventana registrar tipoDocumento   (POST)
    @RequestMapping(value = "/tipoDocumento_nuevo", method = RequestMethod.POST)
    //public String roles_nuevo_Post(){
    public String tipoDocumento_nuevo_Post(TipoDocumento tipoDocumento){
    
        // recibe la variable (tipoDocumento) y lo envia al servicio insert
        tipoDocumentoService.insert(tipoDocumento);           

        return "redirect:/tipoDocumento";
    }
    
    
     // Mantenimiento de tipoDocumento (editar)    
   @RequestMapping(value = "/tipoDocumento_editar/{id_TipoDoc}")
    public String tipoDocumento_editar_GET(Model model, @PathVariable("id_TipoDoc") Integer id_TipoDoc)
    {
        TipoDocumento modelTipoDocumento= tipoDocumentoService.findById(id_TipoDoc);
        
        model.addAttribute("tipoDocumento", modelTipoDocumento);
        return "tipoDocumento_editar";
    }
    
    @RequestMapping(value = "/tipoDocumento_editar/{id_TipoDoc}", method = RequestMethod.POST)
    public String categoria_editar_Post(TipoDocumento tipoDocumento)
    {
        tipoDocumentoService.update(tipoDocumento);
        return "redirect:/tipoDocumento";
    }
       // Mantenimiento de tipoDocumento (Eliminar)      
   @RequestMapping(value = "/tipoDocumento_eliminar/{id_TipoDoc}")
    public String tipoDocumento_eliminar_GET(Model model, @PathVariable("id_TipoDoc") Integer id_TipoDoc)
    {
        
        TipoDocumento modelTipoDocumento = tipoDocumentoService.findById(id_TipoDoc);
        
        model.addAttribute("tipoDocumento", modelTipoDocumento);
        return "tipoDocumento_eliminar";
    }
    
    @RequestMapping(value = "/tipoDocumento_eliminar/{id_TipoDoc}", method = RequestMethod.POST)
    public String tipoDocumento_eliminar_Post(TipoDocumento tipoDocumento)
    {
        
        tipoDocumentoService.delete(tipoDocumento.getId_TipoDoc());
        return "redirect:/tipoDocumento";
    } 
    
}
