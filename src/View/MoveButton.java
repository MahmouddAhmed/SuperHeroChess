package View;

import javax.swing.Icon;
import javax.swing.JButton;

import model.game.Direction;

public class MoveButton extends JButton {
	Direction d;
	
	public MoveButton(Direction d,Icon s) {
		super(s);
		this.d=d;
	}

	public Direction getD() {
		return d;
	}
	
	
}
