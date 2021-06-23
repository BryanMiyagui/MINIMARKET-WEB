
package pe.company.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pe.company.model.TipoPago;
import pe.company.service.TipoPagoService;

@Controller
public class TipoPagoController {
    
    @Autowired
    @Qualifier("tipoPagoServiceImpl")
    private TipoPagoService tipoPagoService;
    
    
        
    // Mantenimiento de TipoPago
    @RequestMapping(value="/tipoPago",method=RequestMethod.GET)
    public String TipoPago_GET(Map map) {
        //llamo al listado de tipo de pago para realizar el mantenimiento
        //a la pagina
        map.put("LtipoPago",tipoPagoService.findAll());        
        return "tipoPago";
    }    
    
    @RequestMapping(value="/tipoPago", method = RequestMethod.POST, params = "btnIndex")
      public String tipoPago_POST()
      {
        return "redirect:Listar/index";
      }    
        // Mantenimiento de registro tipo de pago
    @RequestMapping(value="/tipoPago_nuevo",method=RequestMethod.GET)
    public String tipoPago_nuevo_GET(Model model) {
        //Creamos la variable de registro de tipo pago en blanco tabla tipo pago
        TipoPago  modelTipoPago= new TipoPago();
       
        // Envias por parametro a la pagina WEB, renombrando la variable creada como (tipoPago)
        model.addAttribute("tipoPago", modelTipoPago);
  
        return "tipoPago_nuevo";
    } 
    
    // cuando dar guardar en la ventana registrar tipoDocumento   (POST)
    @RequestMapping(value = "/tipoPago_nuevo", method = RequestMethod.POST)
    //public String roles_nuevo_Post(){
    public String tipoPago_nuevo_Post(TipoPago tipoPago){
    
        // recibe la variable (tipoDocumento) y lo envia al servicio insert
        tipoPagoService.insert(tipoPago);           

        return "redirect:/tipoPago";
    }
     
     // Mantenimiento de tipo  pago (editar)    
   //@RequestMapping(value = "/tipoPago_editar/{id_tipoPago}",method=RequestMethod.GET)
   @RequestMapping(value = "/tipoPago_editar",method=RequestMethod.GET)
    public String tipoPago_editar_GET(Model model)
    //        public String tipoPago_editar_GET(Model model, @PathVariable("id_tipoPago") Integer id_tipoPago)
    {
       // TipoPago modelTipoPago= tipoPagoService.findById(id_tipoPago);
        TipoPago  modelTipoPago= new TipoPago();
        model.addAttribute("tipoPago", modelTipoPago);
        return "tipoPago_editar";
    }
    
    @RequestMapping(value = "/tipoPago_editar/{id_tipoPago}", method = RequestMethod.POST)
    public String tipoPago_editar_Post(TipoPago tipoPago)
    {
        tipoPagoService.update(tipoPago);
        return "redirect:/tipoPago";
    }  
      // Mantenimiento de tipo de pago (Eliminar)      
   @RequestMapping(value = "/tipoPago_eliminar/{id_tipoPago}")
    public String tipoPago_eliminar_GET(Model model, @PathVariable("id_tipoPago") Integer id_tipoPago)
    {
        
        TipoPago modelTipoPago= tipoPagoService.findById(id_tipoPago);
        
        model.addAttribute("tipoPago", modelTipoPago);
        return "tipoPago_eliminar";
    }
    
    @RequestMapping(value = "/tipoPago_eliminar/{id_tipoPago}", method = RequestMethod.POST)
    public String tipoPago_eliminar_Post(TipoPago tipoPago)
    {
        
        tipoPagoService.delete(tipoPago.getId_tipoPago());
        return "redirect:/tipoPago";
    } 
}
