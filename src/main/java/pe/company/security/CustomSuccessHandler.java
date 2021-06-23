
package pe.company.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
{
    //objeto redireccionamiento
    private RedirectStrategy redirectStrategy=
            new DefaultRedirectStrategy();
    
    @Override
    protected void handle(HttpServletRequest request, 
        HttpServletResponse response, Authentication authentication) 
            throws IOException, ServletException 
    {
        //url destino
        String targetURL=this.determineTargetUrl(authentication);
        
        //redireccionar al URL destino
        redirectStrategy.sendRedirect(request,response,targetURL);
    }

    protected String determineTargetUrl(Authentication authentication) 
    {
        String url;
        
        //colección de roles (vacío)
        Collection<String> roles=new ArrayList();
        
        //colección de roles (cargado)
        for(GrantedAuthority authority:authentication.getAuthorities()) {
            roles.add(authority.getAuthority());
        }
        
        if(roles.contains("ROLE_ADMINISTRADOR"))
            url="/administrador";
        else if(roles.contains("ROLE_VENDEDOR"))
            url="/vendedor";
        else if(roles.contains("ROLE_ALMACENERO"))
            url="/almacenero";
        else if(roles.contains("ROLE_CLIENTES"))
            url="/clientes";
        else
            
            url="/access_denied";
        
        return url;
    }
}
