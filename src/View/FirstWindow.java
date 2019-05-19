package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.game.Player;

public class FirstWindow extends JFrame  implements ActionListener{
		String text;
		JTextField P1;
	
	public FirstWindow() {
		super();
		this.setBounds(500, 250, 370, 270);
		Icon JL1= new ImageIcon("JL.jpg");
		JLabel JL=new JLabel(JL1);
		this.setContentPane(JL);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setSize(370,270);
		JLabel P1name = new JLabel("Player 1 name:");
		P1name.setBounds(70,10,100,100);
		P1=new JTextField();
		P1.setBounds(160, 45, 90, 30);
		this.getContentPane().add(P1name);
		this.setTitle("Justice League");
		P1name.setForeground(Color.WHITE);
		this.getContentPane().add(P1);
		 JButton Next= new JButton("Next");
		Next.setBounds(120, 100, 100, 50);
		this.getContentPane().add(Next);
		
		Next.addActionListener(this);
		this.setVisible(true);
		
		}
	
	//public static void main(String [] args) {
		//FirstWindow x = new FirstWindow();
		
	//}

	
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		text=this.P1.getText();
		Player A=new Player(text);
		SecondWindow Y = new SecondWindow(A);

		
	}

}
