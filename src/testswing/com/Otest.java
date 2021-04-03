package testswing.com;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

 class Otest extends JFrame implements ActionListener{
	
	//private static final long serialVersionUID = 1L;
	JLabel label;
	JRadioButton radiobutton[]=new JRadioButton[5];
	JButton  btnnext , btnbookmark;
	ButtonGroup bg;
	int x=1,y=1,count=0,now=0,current=0;
	int m[]=new int[10];
	
	 Otest(String s) {
		super(s);
		//label create
		label=new JLabel();
		add(label);
		
		//to add radiobutton
		 bg=new ButtonGroup();
		for(int i=0;i<5;i++) {
			radiobutton[i]=new JRadioButton();
			add(radiobutton[i]);
			bg.add(radiobutton[i]);
		}//////////////////////////////////////this is constructor
		
		//creation of two buttons
		 btnnext=new JButton("Next");
		 btnbookmark= new JButton("Bookmark");
		btnnext.addActionListener(this);
		btnbookmark.addActionListener(this);
		add(btnnext);
		add(btnbookmark);
		
		//set method for setting the currents\
		 set();

		 //setting bounds to created components
		 
		label.setBounds(30,40,450,20);
		radiobutton[0].setBounds(50, 80, 450, 20);
		radiobutton[1].setBounds(50,110, 200, 20);
		radiobutton[2].setBounds(50, 140, 200, 20);
		radiobutton[3].setBounds(50, 170, 200, 20);
		btnnext.setBounds(100, 240, 100, 30);
		btnbookmark.setBounds(270, 240, 100, 30);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	

	//All Methods to handle actions 
	public void actionPerformed(ActionEvent e) {
	//to handle next button
		if(e.getSource()==btnnext) 
		{
			if(check())
				count=count+1;
			current++;
			set();
			if(current==9)
				{btnnext.setEnabled(false);
			    btnbookmark.setText("Result");}
	}
	
	//to handle bookmark
	if(e.getActionCommand().equals("Bookmark")) 
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480, 20+30*x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;			
			set();			
			if(current==9)
				btnbookmark.setText("Result here");
			setVisible(false);
			setVisible(true);
		}
	//working of bookmark
	for(int i=0,y=1;i<x;i++,y++) 
	{
		if(e.getActionCommand().equals("Bookmark" + y)) 
		{
			if(check())
				count++;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
	}
	
	//correct answers count
	if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
				current++;
			JOptionPane.showMessageDialog(this, "correct answers : "+ count);
			System.exit(0);	
		}			
	}
	
	//method to set currents
	void set() {
		radiobutton[4].setSelected(true);
		if(current==0) {
			label.setText("Que.1 : Data bus of 80286 MPU is of size_____?");
			radiobutton[0].setText("8 bit");
			radiobutton[1].setText("16 bit");//////R
			radiobutton[2].setText("32 bit");
			radiobutton[3].setText("64 bit");
		}
		if(current==1) {
			label.setText("Que2: Which has triple clock speed?");
			radiobutton[0].setText("80286");
			radiobutton[1].setText("DX3");
			radiobutton[2].setText("DX2");/////R
			radiobutton[3].setText("DX4");
		}
		if(current==2) {
			label.setText("Que.3 : Full form of RISC?");
			radiobutton[0].setText("R instruction set computer");
			radiobutton[1].setText("Reserved instruction set computing");
			radiobutton[2].setText("Reduced instruction server computing");
			radiobutton[3].setText("Reduced instruction set computing");//////R
		}
		if(current==3) {
			label.setText("Que4: \"Branch prediction is introduced in" + "?");
			radiobutton[0].setText("Pentium");/////////R
			radiobutton[1].setText("80286");
			radiobutton[2].setText("8086");
			radiobutton[3].setText("awt");
		}
		if(current==4) {
			label.setText("Que5: First five flags in microprocessor are for which processor" + 
					"?");
			radiobutton[0].setText("8085");///////R
			radiobutton[1].setText("8086");
			radiobutton[2].setText("80386");
			radiobutton[3].setText("80286");
		}
		if(current==5) {
			label.setText("Que.6 : What is ES\r\n" + 
					"?");
			radiobutton[0].setText("stack segment");
			radiobutton[1].setText("code segment");
			radiobutton[2].setText("data segment");///////////R
			radiobutton[3].setText("Instruction pointer");
		}
		if(current==6) {
			label.setText("Que7: IBM uses which processor\r\n" + 
					"?");
			radiobutton[0].setText("8086");
			radiobutton[1].setText("8088");//////////R
			radiobutton[2].setText("80286");
			radiobutton[3].setText("80386");
		}
		if(current==7) {
			label.setText("Que8: Programming model consist of how many register groups\r\n" + 
					"?");
			radiobutton[0].setText("two");
			radiobutton[1].setText("six");
			radiobutton[2].setText("five");
			radiobutton[3].setText("three");////////R
		}
		if(current==8) {
			label.setText("Que9: PC/AT introduced which year\r\n" + 
					"?");
			radiobutton[0].setText("1980");
			radiobutton[1].setText("1984");///////////R
			radiobutton[2].setText("1900");
			radiobutton[3].setText("1985");
		}
		if(current==9) {
			label.setText("Que10: Which has 32 bit data bus\r\n" + 
					"?");
			radiobutton[0].setText("8088");
			radiobutton[1].setText("8086");
			radiobutton[2].setText("80386");///////R
			radiobutton[3].setText("Pentium");
		}
		 label.setBounds(30,40,450,20);  
	        for(int i=0,j=0;i<=90;i+=30,j++)  
	            radiobutton[j].setBounds(50,80+i,200,20); 
		//return false;
		}
		
		//method to declare right answers
		boolean check() {

			if(current==0)
				return(radiobutton[1].isSelected());
			if(current==1)
				return(radiobutton[2].isSelected());
			if(current==2)
				return(radiobutton[3].isSelected());
			if(current==3)
				return(radiobutton[0].isSelected());
			if(current==4)
				return(radiobutton[0].isSelected());
			if(current==5)
				return(radiobutton[2].isSelected());
			if(current==6)
				return(radiobutton[1].isSelected());
			if(current==7)
				return(radiobutton[3].isSelected());
			if(current==8)
				return(radiobutton[1].isSelected());
			if(current==9)
				return(radiobutton[2].isSelected());
			return false;
		}
		

	
	//main method
	public static void main(String s[]) {
		new Otest("Online Test App");
	}
}








