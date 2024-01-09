package AbstractFactory;

public class ClientAbstractFactory {
	
	public static void main(String arg[]) {
		
		SiteConfirmation siteConfirmation=new SiteConfirmation(true);
		siteConfirmation.getProfessionsite("teacher");
		
		SiteConfirmation siteConfirmation2=new SiteConfirmation(false);
		siteConfirmation2.getProfessionsite("teacher");
	}

}
