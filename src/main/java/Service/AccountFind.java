package Service;

import java.util.Optional;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import Entity.Account;
import Entity.OrderPlacedList;
import Entity.Product;

public class AccountFind {

	private static Optional<Account> accountFindAccount(String findAccount) {
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Product.class)
                .addAnnotatedClass(Account.class);
        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Query<?> query=session.createQuery("from Account where account_Number ="+"'"+findAccount+"'",Account.class);

        Optional<Account> account=Optional.ofNullable((Account)query.getSingleResult());

        transaction.commit(); 
        session.close();
        return account;
		
	}

	public Boolean paymentProcess(Optional<Product> product,Scanner scanner) {
		Boolean result=false;
		Product product2=product.get();
		System.out.println("Your Product Price is "+product2.getProduct_Price());
		System.out.println("If You Buy This Product Enter Account Number or Exit (Reload Product Search)");
        System.out.println("1.Enter Your Account Number");
        System.out.println("2.Exit");
       
		switch(scanner.nextInt()) {
		                 case 1:System.out.println("1.Enter Account Number");
		                	    String accountNumber=scanner.next();
		                	    Account account=accountFindAccount(accountNumber).get();
		                        if(account.getAccount_Balance()>product2.getProduct_Price()) {
		                        	accountDebitConfirmation(account,product2,scanner);
		                        	result=true;
		                        }else {
		                        	System.out.println("Insuffiend Balance");
		                        	result=false;
		                        }
		                        
		                        break;
		                 case 2:System.out.println("Thank You");
		                         break;
		                 default:
		                	     System.out.println("Your Entry Wrong Bye....");
		}  
		scanner.close();
		return result;
		
	}

	private Boolean accountDebitConfirmation(Account account, Product product2,Scanner scanner) {
    Boolean result=false;	
	Double accountBalance=(account.getAccount_Balance()-product2.getProduct_Price());
	System.out.println("Confirm Your Payment : Your produc Price is ="+product2.getProduct_Price());
	System.out.println("Your Account Balance now="+account.getAccount_Balance());
	System.out.println("After Order Placed Your Account Balance"+accountBalance);
	System.out.println("You Agree Payment Process Enter YES or Cancel Order Enter NO");
	String confirm=scanner.next();
		if(confirm.equals("YES")) {
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Account.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				                        .build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Account account2= session.find(Account.class,account.getAccount_Number());
        account2.setAccount_Balance(accountBalance);
        session.persist(account2);
        OrderPlacedList(account,product2,true);
		transaction.commit();
		session.close();
		result=true;
		}else if(confirm.equals("NO")){
		    OrderPlacedList(account,product2,false);
			System.out.println("Cancel Order");
			result=false;
		}
		return result;
		
	}

	private void OrderPlacedList(Account account, Product product2,Boolean process) {
		String orderStatus="Failed";
		Configuration configuration=new Configuration().configure().addAnnotatedClass(OrderPlacedList.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				                         .build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		if(process.equals(true)) {
			 orderStatus="Success";
		}
		OrderPlacedList orderPlacedList=new OrderPlacedList();
		orderPlacedList.setProduct_Name(product2.getProduct_Name());
		orderPlacedList.setAccount_Number(account.getAccount_Number());
		orderPlacedList.setOrder_Place(orderStatus);
		
		session.persist(orderPlacedList);
		transaction.commit();
		session.close();
				
		
	}

	
}
