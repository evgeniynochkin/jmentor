package task.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

//@Configuration
//@ComponentScan(basePackages = ("task"))
//@EnableTransactionManagement
//@PropertySource("classpath:db.properties")
//public class HibernateConfig {
//
//    private Environment environment;
//
//    @Autowired
//    public void setEnvironment(Environment environment) {
//        this.environment = environment;
//    }
//
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//        LocalContainerEntityManagerFactoryBean lCEM = new LocalContainerEntityManagerFactoryBean();
//        lCEM.setDataSource(dataSource());
//        lCEM.setPackagesToScan("task.model");
//        JpaVendorAdapter jva = new HibernateJpaVendorAdapter();
//        lCEM.setJpaVendorAdapter(jva);
//        lCEM.setJpaProperties(hibiranateProperties());
//        return lCEM;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
//        return transactionManager;
//    }
//
//    private Properties hibiranateProperties() {
//        Properties properties = new Properties();
//        properties.put("hibertate.dialect", environment.getRequiredProperty("hib.dialect"));
//        properties.put("hibernate.show_sql", environment.getRequiredProperty("hib.show_sql"));
//        properties.put("hibernate.hbm2dll_auto", environment.getRequiredProperty("hib.hbm2dllauto"));
//        return properties;
//    }
//
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//
//        dataSource.setDriverClassName(environment.getRequiredProperty("db.driver"));
//        dataSource.setUrl(environment.getRequiredProperty("db.url"));
//        dataSource.setUsername(environment.getRequiredProperty("db.user"));
//        dataSource.setPassword(environment.getRequiredProperty("db.password"));
//
//        return dataSource;
//    }
//}
