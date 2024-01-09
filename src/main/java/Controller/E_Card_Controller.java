package Controller;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import Service.AccountFind;
import Service.ProductFind;

public class E_Card_Controller {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Product Name");
		String productName=scanner.next();
		ProductFind productservice=new ProductFind();
		AccountFind accountservice=new AccountFind();
		
		 CompletableFuture.supplyAsync(()-> productservice.findProduct(productName))
				            .thenApply(product -> accountservice.paymentProcess(product,scanner)).thenAccept((result)-> {
				            	if(result) {
				            		System.out.println("Process Done");
				            	}else {
				            		System.out.println("Thank You");
				            	}
				            }).get();
		
	}
}
