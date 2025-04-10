package iti.Misk.utils;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class EntityManagerFactorySingleton {

    private static volatile EntityManagerFactory entityManagerFactory;


   private EntityManagerFactorySingleton() {}

    public static EntityManagerFactory getEntityManagerFactory() {

       if(entityManagerFactory == null) {
            synchronized (EntityManagerFactorySingleton.class) {
                if (entityManagerFactory == null) {


                    entityManagerFactory = Persistence.createEntityManagerFactory("main");
                }
            }
        }
        return entityManagerFactory;
    }


    public static void close() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
