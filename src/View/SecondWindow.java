package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.game.Player;

public class SecondWindow extends JFrame  implements ActionListener {
	Player A;
	String text;
	JTextField P1;
	public SecondWindow(Player A) {
		
		super();
		this.setBounds(500, 250, 370, 270);
		this.setTitle("Avengers");
		Icon AV1= new ImageIcon("AV.png");
		JLabel AV=new JLabel(AV1);
		this.setContentPane(AV);
		this.A=A;
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setSize(350,200);
		JLabel P2name = new JLabel("Player 2 name:");
		P2name.setBounds(70,10,100,100);
		P2name.setForeground(Color.WHITE);
		P1=new JTextField();
		P1.setBounds(160, 45, 90, 30);
		this.getContentPane().add(P2name);
		this.getContentPane().add(P1);
		 JButton Start= new JButton("Start");
		Start.setBounds(120, 100, 100, 50);
		this.getContentPane().add(Start);
		Start.addActionListener(this);
		this.setVisible(true);
		}
	
	//public static void main(String [] args) {
		//SecondWindow x = new SecondWindow();
		
//	}

	
	public void actionPerformed(ActionEvent e) {
			
		this.setVisible(false);
		text=P1.getText();
		Player B= new Player(text);
		ThirdWindow Z=new ThirdWindow(this.A,B);
		//this.removeAll();
		
	}
}
