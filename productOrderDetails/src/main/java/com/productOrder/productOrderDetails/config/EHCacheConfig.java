package com.productOrder.productOrderDetails.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * Configuration class for cache
 * @author 787089
 *
 */
@EnableCaching
@Configuration
public class EHCacheConfig {
	 @Bean
	    public EhCacheCacheManager cacheManager(){
	        return new EhCacheCacheManager(ehCacheManagerFactory().getObject());
	    }

	    @Bean
	    public EhCacheManagerFactoryBean ehCacheManagerFactory(){
	        EhCacheManagerFactoryBean ehCacheBean = new EhCacheManagerFactoryBean();
	        ehCacheBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
	        ehCacheBean.setShared(true);
	        return ehCacheBean;
	    }
}
