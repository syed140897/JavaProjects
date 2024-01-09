package Service;


import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import Entity.Account;
import Entity.Product;

public class E_Card_Order_Process {
	
	public static Optional<Product> productSearch(String findName){
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Product.class)
				                    .addAnnotatedClass(Account.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				                    .build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
	    
		Query<?> query=session.createQuery("from Product where productName ="+"'"+findName+"'",Product.class);
	    		
	    Optional<Product> product=Optional.ofNullable((Product)query.getSingleResult());
	    
	    transaction.commit(); 
	    session.close();
		return product;
	}
	
    public static Optional<Account> accountSearch(String findName){
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Product.class)
				                    .addAnnotatedClass(Account.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				                    .build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
	  
		Query<?> query=session.createQuery("from Account where accountNumber ="+"'"+findName+"'",Account.class);
	    		
	    Optional<Account> account=Optional.ofNullable((Account)query.getSingleResult());
	    
	    transaction.commit(); 
	    session.close();
		return account;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
      
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product Name");
		String productName=scanner.next();
        System.out.println("Enter Account Number");
		String accountNumber=scanner.next();
	 
        Optional<Product> product=productSearch(productName);
        Optional<Account> account=accountSearch(accountNumber);
        
        if(product.isPresent()&&account.isPresent()) {
        	E_Card_Order_Result result=new E_Card_Order_Result();
        	String resultOrder= result.orderResult(product,account);
        	System.out.println(resultOrder);
        }
       
        
        
		scanner.close();
	}
}
