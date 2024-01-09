package Service;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import Entity.Account;
import Entity.Product;

public class E_Card_Order_Result {
	
	private static Boolean accountDebit(Double productPrice,Account account) {
		Double accountBalance=(account.getAccount_Balance()-productPrice);
		
		Configuration configuration=new Configuration().configure().addAnnotatedClass(Account.class);
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
				                        .build();
		SessionFactory sessionFactory=configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		Account account2= session.find(Account.class,account.getAccount_Number());
        account2.setAccount_Balance(accountBalance);
        session.persist(account2);
		transaction.commit();
		session.close();
		return true;
	}
	
	

	public String orderResult(Optional<Product> product, Optional<Account> account) {
		String resultString="";
          Product product2=product.get();
          Account account2=account.get();
          System.out.println(" Result Class" +product2.toString());
          if(product2.getProduct_Price()<account2.getAccount_Balance()) {
            Boolean responce= accountDebit(product2.getProduct_Price(), account2);
            if(responce) {
        	resultString="Your Order is SuccessFully Placed";
            }else {
            	resultString="Something Wrong Try Again";
            }
          }else {
        	  resultString="Insuffiend Balance";
          }
          
          return resultString;
	}

}
