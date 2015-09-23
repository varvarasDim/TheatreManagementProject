package org.varvaras.dimitris;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ReservationTaken extends JFrame implements ActionListener
{
	private JPanel panel=new JPanel();
	private Play play;
	private int position=-1;
	private JTextField name;
	private JTextField surname;
	private JTextField category;															
	private JLabel nameLabel=new JLabel("Name");
	private JLabel surnameLabel=new JLabel("Surname");
	private JLabel categoryLabel=new JLabel("Category");
	private Play[] plays=new Play[10];
	private Reservation reservation;
	private JButton deleteButton=new JButton("Delete");
	private JButton okButton=new JButton("Ok");
	
	public ReservationTaken(Play par,int k)
	{
        super("Seat is taken");
		setResizable(false);
        setLocation(400,400);

        play=par;
		reservation=play.getOneReservation(k);
		name=new JTextField(reservation.getName());
		surname=new JTextField(reservation.getSurname());
		category=new JTextField(reservation.getCategory());
		name.setEditable(false);
		surname.setEditable(false);
		category.setEditable(false);
		
        
        position=k;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4,2));
        deleteButton.addActionListener(this);
        okButton.addActionListener(this);
        panel.add(nameLabel);panel.add(name);
        panel.add(surnameLabel);panel.add(surname);
        panel.add(categoryLabel);panel.add(category);
        panel.add(okButton); panel.add(deleteButton);
        setContentPane(panel);
        pack();
        setVisible(true);

        
    }

	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource()==okButton)
		{
			setVisible(false);
        	BlueprintTheatre sx_th_can=new BlueprintTheatre(play);
		}
		if (evt.getSource()==deleteButton)
		{
			setVisible(false);
			Play.deleteReservation(play,position);
			plays=Play.loadPlays();									
			for (int k=0;k<10;k++)
			{
				if (plays[k]!=null)
				if ((plays[k].getName()).equals(play.getName()))
					play=plays[k];
			}
			BlueprintTheatre sx_the_diag=new BlueprintTheatre(play);
		}

	} 
}