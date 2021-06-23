/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.company;

import com.mchange.v2.c3p0.*;
import java.beans.*;
import javax.persistence.*;
import javax.sql.*;
import org.springframework.beans.factory.config.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.context.support.*;
import org.springframework.dao.annotation.*;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.*;
import org.springframework.orm.jpa.support.*;
import org.springframework.orm.jpa.vendor.*;
import org.springframework.transaction.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.*;
import pe.company.model.RoleConverter;

@Configuration
@ComponentScan
@EnableWebMvc
@EnableTransactionManagement
public class WebConfig extends WebMvcConfigurerAdapter
{
    @Bean //resuelve la ruta de los JSPs.
    public ViewResolver viewResolver() 
    {
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        
        return resolver;
    }

    @Bean //pool de conexiones c3p0 para aplicaciones de producción.
    public ComboPooledDataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource ds=new ComboPooledDataSource();
        
        ds.setDriverClass("com.mysql.jdbc.Driver"); //Driver de la BD
        ds.setJdbcUrl("jdbc:mysql://172.96.143.27:3306/db_minimarket?createDatabaseIfNotExist=true"); //conexión a la BD
        ds.setUser("root"); //nombre del usuario
        ds.setPassword("actelperusac"); //password del usuario
        
        ds.setMinPoolSize(10);
        ds.setMaxPoolSize(50);
        ds.setMaxStatements(10);
        
        ds.setTestConnectionOnCheckout(true);
        
        return ds;
    }
    
    @Bean //adaptador que transforma las cosas de JPA a Hibernate.
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter va=new HibernateJpaVendorAdapter();
        
        va.setDatabase(Database.MYSQL); //BD elegida
        va.setShowSql(true);
        va.setGenerateDdl(true);
        va.setDatabasePlatform("org.hibernate.dialect.MySQLDialect"); //dialecto de la BD
                
        return va;
    }

    @Bean //permite crear objetos de tipo EntityManager.
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter) {        
        LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
        
        emf.setDataSource(dataSource);
        emf.setJpaVendorAdapter(jpaVendorAdapter);
        emf.setPackagesToScan("pe.company.model");
        
        return emf;
    }

    @Bean //permite administrar las transacciones de manera automática.
    public PlatformTransactionManager transactionManager(DataSource dataSource,EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager tm=new JpaTransactionManager();
        
        tm.setDataSource(dataSource);
        tm.setEntityManagerFactory(entityManagerFactory);
        
        return tm;
    }

    @Bean //permite usar la anotación @PersistenceContext de JPA.
    public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
        return new PersistenceAnnotationBeanPostProcessor();
    }

    @Bean //permite ver excepciones más limpias y entendibles.
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
    
    //bean convertidor
    @Bean
    public RoleConverter roleConverter()
    {
        RoleConverter rc=new RoleConverter();
        return rc;
    }
    
    //método que agrega el convertidor
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(roleConverter());
    }
    
    //bean para las expeciones de validaciones
    @Bean
    public MessageSource messageSource() 
    {
        //objeti para ubicar el archivo .property
        ReloadableResourceBundleMessageSource messageSource=
                new ReloadableResourceBundleMessageSource();
        
        //ruta donde está el archivo ValidateMsg.property
        messageSource.setBasename("/WEB-INF/messages/ValidateMsg");
        
        //para usar caracteres en el idioma latino
        messageSource.setDefaultEncoding("UTF-8");
        
        return messageSource;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) 
    {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }
}
