package model.pieces.heroes;

import java.awt.Point;

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

public class Tech extends ActivatablePowerHero {

	public Tech(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public void moveUp() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.UP);
	}

	@Override
	public void moveDown() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.DOWN);
	}

	@Override
	public void moveRight() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.RIGHT);
	}

	@Override
	public void moveLeft() throws UnallowedMovementException {
		throw new UnallowedMovementException(this, Direction.LEFT);
	}

	public void usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, UnallowedMovementException, InvalidPowerUseException{
		super.usePower(d, target, newPos);
	
	
	
		if(newPos!=null) {
			int i=newPos.x;
			int j=newPos.y;
			int i2=target.getPosI();
			int j2=target.getPosJ();
				
			
			if(this.getOwner()!=target.getOwner()) {
				throw new InvalidPowerTargetException("the target piece doesn’t belong to the same team",this,target);
			}
			if(this.getGame().getCellAt(i, j).getPiece()!=null) {
				throw new InvalidPowerTargetException("the target location is occupied", this, target);
			}
			
				this.getGame().getCellAt(i, j).setPiece(target);
				target.setPosI(i);
				target.setPosJ(j);
				this.getGame().getCellAt(i2, j2).setPiece(null);
			
		}		
		else if(this.getOwner()!=target.getOwner()) {
			if(target instanceof Armored) {
				if(((Armored) target).isArmorUp()==false) {
					throw new InvalidPowerTargetException("the enemy has already used its power and cannot be hacked", this, target);
				}
				else {
					((Armored) target).setArmorUp(false);
				}
					
			}
			else if(target instanceof ActivatablePowerHero) {
				if(((ActivatablePowerHero) target).isPowerUsed()==true) {
					throw new InvalidPowerTargetException("the enemy has already used its power and cannot be hacked", this, target);
				}
				else {
					((ActivatablePowerHero) target).setPowerUsed(true);
				}
					
			}
			else {
				throw new InvalidPowerTargetException("the enemy has no ability and cannot be hacked", this, target);
			}
		}
		else {
			if(target instanceof Armored) {
				if(((Armored) target).isArmorUp()==true) {
					throw new InvalidPowerTargetException("the target piece did not use its power yet.", this, target);
				}
				else {
					((Armored) target).setArmorUp(true);
				}
					
			}
			else if(target instanceof ActivatablePowerHero) {
				if(((ActivatablePowerHero) target).isPowerUsed()==false) {
					throw new InvalidPowerTargetException("the target piece did not use its power yet.", this, target);
				}
				else {
					((ActivatablePowerHero) target).setPowerUsed(false);
				}
					
			}
			else {
				throw new InvalidPowerTargetException("the target piece has no ability and cannot be unhacked", this, target);
			}
		}
		
	
	
		
	this.setPowerUsed(true);	
	}

	@Override
	public String toString() {
		if(this.getOwner()==this.getGame().getPlayer1())
			return "Batman";
		else
			return"Ironman";
	}
}
