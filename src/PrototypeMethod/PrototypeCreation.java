package PrototypeMethod;

import java.util.Hashtable;

import FactoryMethod.Doctor;
import FactoryMethod.Engineer;
import FactoryMethod.Profession;
import FactoryMethod.Teacher;

public class PrototypeCreation {

	private static Hashtable<Integer, Profession> storeHashtable=new Hashtable<Integer, Profession>();
	
	public Profession getInstance(Integer id) {
		Profession profession=storeHashtable.get(id);
		return profession;
	}
	
	public void objectLoad() {
		Profession professionT=new Teacher();
		storeHashtable.put(1, professionT);
		
		Profession professionD=new Doctor();
		storeHashtable.put(2, professionD);
		
		Profession professionE=new Engineer();
		storeHashtable.put(3, professionE);
	}
}
