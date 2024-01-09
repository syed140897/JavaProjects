package AbstractFactory;

import FactoryMethod.FectorySIte;

public class SiteConfirmation {
	
	boolean profession;
	
	public SiteConfirmation(boolean b) {
	      profession=b;	
	}
	
	public void getProfessionsite(String pro) {
		if(profession==true) {
			FectorySIte site=new FectorySIte();
			site.getProfession(pro);
		}else {
			FactoryTrainerSite fSite=new FactoryTrainerSite();
			fSite.getProfession(pro);
		}
	}

}
