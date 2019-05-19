package View;

import javax.swing.Icon;
import javax.swing.JButton;

import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;

public class HeroButton extends JButton {
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	int i;
	int j;
	Piece piece;
	
	public HeroButton(int i,int j,Piece piece,Icon x) {
		super(x);
		this.i=i;
		this.j=j;
		this.piece=piece;
		this.setToolTipText(this.toString());
	}
	
	public String toString() {
		if(piece instanceof Armored) 
			return("<html>"   + "Owner : "+piece.getOwner().getName()+"<br>"    + "name : "+piece.getName() + "<br>"+"type : Armored"+"<br>"+"ArmorUP : "+((Armored)piece).isArmorUp()+"<br>"+"Directions : All "+"</html>");
		else if(piece instanceof Speedster) 
			return("<html>"   + "Owner : "+piece.getOwner().getName()+"<br>"    + "name : "+piece.getName() + "<br>"+"type : Speedster"+"<br>"+"Directions : All "+"</html>");
		else if(piece instanceof Medic)
			return("<html>"   + "Owner : "+piece.getOwner().getName()+"<br>"    + "name : "+piece.getName() + "<br>"+"type : Medic"+"<br>"+"PowerUsed : "+((Medic)piece).isPowerUsed()+"<br>"+"Directions : Up-Down-Left-Right "+"</html>");
		else if(piece instanceof Ranged)
			return("<html>"   + "Owner : "+piece.getOwner().getName()+"<br>"    + "name : "+piece.getName() + "<br>"+"type : Ranged"+"<br>"+"PowerUsed : "+((Ranged)piece).isPowerUsed()+"<br>"+"Directions : All "+"</html>");
		else if(piece instanceof Super)
			return("<html>"   + "Owner : "+piece.getOwner().getName()+"<br>"    + "name : "+piece.getName() + "<br>"+"type : Super"+"<br>"+"PowerUsed : "+((Super)piece).isPowerUsed()+"<br>"+"Directions : Up-Down-Left-Right "+"</html>");
		else if(piece instanceof Tech)
			return("<html>"   + "Owner : "+piece.getOwner().getName()+"<br>"    + "name : "+piece.getName() + "<br>"+"type : Tech"+"<br>"+"PowerUsed : "+((Tech)piece).isPowerUsed()+"<br>"+"Directions : UpLeft-UpRight-DownLeft-DownRight "+"</html>");
		else if (piece instanceof SideKick)
			return("<html>"   + "Owner : "+piece.getOwner().getName()+"<br>"    + "name : "+piece.getName() + "<br>"+"type : SideKick"+"</html>");
		else
			return ("EmptyCell");
	}
	
	
	
	
	
	

	


}
