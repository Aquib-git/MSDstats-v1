package com.kng.medicalreports.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;

//@Configuration
//@EnableCaching
public class CacheHandler 
{
//	 @Bean
//	 public CacheManager cacheManager() 
//	 {
//		 System.out.println("Caching initiated");
//		 CaffeineCacheManager cacheManager = new CaffeineCacheManager();
//		 cacheManager.setCaffeine(Caffeine.newBuilder()
//	             .maximumSize(6000)
//	             .expireAfterAccess(20, TimeUnit.MINUTES)
//	             .removalListener(new RemovalListener<Object, Object>() {
//	                    @Override
//	                    public void onRemoval(@Nullable Object key, @Nullable Object value, @NonNull RemovalCause cause) {
//	                        System.out.println("Cache entry removed: " + key);
//	                    }
//	                })
//	             );
//		 System.out.println("Caching started");
//	     return cacheManager;
//	 }

}
