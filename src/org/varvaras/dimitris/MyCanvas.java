package org.varvaras.dimitris;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyCanvas extends Canvas
{
	private Reservation reservation=null;
	private Play play;															
	private int position=-1;
    private Reservation[] reservations=new Reservation[72];
    private Ellipse2D.Float[] e2f=new Ellipse2D.Float[72];
    private Graphics2D g2D;
    
	public MyCanvas(Play par)
	{
		play=par;
		reservations=par.getReservations();
		setSize(520,520);
		for (int l=0;l<72;l++)
		{
			e2f[l]=new Ellipse2D.Float(reservations[l].getThisX(),reservations[l].getThisY(),40,40);
		}
	}
	public void paint(Graphics g)
	{
		g2D=(Graphics2D)g;
		for (int k=0;k<72;k++)
			{
				if (	(	reservations[k].getStatus()	)	)
				{
					g2D.setColor(Color.red);
				}
				else
				{
					g2D.setColor(Color.white);
				}
				g2D.fill(e2f[k]);
			}
	}
}