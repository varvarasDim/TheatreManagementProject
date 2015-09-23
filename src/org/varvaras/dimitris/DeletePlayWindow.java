package org.varvaras.dimitris;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DeletePlayWindow extends JFrame implements ActionListener
{																	
   private JButton buttonOk=new JButton("Ok");
   private JButton buttonCancel=new JButton("Cancel");
   private JLabel datePlay=new JLabel("Select Play");
   private JComboBox combo=new JComboBox();
   private JPanel panel=new JPanel();
   

    public DeletePlayWindow() 
    {
        super("Delete Play");
		setResizable(false);
        setLocation(400,400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(2,2));
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
        Play[] playsArray=new Play[10];
        playsArray=Play.loadPlays();
        for (int k=0;k<10;k++)
        	if (playsArray[k]!=null)
        		combo.addItem(playsArray[k].getName());
        panel.add(datePlay);panel.add(combo);
        panel.add(buttonOk);panel.add(buttonCancel);
        setContentPane(panel);
        pack();
        setVisible(true);
        
    }

	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource()==buttonOk)
		{
			Play[] playsArray=new Play[10];
			playsArray=Play.loadPlays();
	        for (int k=0;k<10;k++)												
	        {
	        	if (	(playsArray[k]!=null)	&&	(	combo.getSelectedItem().equals(playsArray[k].getName())	)	)
	        	{
						playsArray[k]=null;
						break;
				}
			}
			Play.savePlays(playsArray);
			setVisible(false);
			TheatreManagement ap_dia_ok=new TheatreManagement();
			
		}
		if (evt.getSource()==buttonCancel)
		{
			setVisible(false);
			TheatreManagement ap_dia_can=new TheatreManagement();
		}
	}
}