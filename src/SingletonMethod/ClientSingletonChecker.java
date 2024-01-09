package SingletonMethod;

public class ClientSingletonChecker {

	public static void main(String[] args) {
		
		SingletonCreatation singletonCreatation=SingletonCreatation.getInstance();
		SingletonCreatation singletonCreatation2=SingletonCreatation.getInstance();

		System.out.println(singletonCreatation);
		System.out.println(singletonCreatation2);

	}
	
}
