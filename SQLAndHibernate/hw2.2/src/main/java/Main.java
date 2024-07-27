import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> courseName2Id = new LinkedHashMap<>();
        Map<String, Integer> studentName2Id = new LinkedHashMap<>();
        List<LinkedPurchaseList> linkedPurchaseList = new ArrayList<>();
        StandardServiceRegistry registery = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registery).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
        String courses = "From " + Course.class.getSimpleName();
        List<Course> courseList = session.createQuery(courses).getResultList();

        String students = "From " + Students.class.getSimpleName();
        List<Students> studentList = session.createQuery(students).getResultList();

        String purchases = "From " + PurchaseList.class.getSimpleName();
        List<PurchaseList> purchaselist = session.createQuery(purchases).getResultList();

        courseList.forEach(c -> courseName2Id.putIfAbsent(c.getName(), c.getId()));
        studentList.forEach(s -> studentName2Id.putIfAbsent(s.getName(), s.getId()));

        for (PurchaseList p : purchaselist) {
            String course = p.getCourseName();
            String student = p.getStudentName();
            int courseId = courseName2Id.get(course);
            int studentId = studentName2Id.get(student);
            LinkedPurchaseList lpl=new LinkedPurchaseList(new LinkedPurchaseKey(studentId, courseId));
            session.persist(lpl);
        }
        transaction.commit();

    } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}
