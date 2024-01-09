package FactoryMethod;


public class FectorySIte {
	
	public void getProfession(String profession) {
		
		if(profession.equals(null)) {
			System.out.println("profession type is not present");
		}
		else if(profession.equalsIgnoreCase("doctor")) {
			Profession profession2=new Doctor();
			profession2.printwork();
		}else if(profession.equalsIgnoreCase("Engineer")) {
			Profession profession2=new Engineer();
			profession2.printwork();
		}
		else if(profession.equalsIgnoreCase("Teacher")) {
			Profession profession2=new Teacher();
			profession2.printwork();
		}
	}

}
