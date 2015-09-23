package org.varvaras.dimitris;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectPlayWindow extends JFrame implements ActionListener
{
	private JButton buttonOk=new JButton("Ok");
	private JButton buttonCancel=new JButton("Cancel");								
	private JLabel dateLab=new JLabel("Select Play:");
	private JComboBox combo=new JComboBox();
	private JPanel panel=new JPanel();
   

    public SelectPlayWindow() 
    {
        super("Insert Play");
	   	setResizable(false);
        setLocation(400,400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(2,2));
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
        panel.add(dateLab);panel.add(combo);
        Play[] playsArray=new Play[10];
        playsArray=Play.loadPlays();
        for (int k=0;k<10;k++)
        	if (playsArray[k]!=null)
        		combo.addItem(playsArray[k].getName());
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
        	Play[] playsArray=new Play[10];
        	playsArray=Play.loadPlays();
        	int c=-1;
        	for (int k=0;k<10;k++)
        	{																			
        		if (playsArray[k]!=null)
        		if 	(	( playsArray[k].getName()).equals(combo.getSelectedItem())	)
        		{
					c=k;
        		}
        	}
        	if (c==-1)
        	{
        		SelectPlayWindow ep_ok_denyp=new SelectPlayWindow();
        		
        	}
        	else if (	(c>=0)&(c<10)	)
        	{
        		BlueprintTheatre sx_th_can=new BlueprintTheatre(playsArray[c]);
        	}
		}
		if (evt.getSource()==buttonCancel)
		{
			setVisible(false);
			TheatreManagement ap_epi_can=new TheatreManagement();
		}
	}
}