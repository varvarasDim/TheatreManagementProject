package org.varvaras.dimitris;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertReservationWindow extends JFrame implements ActionListener
{
	private JButton buttonOk=new JButton("ok");
	private JButton buttonCancel=new JButton("Cancel");
	private JTextField name=new JTextField(20);												
	private JTextField surname=new JTextField(20);
    //private JTextField playTextField=new JTextField(20);

	private JLabel nameLabel=new JLabel("Name");
	private JLabel surnameLabel=new JLabel("Surname");
	private Play play;
	private Play[] plays=new Play[10];
	private int position;
	private JLabel playLabel=new JLabel("Play");
	private JLabel categoryLabel=new JLabel("Category");
	private JComboBox combo=new JComboBox();
	private JPanel panel=new JPanel();
   

    public InsertReservationWindow(Play par,int krat) 
    {
        super("Insert Reservation");
		setResizable(false);
        setLocation(400,400);

    	combo.addItem("Student");
    	combo.addItem("Member");
    	combo.addItem("Child");
    	combo.setEditable(false);
        play=par;
        position=krat;
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(4,2));
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
        panel.add(nameLabel);panel.add(name);
        panel.add(surnameLabel);panel.add(surname);
        panel.add(categoryLabel);panel.add(combo);
        panel.add(buttonOk);panel.add(buttonCancel);
        setContentPane(panel);
        pack();
        setVisible(true);
        
    }

	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource()==buttonOk)
		{
			setVisible(false);
			Play.saveReservation(play,position,name.getText(),surname.getText(),(String)combo.getSelectedItem());
			plays=Play.loadPlays();
			for (int k=0;k<10;k++)
			{
				if (plays[k]!=null)
				if ((plays[k].getName()).equals(play.getName()))
					play=plays[k];
			}																		
			BlueprintTheatre sx_th_eis_ok=new BlueprintTheatre(play);
		}
		if (evt.getSource()==buttonCancel)
		{
			setVisible(false);
			BlueprintTheatre sx_th_eis_akyro=new BlueprintTheatre(play);
		}

	} 
}