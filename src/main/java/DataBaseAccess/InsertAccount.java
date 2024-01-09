package DataBaseAccess;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Entity.Account;

public class InsertAccount {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Account Name");
		String namString=scanner.next();
		System.out.println("Enter Account Number");
		String numString=scanner.next();
		System.out.println("Enter Account Balance");
		Double balanceDouble=scanner.nextDouble();
		
		scanner.close();
		
	    Account account=new Account();
	    account.setAccount_Name(namString);
	    account.setAccount_Number(numString);
	    account.setAccount_Balance(balanceDouble);
	    
	    Configuration configuration=new Configuration().configure().addAnnotatedClass(Account.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				                        .build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.persist(account);
		
		transaction.commit();
		session.close();
	    
	}
}
