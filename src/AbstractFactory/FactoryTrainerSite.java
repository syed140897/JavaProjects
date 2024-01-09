package AbstractFactory;

import FactoryMethod.Profession;

public class FactoryTrainerSite {
	
	public void getProfession(String profession) {
           
		if(profession.equals(null)) {
			System.out.println("profession type is not present");
		}
		else if(profession.equalsIgnoreCase("doctor")) {
			Profession profession2=new DoctorTraining();
			profession2.printwork();
		}else if(profession.equalsIgnoreCase("Engineer")) {
			Profession profession2=new EngineerTraining();
			profession2.printwork();
		}
		else if(profession.equalsIgnoreCase("Teacher")) {
			Profession profession2=new TeacherTraining();
			profession2.printwork();
		}

	}
}


