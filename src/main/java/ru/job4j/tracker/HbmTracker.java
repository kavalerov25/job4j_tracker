package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public void init() {

    }

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.
                createQuery("update Item as i set i.name = :fName,"
                            + " i.created = :fCreated where i.id = :fId")
                .setParameter("fName", item.getName())
                .setParameter("fCreated", item.getCreated())
                .setParameter("fId", id);
        boolean result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Item i where i.id = :fId")
                .setParameter("fId", id);
        boolean result = query.executeUpdate() > 0;
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery("from Item").list();
        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        session.beginTransaction();
        List<Item> result = session.createQuery("from Item i where i.name = :fName")
                .setParameter("fName", key).list();
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Query query = session.createQuery("from Item i where i.id = :fId")
                .setParameter("fId", id);
        Item result = (Item) query.uniqueResult();
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}