package model.pieces.heroes;

import java.awt.Point;

import model.game.Cell;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.InvalidPowerUseException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;

public class Super extends ActivatablePowerHero {

	public Super(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public void moveUpRight() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.UPRIGHT);
	}

	@Override
	public void moveUpLeft() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.UPLEFT);
	}

	@Override
	public void moveDownRight() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.DOWNRIGHT);
	}

	@Override
	public void moveDownLeft() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.DOWNLEFT);
	}

	@Override
	public void  usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, UnallowedMovementException, InvalidPowerUseException {
		super.usePower(d, target, newPos);
		int i=this.getPosI();
		int j=this.getPosJ();
		
		
			switch(d) {
		
			
		
			case UP:
				
				if(i-1>=0&&this.getGame().getCellAt(i-1, j).getPiece()!=null&&this.getGame().getCellAt(i-1, j).getPiece().getOwner()!=this.getOwner())
					this.attack(this.getGame().getCellAt(i-1, j).getPiece());
				if(i-2>=0&&this.getGame().getCellAt(i-2, j).getPiece()!=null&&this.getGame().getCellAt(i-2, j).getPiece().getOwner()!=this.getOwner())
					this.attack(this.getGame().getCellAt(i-2, j).getPiece());
				break;
			case DOWN:
				
				if(i+1<7&&this.getGame().getCellAt(i+1, j).getPiece()!=null&&this.getGame().getCellAt(i+1, j).getPiece().getOwner()!=this.getOwner())
					this.attack(this.getGame().getCellAt(i+1, j).getPiece());
				if(i+2<7&&this.getGame().getCellAt(i+2, j).getPiece()!=null&&this.getGame().getCellAt(i+2, j).getPiece().getOwner()!=this.getOwner())
					this.attack(this.getGame().getCellAt(i+2, j).getPiece());
				break;
			case LEFT:
				if(j-1>-1 &&this.getGame().getCellAt(i, j-1).getPiece()!=null&&this.getGame().getCellAt(i, j-1).getPiece().getOwner()!=this.getOwner())
					this.attack(this.getGame().getCellAt(i, j-1).getPiece());
				if(j-2>-1 &&this.getGame().getCellAt(i, j-2).getPiece()!=null&&this.getGame().getCellAt(i, j-2).getPiece().getOwner()!=this.getOwner())
					this.attack(this.getGame().getCellAt(i, j-2).getPiece());
				break;
			case RIGHT:
				if(j+1<6&&this.getGame().getCellAt(i, j+1).getPiece()!=null&&this.getGame().getCellAt(i, j+1).getPiece().getOwner()!=this.getOwner())
					this.attack(this.getGame().getCellAt(i, j+1).getPiece());
				if(j+2<6&&this.getGame().getCellAt(i, j+2).getPiece()!=null&&this.getGame().getCellAt(i, j+2).getPiece().getOwner()!=this.getOwner())
					this.attack(this.getGame().getCellAt(i, j+2).getPiece());
				break;
			default:throw new InvalidPowerDirectionException("this direction is not allowed by the game rules", this, d);
			}
		
		
		this.setPowerUsed(true);
		this.getGame().switchTurns();
		}

	@Override
	public String toString() {
		if(this.getOwner()==this.getGame().getPlayer1())
			return "Superman";
		else
			return"Hulk";
	}
}
