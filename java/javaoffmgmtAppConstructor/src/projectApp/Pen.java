package projectApp;

import java.util.Random;

public class Pen 
{
	private double size;
	private double price;
	private String color;
	
	private static String brandName;
	
	static
	{
		brandName="reynolds";
	}
//	Initialization Block
	{
		
	}
	
	public Pen()
	{
		System.out.println("default constructor called...!!!");
		
		this.size=3.56;
		this.price=50.35;
		this.color="blue";
//		this.brand="parker";
	}
	public Pen(double size,double price,String color)
	{
		System.out.println("parameterized constructor called...!!! ");
		
		this.size=size;
		this.price=price;
		this.color=color;
//		this.brand=brand;
	}
	
	public Pen(Pen p)
	{
		System.out.println("copy ctor called !!!");
		this.size= p.size;
		this.price= p.price;
		this.color= p.color;
//		this.brand= p.brand;
	}
	
	public void setPenInfo(double size,double price,String color)
	{
		this.size=size;
		this.price=price;
		this.color=color;
//		this.brand=brand;
	}
	public  String getPenInfo()
	{
		return "pen info="+this.size+" "+this.price+" "+this.color+" "+brandName;
	}
	public  static String GetbrandName()
	{
		return brandName;
	}
	public static void SetbrandName(String bn)
	{
		brandName=bn;
	}
}
