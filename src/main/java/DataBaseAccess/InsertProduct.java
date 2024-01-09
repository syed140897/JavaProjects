package DataBaseAccess;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Entity.Product;

public class InsertProduct {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product Id");
		Integer idInteger=scanner.nextInt();
		System.out.println("Enter Product Name");
		String nameString=scanner.next();
		System.out.println("Enter Product Price");
		Double priceDouble=scanner.nextDouble();
		
		Product product=new Product();
		product.setProduct_Id(idInteger);
		product.setProduct_Name(nameString);
		product.setProduct_Price(priceDouble);
		
		scanner.close();
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Product.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				                        .build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.persist(product);
		
		transaction.commit();
		session.close();

	}

}
