/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.config;

import com.jolbox.bonecp.BoneCPDataSource;
import java.util.Properties;
import javax.annotation.Resource;
import javax.persistence.SharedCacheMode;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Alejandro
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "co.edu.uelbosque",
})
@EnableJpaRepositories("co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.repositories")
@PropertySource(value = {"classpath:config/postgresVagrant.properties"})
public class HistoriClinicaConfig {
    
    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() {
        BoneCPDataSource ds = new BoneCPDataSource();
        
        ds.setDriverClass(env.getRequiredProperty("db.driver"));
        ds.setJdbcUrl(env.getRequiredProperty("db.url"));
        ds.setUsername(env.getRequiredProperty("db.username"));
        ds.setPassword(env.getRequiredProperty("db.password"));
        return ds;
    }
    
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        em.setDataSource(dataSource());
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setPackagesToScan(env.getRequiredProperty("entitymanager.packages.to.scan"));

        Properties p = new Properties();
        p.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        p.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));
        p.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        p.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
        p.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        p.put("hibernate.cache.use_query_cache", env.getRequiredProperty("hibernate.cache.use_query_cache"));
        p.put("hibernate.cache.region.factory_class", env.getRequiredProperty("hibernate.cache.region.factory_class"));        
        p.put("hibernate.temp.use_jdbc_metadata_defaults",env.getRequiredProperty("hibernate.temp.use_jdbc_metadata_defaults"));
        p.put("hibernate.generate_statistics", "true");
        p.put("hibernate.default_schema",env.getRequiredProperty("hibernate.default_schema"));
        em.setJpaProperties(p);
        em.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
        return em;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }
    
    @Bean(name = "sendmail")
    public JavaMailSender mailSender(){
       
        Properties javamailprop=new Properties();
        javamailprop.put("mail.smtp.auth","true");
        javamailprop.put("mail.smtp.starttls.enable","true");
        
        JavaMailSenderImpl jmsi=new JavaMailSenderImpl();
        jmsi.setJavaMailProperties(javamailprop);
        jmsi.setHost("gmail");
        jmsi.setPort(587);
        jmsi.setUsername("xxxx");
        jmsi.setPassword("xxxxx");
        return jmsi;
    }
    
    
}
