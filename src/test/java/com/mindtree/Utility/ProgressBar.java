package com.mindtree.Utility;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ProgressBar extends JFrame {
	
	static JFrame f;
	static JProgressBar b;
	public void getProgressBar() {
		f = new JFrame ("ProgressBar Demo");
		JPanel p=new JPanel();
		b=new JProgressBar(0,100);
		b.setValue(0);
		b.setBounds(20,50,100,80);
		b.setStringPainted(true);
		
		add(b);
		
		add(b);
		setSize(1500,100);
		setVisible(true);
	}
public void fillGreen(int i)
{
	b.setValue(i);
	b.setForeground(Color.GREEN);
}
public void fillRed(int i)
{
	b.setValue(i);
	b.setForeground(Color.RED);
}

}
