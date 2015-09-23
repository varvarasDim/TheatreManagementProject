package org.varvaras.dimitris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BlueprintTheatre extends JFrame implements ActionListener,MouseListener
{
	private Play play;
	private int position=-1;
    private Reservation[] reservations=new Reservation[72];
	private JPanel panel=new JPanel();															
	private JButton buttonOk=new JButton("Ok");
	private ReadSource readfile=new ReadSource();
	private MyCanvas canvas;
	
	public BlueprintTheatre(Play par)
	{
        super("Theatre Plan");
		setResizable(false);
        setLocation(200,200);

		play=par;
		reservations=par.getReservations();

        setSize(550,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas=new MyCanvas(par);
        canvas.addMouseListener(this);
        panel.add(canvas);
        buttonOk.addActionListener(this);
        panel.add(buttonOk);
        
        setContentPane(panel);
        setVisible(true);

	}
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource()==buttonOk)
		{
			setVisible(false);
			TheatreManagement ap_epi_ok_sxh_ok=new TheatreManagement();
		}																				
	}
    public void mouseClicked(MouseEvent evt)
    {
    	for (int i=0;i<72;i++)
    	{
    		if ( Math.pow((evt.getX()-20-readfile.seatsArray[i][0]),2) + Math.pow((evt.getY()-20-readfile.seatsArray[i][1]),2) <= Math.pow(20,2) )
    		{
    			position=i;
	    		if (reservations[i].getStatus()==false)
	    		{
	    			setVisible(false);
	    			InsertReservationWindow kep_kanvas=new InsertReservationWindow(play,i);
	    		}
	    		else
	    		{
					setVisible(false);
	    		 	ReservationTaken kp=new ReservationTaken(play,i);
	    		}
    		}
    	}
       
    }
    public void mouseReleased(MouseEvent evt) {}
    public void mousePressed(MouseEvent evt) {}
    public void mouseExited(MouseEvent evt) {}
    public void mouseEntered(MouseEvent evt) 
    {    }
}