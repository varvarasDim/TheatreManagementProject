package org.varvaras.dimitris;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Play implements Serializable
{

	private String id;
	private String name;
	private String date;													
	private String time;
	private String balconyPrice;
	private String firstSquarePrice;
	private String secondSquarePrice; 
	public Reservation[] reservations=new Reservation[72];
	
	public Reservation getOneReservation(int i)
	{
		return reservations[i];
	}
	public Reservation[] getReservations()
	{
		return reservations;
	}
	public String getName()
	{
		return name;
	}
	public String getId()
	{
		return id;
	}
	public String getDate()
	{
		return date;
	}
	public String getTime()
	{
		return time;
	}
	public String getTimhEx()
	{
		return balconyPrice;
	}
	public String getTimhAp()
	{
		return firstSquarePrice;
	}
	public String getTimhBp()
	{
		return secondSquarePrice;
	}
	Play(String id,String name,String date, String time,String bp,String as,String bs)
	{
		ReadSource readfile=new ReadSource();
		for (int k=0;k<72;k++)
			{
				this.reservations[k]=new Reservation(readfile.seatsArray[k][0],readfile.seatsArray[k][1]);
			}
		this.id=id;
		this.name=name;
		this.date=date;
		this.time=time;
		this.balconyPrice=bp;
		this.firstSquarePrice=as;
		this.secondSquarePrice=bs;
	}
	static void savePlays(Play[] paras)
	{
			try
			{
				FileOutputStream fos=new FileOutputStream("plays.obj");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(paras);
				oos.close();
			}																	
			catch (IOException e)
			{
				System.out.println("Error "+e.toString());
			}	
	}	
	static void deleteReservation(Play par,int kr)
	{
		Play[] playsArray=new Play[10];
		Play play=null;
		Reservation reservation;
		int thes=-1;
		Reservation[] reservations=new Reservation[72];
		playsArray=Play.loadPlays();
		for (int k=0;k<10;k++)
		{
			if (playsArray[k]!=null)
			if (	(playsArray[k].getName()).equals(par.getName())	)
			{
				thes=k;
				play=playsArray[k];										//ÄÉÁÃÑÁÖÇ ÐÁÑÁÓÔÁÓÇÓ
				reservations=playsArray[k].getReservations();
				break;
			}		
		}
		reservation=reservations[kr];
		reservation.setName("");
		reservation.setSurname("");
		reservation.setStatusToFalse();
		reservation.setCategory("");
		play.reservations[kr]=reservation;
		playsArray[thes]=play;
		Play.savePlays(playsArray);
		
		
		
		
	}
	static void saveReservation(Play par,int kr,String nm,String ep,String ka)
	{
		Play[] playsArray=new Play[10];
		Play play=null;
		Reservation reservation;
		int position=-1;
		Reservation[] reservations=new Reservation[72];
		playsArray=Play.loadPlays();
		for (int k=0;k<10;k++)
		{																
			if (playsArray[k]!=null)
			if (	(playsArray[k].getName()).equals(par.getName())	)
			{
				position=k;
				play=playsArray[k];
				reservations=playsArray[k].getReservations();
			}		
		}
		boolean nameExists=false;
		boolean surnameExists=false;
		for (int l=0;l<72;l++)
		{
			if (reservations[l]!=null)
			if ((reservations[l].getName()).equals(nm))
			{
				nameExists=true;
				if ((reservations[l].getSurname()).equals(ep))
					surnameExists=true;	
			}	
		}
		
		if (	!((nameExists)&&(surnameExists))	)
		{
			reservation=reservations[kr];
			reservation.setName(nm);
			reservation.setSurname(ep);
			reservation.setStatusToTrue();
			reservation.setCategory(ka);
			play.reservations[kr]=reservation;
			playsArray[position]=play;
			Play.savePlays(playsArray);
		}
	}

	static Play[] loadPlays()
	{
		Play[] pap=new Play[10];
		try
		{
			FileInputStream fis=new FileInputStream("plays.obj");
			ObjectInputStream ois=new ObjectInputStream(fis);
			pap=(Play[])ois.readObject();
			ois.close();
		}
		catch (Exception e)														
		{
			System.out.println("Error "+e.toString());
		}
	return pap;
		
	}
	static void initialization()
	{
		File file=new File("plays.obj");
		if (file.exists())
		{
			return;
		}
		else																	
		{
			Play[] par=new Play[10];
			try
			{
				FileOutputStream fos=new FileOutputStream("plays.obj");
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				oos.writeObject(par);
				oos.close();
			}
			catch (IOException e)
			{
				System.out.println("Error "+ e.toString());
			}
		}
	}
}