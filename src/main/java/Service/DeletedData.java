package Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Entity.EmployeeDetail;

public class DeletedData {

	public static void main(String[] args) {
		Configuration config=new Configuration().configure().addAnnotatedClass(EmployeeDetail.class);
		ServiceRegistry serviceregistry=new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory seesionfactory=config.buildSessionFactory(serviceregistry);
        Session session=seesionfactory.openSession();
        Transaction tx=session.beginTransaction();
        EmployeeDetail emp=session.find(EmployeeDetail.class, 2);
        
        session.remove(emp);
        
        tx.commit();
        session.close();
	}

}
