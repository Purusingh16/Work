package project1;

class Student extends Person 
{
	 private double fees;
	 private int rollno;
	 
public Student(String name,int age,double fees,int rollno)
{
	super(name, age);
	this.fees=fees;
	this.rollno=rollno;
}
@Override
public String getpersonInfo()
{
	return super.getpersonInfo()+" "+this.fees+" "+this.rollno;
}
	 

}