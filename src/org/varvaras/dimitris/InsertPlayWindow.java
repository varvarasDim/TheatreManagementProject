package org.varvaras.dimitris;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InsertPlayWindow extends JFrame implements ActionListener
{
	private JButton buttonOk=new JButton("Ok");
	private JButton buttonCancel=new JButton("Cancel");										
	private JTextField id=new JTextField(20);
	private JTextField name=new JTextField(20);
	private JTextField date=new JTextField(20);
	private JTextField hour=new JTextField(20);
	private JTextField balconyPrice=new JTextField(20);
	private JTextField firstSquarePrice=new JTextField(20);
	private JTextField secondSquarePrice=new JTextField(20);
	private JLabel nameLab=new JLabel("Name");
	private JLabel dateLab=new JLabel("Date");
   
	private JLabel hourLab=new JLabel("Time");
	private JLabel balconyPriceLab=new JLabel("Balcony seat price");
	private JLabel firstSquarePriceLab=new JLabel("First square seat price");
	private JLabel secondSquarePriceLab=new JLabel("Second square seat price");
	private JLabel idLab=new JLabel("id");

	private JPanel panel=new JPanel();
   

    public InsertPlayWindow() 
    {
        super("Insert Play");
		setResizable(false);
        setLocation(400,400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(8,2));
        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
        panel.add(idLab);panel.add(id);
        panel.add(nameLab);panel.add(name);
        panel.add(dateLab);panel.add(date);
        panel.add(hourLab);panel.add(hour);
        panel.add(balconyPriceLab);panel.add(balconyPrice);
        panel.add(firstSquarePriceLab);panel.add(firstSquarePrice);
        panel.add(secondSquarePriceLab);panel.add(secondSquarePrice);
        panel.add(buttonOk);panel.add(buttonCancel);
        setContentPane(panel);
        pack();
        setVisible(true);
        
    }

	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource()==buttonOk)
		{
			Play play=new Play(id.getText(),name.getText(),
											date.getText(),hour.getText(),
												balconyPrice.getText(),firstSquarePrice.getText(),secondSquarePrice.getText());
			
			Play[] playsArray=new Play[10];
			playsArray=Play.loadPlays();
			int found=-1;
			for (int k=9;k>=0;k--)											//епикоцес
				if (playsArray[k]==null)
					found=k;
			if (found!=-1)
			{
				playsArray[found]=play;
				Play.savePlays(playsArray);
			}
			else
			{
			}
			setVisible(false);
			TheatreManagement ap_eis_ok=new TheatreManagement();
		}
		if (evt.getSource()==buttonCancel)
		{
			setVisible(false);
			TheatreManagement ap_eis_can=new TheatreManagement();
			
		}

	} 
}