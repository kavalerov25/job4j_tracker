package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;
import java.util.List;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            /* working with session */
            Query query = session.createQuery("from ru.job4j.Item", Item.class);
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

}