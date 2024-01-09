package Service;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import Entity.Product;

public class ProductFind {

	public Optional<Product> findProduct(String productName) {
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Product.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				                         .build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Query<?> query=session.createQuery("from Product where product_Name="+"'"+productName+"'",Product.class);
		Optional<Product> product=Optional.ofNullable((Product)query.getSingleResult());
		transaction.commit();
		session.close();
		return product;
	}

}
