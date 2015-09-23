package org.varvaras.dimitris;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;


public class ReadSource implements Serializable{
	public int[][] seatsArray=new int[72][2];
	public ReadSource()
	{																	
		 try 
		 {
           FileReader file = new FileReader("seatsFile");
           BufferedReader buff = new BufferedReader(file);
           for (int i=0;i<72;i++)
           {
           	char[] xCoordinates=new char[3];
           	char[] yCoordinates=new char[3];
               String line =buff.readLine();
               int xInteger=0;
               int yInteger=0;
               String xString="nothing";
               String yString="nothing";
               xCoordinates[0]=line.charAt(9);
               xCoordinates[1]=line.charAt(10);
               xCoordinates[2]=line.charAt(11);
               yCoordinates[0]=line.charAt(13);
               yCoordinates[1]=line.charAt(14);
               yCoordinates[2]=line.charAt(15);
				yString=new String(yCoordinates);
               xString=new String(xCoordinates);
               yInteger=Integer.parseInt(yString);
               xInteger=Integer.parseInt(xString);
               seatsArray[i][0]=xInteger;
               seatsArray[i][1]=yInteger;         	
           }
           buff.close();
       }
       catch (IOException e) 
       {
           System.out.println("Error -- " + e.toString());
       }
       
   }
}