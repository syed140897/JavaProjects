package PrototypeMethod;

import FactoryMethod.Doctor;
import FactoryMethod.Engineer;
import FactoryMethod.Profession;
import FactoryMethod.Teacher;

public class ClientProtohecker {

	public static void main(String[] args) {
		
		PrototypeCreation prototypeCreation=new PrototypeCreation();
		prototypeCreation.objectLoad();
		
		Profession professionT=new Teacher();
		System.out.println(professionT);
		
		Profession professionD=new Doctor();
		System.out.println(professionD);
		
		Profession professionT2=new Teacher();
		System.out.println(professionT2);
		
		Profession professionE=new Engineer();
		System.out.println(professionE);
	}
}
