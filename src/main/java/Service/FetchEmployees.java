package Service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import Entity.EmployeeDetail;

public class FetchEmployees {

	public static void main(String[] args) {
         
         Configuration configuration=new Configuration().configure().addAnnotatedClass(EmployeeDetail.class);
         ServiceRegistry serviceregistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
         SessionFactory seesionfactory=configuration.buildSessionFactory(serviceregistry);
         Session session=seesionfactory.openSession();
         Transaction ts=session.beginTransaction();
         
        Query<EmployeeDetail> query=session.createQuery("from EmployeeDetail",EmployeeDetail.class);
        List<EmployeeDetail> list= query.getResultList();
        
        for(EmployeeDetail employee:list) {
        	System.out.println(employee.toString());
        }
        
        ts.commit();
        session.close();
	}

}
