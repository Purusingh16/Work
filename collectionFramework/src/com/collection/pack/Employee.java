package com.collection.pack;
import java.util.*;
public class Employee {
	int id;
	String name;
	float basic;
	Set skillset;
	
	Employee(int id,String name,float basic,String...skills)
	{
		this.id=id;
		this.name=name;
		this.basic=basic;
		skillset=new HashSet();
		for(int i=0;i<skills.length;i++)
		{
			skillset.add(skills[i]);
		}
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", basic=" + basic + ", skillset=" + skillset + "]";
	}
	
	

}
