package org.varvaras.dimitris;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;


public class TheatreManagement extends JFrame implements ActionListener
{
	private JButton buttonInsert=new JButton("Insert Play");					
	private JButton buttonDelete=new JButton("Delete Play");
	private JButton buttonSelect=new JButton("Select Play");
	private JPanel panel=new JPanel();

    public TheatreManagement() 
    {
        super("Theatre Management");
        setResizable(false);
        setLocation(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(3,2));
        buttonInsert.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonSelect.addActionListener(this);
        panel.add(buttonInsert);
        panel.add(buttonDelete);
        panel.add(buttonSelect);
        setContentPane(panel);
        pack();
        setVisible(true);
        
    }

	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource()==buttonInsert)
		{
			setVisible(false);
			InsertPlayWindow ep=new InsertPlayWindow();
		}
		if (evt.getSource()==buttonSelect)								
		{
			setVisible(false);
			SelectPlayWindow ep=new SelectPlayWindow();
		}
		if (evt.getSource()==buttonDelete)
		{
			setVisible(false);
			DeletePlayWindow dp=new DeletePlayWindow();
		}

	} 
    public static void main(String[] arguments) 
    {
    	Play.initialization();
        TheatreManagement ap = new TheatreManagement();
    }
}






