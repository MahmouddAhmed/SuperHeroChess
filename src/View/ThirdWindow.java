package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.InvalidPowerUseException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Cell;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;



public class ThirdWindow extends JFrame implements ActionListener{
	JPanel Board;
	Game game;
	JProgressBar Prog1;
	JProgressBar Prog2;
	JLabel currentP1=new JLabel("Your Turn!!");
	JLabel currentP2=new JLabel("Your Turn!!");
	JComboBox dead1=new JComboBox(); 
	JComboBox dead2=new JComboBox();
	JButton reset;
	MoveButton Up;
	MoveButton Down;
	MoveButton Left;
	MoveButton Right;
	MoveButton UpRight;
	MoveButton UpLeft;
	MoveButton DownRight;
	MoveButton DownLeft;
	JButton Move;
	JButton UsePower;
	Piece SelectedPiece;
	Direction SelectedDirection;
	Piece SelectedDeadPiece;
	Piece TechPiece;
	Point P;
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	
	
	public ThirdWindow(Player A,Player B) {
		
		super();
		 
		 game=new Game(A,B);
		 
		
		this.setLayout(null);
		this.setSize(800, 700);
		this.setVisible(true);
		this.setTitle("SuperHeroChess");
		Icon Background1= new ImageIcon("Background.jpg");
		JLabel Background=new JLabel(Background1);
		Background.setBounds(0,450,800,700);
		this.setContentPane(Background);
		
		
		
		Board=new JPanel();
		Board.setBounds(42,0, 700, 500);
		Board.setLayout(new GridLayout(7,6));
		
		
		this.getContentPane().add(Board);
		
		
		Prog1 = new JProgressBar(JProgressBar.VERTICAL,0, 6);
		Prog1.setBounds(-2, 0, 45, 499);
		
		Prog1.setBackground(Color.decode("#6E6E6E"));
		Prog1.setForeground(Color.decode("#424242"));
		this.getContentPane().add(Prog1);
		
		
		Prog2 = new JProgressBar(JProgressBar.VERTICAL,0, 6);
		Prog2.setBounds(739, 0, 55, 499);
		Prog2.setBackground(Color.decode("#6E6E6E"));
		Prog2.setForeground(Color.decode("#424242"));
		this.getContentPane().add(Prog2);
		
		Icon Up1= new ImageIcon("Up.png");
		Up=new MoveButton(Direction.UP,Up1);
		Up.setBounds(360, 505, 50, 50);
		this.getContentPane().add(Up);
		Up.addActionListener(this);
		
		
		Icon Down1= new ImageIcon("Down.png");
		Down=new MoveButton(Direction.DOWN,Down1);
		Down.setBounds(360, 605, 50, 50);
		this.getContentPane().add(Down);
		Down.addActionListener(this);
		
		Icon Left1= new ImageIcon("Left.png");
		Left=new MoveButton(Direction.LEFT,Left1);
		Left.setBounds(310, 555, 50, 50);
		this.getContentPane().add(Left);
		Left.addActionListener(this);
		
		Icon Right1= new ImageIcon("Right .png");
		Right=new MoveButton(Direction.RIGHT,Right1);
		Right.setBounds(410, 555, 50, 50);
		this.getContentPane().add(Right);
		Right.addActionListener(this);
		
		Icon UpRight1= new ImageIcon("UpRight.png");
		UpRight=new MoveButton(Direction.UPRIGHT,UpRight1);
		UpRight.setBounds(410, 505, 50, 50);
		this.getContentPane().add(UpRight);
		UpRight.addActionListener(this);
		
		Icon UpLeft1= new ImageIcon("UpLeft.png");
		UpLeft=new MoveButton(Direction.UPLEFT,UpLeft1);
		UpLeft.setBounds(310, 505, 50, 50);
		this.getContentPane().add(UpLeft);
		UpLeft.addActionListener(this);
		
		Icon DownRight1= new ImageIcon("DownRight.png");
		DownRight=new MoveButton(Direction.DOWNRIGHT,DownRight1);
		DownRight.setBounds(410, 605, 50, 50);
		this.getContentPane().add(DownRight);
		DownRight.addActionListener(this);
		
		Icon DownLeft1= new ImageIcon("DownLeft.png");
		DownLeft=new MoveButton(Direction.DOWNLEFT,DownLeft1);
		DownLeft.setBounds(310, 605, 50, 50);
		this.getContentPane().add(DownLeft);
		DownLeft.addActionListener(this);
		
		reset=new JButton("R");
		reset.setBounds(360, 555, 50, 50);
		this.add(reset);
		reset.addActionListener(this);
		reset.setToolTipText("Select Another Piece");
		
		JLabel p1name=new JLabel(A.getName());
		p1name.setBounds(45,510,100,15);
		p1name.setForeground(Color.WHITE);
		this.add(p1name);
		
		JLabel p2name=new JLabel(B.getName());
		p2name.setBounds(628,510,100,15);
		p2name.setForeground(Color.white);
		this.add(p2name);
		
		dead1.setToolTipText(game.getPlayer1().getName()+" Dead Charachters");
		dead1.setBounds(200, 510, 100, 20);
		dead1.addActionListener(this);
		this.add(dead1);
		
		dead2.setToolTipText(game.getPlayer2().getName()+" Dead Charachters");
		dead2.setBounds(470, 510, 100, 20);
		dead2.addActionListener(this);
		this.add(dead2);
		
		Move=new JButton("Move");
		Move.setBounds(470, 605, 100, 50);
		Move.addActionListener(this);
		this.add(Move);
		
		UsePower=new JButton("UsePower");
		UsePower.setBounds(200, 605, 100, 50);
		UsePower.addActionListener(this);
		this.add(UsePower);
		
		currentP1.setBounds(210, 550, 100, 30);
		currentP1.setFont(new Font("Serif", Font.BOLD, 15));
		currentP1.setForeground(Color.GREEN);
		this.add(currentP1);
		
		currentP2.setBounds(480, 550, 100, 30);
		currentP2.setFont(new Font("Serif", Font.BOLD, 15));
		currentP2.setForeground(Color.GREEN);
		this.add(currentP2);
		
		Icon JL1= new ImageIcon("JusticeLeague.png");
		JLabel JL= new JLabel(JL1);
		JL.setBounds(25, 525, 150, 130);
		
		this.add(JL);
		Icon AV1= new ImageIcon("Avengers.png");
		JLabel AV= new JLabel(AV1);
		AV.setBounds(620, 526, 150, 130);
		this.add(AV);
//		Up.setBackground(Color.decode("#6E6E6E"));
//		Down.setBackground(Color.decode("#6E6E6E"));
//		Left.setBackground(Color.decode("#6E6E6E"));
//		Right.setBackground(Color.decode("#6E6E6E"));
//		UpRight.setBackground(Color.decode("#6E6E6E"));
//		UpLeft.setBackground(Color.decode("#6E6E6E"));
//		DownRight.setBackground(Color.decode("#6E6E6E"));
//		DownLeft.setBackground(Color.decode("#6E6E6E"));
		
		
		
		reset();	
		
		
	}
	
	public void reset() {
		Board.removeAll();
		
		for (int i=0;i<7;i++) 
			for(int j=0;j<6;j++){
				if(game.getCellAt(i, j).getPiece()!=null) {
					if(game.getCellAt(i, j).getPiece() instanceof Armored  && ((Armored)game.getCellAt(i, j).getPiece()).isArmorUp()==false) {
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1()) {
							Icon picture = new ImageIcon("WDD.jpg");
							HeroButton Piece=new HeroButton(i,j,game.getCellAt(i, j).getPiece(),picture);
							Piece.addActionListener(this);
							
							Board.add(Piece);
						}
						else {
							Icon picture = new ImageIcon("CAD.jpg");
							HeroButton Piece=new HeroButton(i,j,game.getCellAt(i, j).getPiece(),picture);
							Piece.addActionListener(this);
							
							Board.add(Piece);
						}
						
						
						
						
						
					}
					else {
						String hero=(game.getCellAt(i, j).getPiece().getName())+".jpg";
						Icon picture = new ImageIcon(hero);
						HeroButton Piece=new HeroButton(i,j,game.getCellAt(i, j).getPiece(),picture);
						Piece.addActionListener(this);
						
						Board.add(Piece);
					}
				}
				else {
					Icon Ground= new ImageIcon("Ground.jpg");
					HeroButton Piece=new HeroButton(i,j,null,Ground);
					Piece.addActionListener(this);
					
					Board.add(Piece);
				}
				
				
			}
		Prog1.setValue(game.getPlayer1().getPayloadPos());
		Prog2.setValue(game.getPlayer2().getPayloadPos());
		if (game.getCurrentPlayer()==game.getPlayer1()) {
			currentP1.setVisible(true);
			currentP2.setVisible(false);
		}
		
		else {
			currentP1.setVisible(false);
			currentP2.setVisible(true);
		}
		
		dead1.setModel(new DefaultComboBoxModel((game.getPlayer1().getDeadCharacters()).toArray()));
		dead2.setModel(new DefaultComboBoxModel((game.getPlayer2().getDeadCharacters()).toArray()));
		
		
		SelectedPiece=null;
		SelectedDirection=null;
		SelectedDeadPiece=null;
		TechPiece=null;
		P=null;
		
		if(game.getPlayer1().getPayloadPos()==game.getPayloadPosTarget()) {
			JOptionPane.showMessageDialog(this,game.getPlayer1().getName()+"Wins!" ,"Victory",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
			
		if(game.getPlayer2().getPayloadPos()==game.getPayloadPosTarget()) {
			JOptionPane.showMessageDialog(this,game.getPlayer2().getName()+"Wins!" ,"Victory",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
		
	}

	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==reset) {
			this.reset();
		}
		
		
		
		if(e.getSource() instanceof HeroButton) {
		if(!(SelectedPiece instanceof Tech)) {
			SelectedPiece=( (HeroButton)e.getSource()).getPiece();
			if(SelectedPiece!=null&&SelectedPiece.getOwner()!=game.getCurrentPlayer()) {
				JOptionPane.showMessageDialog(this, "Not Your Turn","Error",JOptionPane.ERROR_MESSAGE);
				this.reset();
			}
			if(SelectedPiece!=null) {
			//((JButton) e.getSource()).setBorder(new LineBorder(Color.BLUE));
			//this.revalidate();
			//this.repaint();
			ArrayList<Point>glow= SelectedPiece.AvalibleSpace();
			gloww(glow);
			}
			else this.reset();
			
			//P=new Point(( (HeroButton)e.getSource()).getPiece().getPosI(),( (HeroButton)e.getSource()).getPiece().getPosJ());
		}
		else if(TechPiece==null){
			
			TechPiece=((HeroButton) e.getSource()).getPiece();
			((JButton) e.getSource()).setBorder(new LineBorder(Color.BLACK));
			
			this.revalidate();
			this.repaint();
			
			
		}
		else 
		P=new Point(((HeroButton) e.getSource()).getI(),((HeroButton) e.getSource()).getJ());
		((JButton) e.getSource()).setBorder(new LineBorder(Color.GREEN));
		this.repaint();
		this.revalidate();
		//else
			//SelectedPiece=( (HeroButton)e.getSource()).getPiece();
		}
		
		if(e.getSource() instanceof MoveButton) {
			SelectedDirection= ((MoveButton) e.getSource()).getD();
			//System.out.println(SelectedDirection);
		}
		
		if(e.getSource()==Move) {
			try {
				SelectedPiece.move(SelectedDirection);
				//this.reset();
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, "UnallowedMovement.","Error",JOptionPane.ERROR_MESSAGE);
			} catch (OccupiedCellException e1) {
				JOptionPane.showMessageDialog(this, "Cell Contains friendly Piece","Error",JOptionPane.ERROR_MESSAGE);
			} catch (WrongTurnException e1) {
				JOptionPane.showMessageDialog(this, "Not Your Turn","Error",JOptionPane.ERROR_MESSAGE);
			} catch(NullPointerException e1) {
				JOptionPane.showMessageDialog(this, "Please Select Piece","Error",JOptionPane.ERROR_MESSAGE);
			}
			finally {
				this.reset();
			}
		}
			
		if(e.getSource()==UsePower&& ((SelectedPiece instanceof Ranged)||(SelectedPiece instanceof Super))) {
			try {
				((ActivatablePowerHero) SelectedPiece).usePower(SelectedDirection,null,null);
				//this.reset();
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			} catch (InvalidPowerUseException e1) {
				if (e1.getLocalizedMessage()==null)
					JOptionPane.showMessageDialog(this, "Piece Used Power already","Error",JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(this, e1.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					
			} catch (WrongTurnException e1) {
				JOptionPane.showMessageDialog(this, "Not Your Turn","Error",JOptionPane.ERROR_MESSAGE);
				//e1.printStackTrace();
			}
			finally {
				this.reset();
			}
				
		}
		
		if(e.getSource()==dead1||e.getSource()==dead2) {
			SelectedDeadPiece=(Piece) ((JComboBox) e.getSource()).getSelectedItem();
			
		}
		
		if(e.getSource()==UsePower&&(SelectedPiece instanceof Medic)) {
			
			
			
			try {
				((ActivatablePowerHero) SelectedPiece).usePower(SelectedDirection,SelectedDeadPiece,null);
				//this.reset();
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			} catch (InvalidPowerUseException e1) {
				if(e1.getLocalizedMessage()!=null)
				JOptionPane.showMessageDialog(this, e1.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(this,"Piece Used it Power Already","Error",JOptionPane.ERROR_MESSAGE);
			} catch (WrongTurnException e1) {
				JOptionPane.showMessageDialog(this, "Not Your Turn","Error",JOptionPane.ERROR_MESSAGE);
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(this, "Please Select Dead Piece","Error",JOptionPane.ERROR_MESSAGE);
				
			}
			finally {
				this.reset();
			}
			
		}
		
		if(e.getSource()==UsePower&&(SelectedPiece instanceof Tech)) {
			try {
				((ActivatablePowerHero) SelectedPiece).usePower(null,TechPiece,P);
				this.reset();
			} catch (UnallowedMovementException e1) {
				JOptionPane.showMessageDialog(this, e1.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
			} catch (InvalidPowerUseException e1) {
				if(e1.getLocalizedMessage()!=null)
					JOptionPane.showMessageDialog(this, e1.getLocalizedMessage(),"Error",JOptionPane.ERROR_MESSAGE);
					else
						JOptionPane.showMessageDialog(this,"Piece Used it Power Already","Error",JOptionPane.ERROR_MESSAGE);	
			} catch (WrongTurnException e1) {
				JOptionPane.showMessageDialog(this, "Not Your Turn","Error",JOptionPane.ERROR_MESSAGE);
		
			} catch (NullPointerException e1) {
				JOptionPane.showMessageDialog(this, "Please Select Target","Error",JOptionPane.ERROR_MESSAGE);
			}
			finally {
				this.reset();
			}
		}
			
		
		
		
			
		
		
	}
	
	public void gloww (ArrayList<Point> X) {
		Board.removeAll();
		for (int i=0;i<7;i++) 
			for(int j=0;j<6;j++){
				if(game.getCellAt(i, j).getPiece()!=null&&(game.getCellAt(i, j).getPiece().getOwner()==game.getCurrentPlayer() ||!(X.contains(new Point(i,j))))) {
					
					if(game.getCellAt(i, j).getPiece() instanceof Armored  && ((Armored)game.getCellAt(i, j).getPiece()).isArmorUp()==false) {
						if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1()) {
							Icon picture = new ImageIcon("WDD.jpg");
							HeroButton Piece=new HeroButton(i,j,game.getCellAt(i, j).getPiece(),picture);
							Piece.addActionListener(this);
							
							Board.add(Piece);
						}
						else {
							Icon picture = new ImageIcon("CAD.jpg");
							HeroButton Piece=new HeroButton(i,j,game.getCellAt(i, j).getPiece(),picture);
							Piece.addActionListener(this);
							
							Board.add(Piece);
						}
						
						
						
						
						
					}
					else {
						String hero=(game.getCellAt(i, j).getPiece().getName())+".jpg";
						Icon picture = new ImageIcon(hero);
						HeroButton Piece=new HeroButton(i,j,game.getCellAt(i, j).getPiece(),picture);
						Piece.addActionListener(this);
						
						Board.add(Piece);
					}
				}
				else {
					if(X.contains(new Point(i,j))) {
						
						if(game.getCellAt(i, j).getPiece()==null) {
							Icon Ground= new ImageIcon("Ground1.jpg");
							HeroButton Piece=new HeroButton(i,j,null,Ground);
							//Piece.setBackground(Color.GREEN);
							Piece.addActionListener(this);
						
							Board.add(Piece);
							this.revalidate();
							this.repaint();
						
						}
						
						else if(game.getCellAt(i, j).getPiece() instanceof Armored && ((Armored)game.getCellAt(i, j).getPiece()).isArmorUp()==false) {
							String S;
							if(game.getCellAt(i, j).getPiece().getOwner()==game.getPlayer1())
									S="WDD1.jpg";
							else
								S="CAD1.jpg";
							Icon pic=new ImageIcon(S);
							HeroButton Piece=new HeroButton(i,j,null,pic);
							Piece.addActionListener(this);
							Board.add(Piece);
							this.revalidate();
							this.repaint();
						
						}
							
							
						else {	
							String S=game.getCellAt(i, j).getPiece().getName()+"1.jpg";
							Icon pic=new ImageIcon(S);
							HeroButton Piece=new HeroButton(i,j,null,pic);
							Piece.addActionListener(this);
							Board.add(Piece);
							this.revalidate();
							this.repaint();
						}
						
						
					}
					
					
					
					else {
					Icon Ground= new ImageIcon("Ground.jpg");
					HeroButton Piece=new HeroButton(i,j,null,Ground);
					Piece.addActionListener(this);
					
					Board.add(Piece);
					this.revalidate();
					this.repaint();
					//System.out.println(1);
					}
				}
				
			}
	}
	
	
	
	
	public static void main(String [] args) {
		FirstWindow z=new FirstWindow();
		
	}
}
