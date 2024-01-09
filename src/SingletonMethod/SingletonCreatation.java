package SingletonMethod;

public class SingletonCreatation {
	
	private static SingletonCreatation singletonCreatation=new SingletonCreatation();
	
	private SingletonCreatation() {
		
	}

	public static SingletonCreatation getInstance() {		
		 return singletonCreatation;
	}
	
}
