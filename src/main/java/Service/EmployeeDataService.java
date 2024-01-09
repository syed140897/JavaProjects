package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Entity.EmployeeDetail;

public class EmployeeDataService {

	public static void main(String[] args) {
		
		EmployeeDetail emp=new EmployeeDetail();
		emp.setName("Ravi");
		emp.setRole("USER");
		emp.setId(2);
	
        Configuration config=new Configuration().configure().addAnnotatedClass(EmployeeDetail.class);
        ServiceRegistry service=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionfactory=config.buildSessionFactory(service);
		Session session=sessionfactory.openSession();
		Transaction trans=session.beginTransaction();
		
		session.persist(emp);
		
		trans.commit();
		session.close();
	}
} 
