package by.mitskevich.servicestation.entity;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class HibRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Role.class);
        configuration.addAnnotatedClass(User.class);

        Role role = new Role();
        role.setName("super_admin");

        User user = User.builder()
                .firstName("John")
                .lastName("Test")
                .email("test@gmail.com")
                .password("qwer122")
                .login("log").build();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory()) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
//            session.save(role);
//            user.setRole(role);
//            session.save(user);
//            User fetchedUser = session.find(User.class, 1L);

//            session.delete(fetchedUser);

            Query hqlQuery = session.createQuery("FROM User");
            hqlQuery.list().forEach(System.out::println);
            session.getTransaction().commit();
            sessionFactory.getCurrentSession().close();

        }
    }
}
