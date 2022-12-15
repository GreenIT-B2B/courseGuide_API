package com.itsone.igm.config;


import java.util.Locale;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import com.itsone.igm.utility.MessageUtil;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@Configuration
@MapperScan(basePackages = "com.itsone.igm.dao")
public class MyBatisConfig implements WebMvcConfigurer {

    @Bean
    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.itsone.igm.vo"); 
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
        sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));

        return sqlSessionFactory.getObject();
    }
    
    @Bean
    public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Bean
    public FilterRegistrationBean sitemeshFilter(){
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setName("sitemesh");
        filter.setFilter(new SiteMeshFilter());
        filter.addInitParameter("decorators-file", "/WEB-INF/decorators.xml");
        filter.addInitParameter("contextConfigLocation", "classpath:/WEB-INF/sitemesh.xml");
        
        return filter;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
    	LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor(); 
       	localeChangeInterceptor.setParamName("lang");
   
    	return localeChangeInterceptor;
    }
    
    @Bean(name = "localeResolver")
    public LocaleResolver sessionLocaleResolver(){
        SessionLocaleResolver localeResolver=new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**")
    			.allowedOrigins("http://localhost:3000")
    			.allowedMethods("GET", "POST");
    }
}
