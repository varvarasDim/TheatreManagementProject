package org.varvaras.dimitris;

import java.io.Serializable;

public class Reservation implements Serializable
{
	private String name;
	private String surname;
	private String category;
	private boolean status;
	private int x;
	private int y;															
	
	public Reservation(int x,int y)
	{
		this.x=x;
		this.y=y;
		this.surname="";
		this.category="";
		this.name="";
		this.status=false;
	}
	public Reservation(String name,String epwn,String kat,int x,int y)
	{
		this.x=x;
		this.y=y;
		this.surname=epwn;
		this.category=kat;
		this.name=name;
		this.status=true;
	}
	int getThisX()
	{
		return x;
	}
	int getThisY()
	{
		return y;
	}
	public String getName()
	{
		return name;
	}
	public String getSurname()
	{
		return surname;
	}
	public String getCategory()
	{
		return category;
	}
	public boolean getStatus()
	{
		return status;
	}
	public void setStatusToTrue()
	{
		this.status=true;
	}
	public void setStatusToFalse()
	{
		this.status=false;
		this.surname="";
		this.category="";
		this.name="";

	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setSurname(String epwn)
	{
		this.surname=epwn;
	}
	public void setCategory(String kat)
	{
		this.category=kat;
	}

	
}