package model.pieces.sidekicks;

import model.game.Cell;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;

public abstract class SideKick extends Piece {

	public SideKick(Player player, Game game, String name) {
		super(player, game, name);
	}

	public void attack(Piece target) {

		Cell c = getGame().getCellAt(getPosI(), getPosJ());
		String S;
		if (!(target instanceof SideKick)) {
			

			if (target instanceof Armored && !((Armored) target).isArmorUp()) {
				if(this.getOwner()==this.getGame().getPlayer1()) 
					S="Wonder Woman";
				else
					S="Captain America";
				c.setPiece(new Armored(getOwner(), getGame(), S));
			}

			if (target instanceof Medic) {
				if(this.getOwner()==this.getGame().getPlayer1()) 
					S="Green Lantern";
				else
					S="Vision";
				c.setPiece(new Medic(getOwner(), getGame(), S));
			}

			if (target instanceof Ranged) {
				if(this.getOwner()==this.getGame().getPlayer1()) 
					S="Green Arrow";
				else
					S="Hawk Eye";
				c.setPiece(new Ranged(getOwner(), getGame(), S));
			}

			if (target instanceof Speedster) {
				if(this.getOwner()==this.getGame().getPlayer1()) 
					S="Flash";
				else
					S="Quick Silver";
				c.setPiece(new Speedster(getOwner(), getGame(), S));
			}

			if (target instanceof Super) {
				if(this.getOwner()==this.getGame().getPlayer1()) 
					S="Superman";
				else
					S="Hulk";
				c.setPiece(new Super(getOwner(), getGame(), S));
			}

			if (target instanceof Tech) {
				if(this.getOwner()==this.getGame().getPlayer1()) 
					S="Batman";
				else
					S="Ironman";
				c.setPiece(new Tech(getOwner(), getGame(), S));
			}

		}

		super.attack(target);

	}

	@Override
	public String toString() {
		if(this.getOwner()==this.getGame().getPlayer1())
			return "Robin";
		else
			return"Spiderman";
	}
}
