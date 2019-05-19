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

public class Medic extends ActivatablePowerHero {

	public Medic(Player player, Game game, String name) {
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
		if(this.getOwner()!=target.getOwner())
			throw new InvalidPowerTargetException("the target piece belongs to the enemy team", this, target);
		if(!this.getOwner().getDeadCharacters().contains(target)) 
			throw new InvalidPowerTargetException("the target piece has not been eliminated before, so it cannot be revived", this, target);
		
		int i=this.getPosI();
		int j=this.getPosJ();
		
		
		switch(d) {
			case RIGHT:
				
				if(j==5) 
					 j=0;
				else
					j=j+1;
				
				
				if(this.getGame().getCellAt(i, j).getPiece()==null) {
				
				this.getGame().getCellAt(i, j).setPiece(target);
				if(target instanceof Armored)
					((Armored)target).setArmorUp(true);
				else if(target instanceof ActivatablePowerHero) 
					((ActivatablePowerHero)target).setPowerUsed(false);
				
				target.setPosI(i);
				target.setPosJ(j);
				this.getOwner().getDeadCharacters().remove(target);
				break;
				
				}
				else {
					throw new InvalidPowerTargetException("the target location is occupied", this, target);
				}	
					
					
			case LEFT:
				
				if(j==0) {
					j=5;
				}
				else
					j=j-1;
				
				
				if(this.getGame().getCellAt(i, j).getPiece()==null) {
					
					this.getGame().getCellAt(i, j).setPiece(target);
					if(target instanceof Armored)
						((Armored)target).setArmorUp(true);
					else if(target instanceof ActivatablePowerHero) 
						((ActivatablePowerHero)target).setPowerUsed(false);
					target.setPosI(i);
					target.setPosJ(j);
					this.getOwner().getDeadCharacters().remove(target);
					break;
					}
					else {
						throw new InvalidPowerTargetException("the target location is occupied", this, target);
					}
			case UP:
				if(i==0) {
					i=6;
				}
				else
					i=i-1;
				
				if(this.getGame().getCellAt(i, j).getPiece()==null) {
					
					this.getGame().getCellAt(i, j).setPiece(target);
					if(target instanceof Armored)
						((Armored)target).setArmorUp(true);
					else if(target instanceof ActivatablePowerHero) 
						((ActivatablePowerHero)target).setPowerUsed(false);
					target.setPosI(i);
					target.setPosJ(j);
					this.getOwner().getDeadCharacters().remove(target);
					break;
					}
					else {
						throw new InvalidPowerTargetException("the target location is occupied", this, target);
					}
			case DOWN:
				if(i==6) {
					i=0;
				}
				else
					i=i+1;
				
				if(this.getGame().getCellAt(i, j).getPiece()==null) {
					
					this.getGame().getCellAt(i, j).setPiece(target);
					if(target instanceof Armored)
						((Armored)target).setArmorUp(true);
					else if(target instanceof ActivatablePowerHero) 
						((ActivatablePowerHero)target).setPowerUsed(false);
					target.setPosI(i);
					target.setPosJ(j);
					this.getOwner().getDeadCharacters().remove(target);
					break;
					}
					else {
						throw new InvalidPowerTargetException("the target location is occupied", this, target);
					}
			case UPRIGHT:
				if(i==0) {
					i=6;
				}
				else
					i=i-1;
				
				if(j==5)
					j=0;
				else
					j=j+1;
				if(this.getGame().getCellAt(i, j).getPiece()==null) {
					
					this.getGame().getCellAt(i, j).setPiece(target);
					if(target instanceof Armored)
						((Armored)target).setArmorUp(true);
					else if(target instanceof ActivatablePowerHero) 
						((ActivatablePowerHero)target).setPowerUsed(false);
					target.setPosI(i);
					target.setPosJ(j);
					this.getOwner().getDeadCharacters().remove(target);
					break;
					}
					else {
						throw new InvalidPowerTargetException("the target location is occupied", this, target);
					}
			case UPLEFT:
				if(i==0) {
					i=6;
				}
				else
					i=i-1;
				if(j==0)
					j=5;
				else
					j=j-1;
				
				
				if(this.getGame().getCellAt(i, j).getPiece()==null) {
					
					this.getGame().getCellAt(i, j).setPiece(target);
					if(target instanceof Armored)
						((Armored)target).setArmorUp(true);
					else if(target instanceof ActivatablePowerHero) 
						((ActivatablePowerHero)target).setPowerUsed(false);
					target.setPosI(i);
					target.setPosJ(j);
					this.getOwner().getDeadCharacters().remove(target);
					break;
					}
					else {
						throw new InvalidPowerTargetException("the target location is occupied", this, target);
					}
			case DOWNRIGHT:
					
				if(i==6)
					i=0;
				else
					i=i+1;
				if(j==5)
					j=0;
				else
					j=j+1;
					if(this.getGame().getCellAt(i, j).getPiece()==null) {
					
					this.getGame().getCellAt(i, j).setPiece(target);
					if(target instanceof Armored)
						((Armored)target).setArmorUp(true);
					else if(target instanceof ActivatablePowerHero) 
						((ActivatablePowerHero)target).setPowerUsed(false);
					target.setPosI(i);
					target.setPosJ(j);
					this.getOwner().getDeadCharacters().remove(target);
					break;
					}
					else {
						throw new InvalidPowerTargetException("the target location is occupied", this, target);
					}
			case DOWNLEFT:
				if(i==6)
					i=0;
				else
					i=i+1;
				if(j==0)
					j=5;
				else j=j-1;
				if(this.getGame().getCellAt(i, j).getPiece()==null) {
					
					this.getGame().getCellAt(i, j).setPiece(target);
					if(target instanceof Armored)
						((Armored)target).setArmorUp(true);
					else if(target instanceof ActivatablePowerHero) 
						((ActivatablePowerHero)target).setPowerUsed(false);
					target.setPosI(i);
					target.setPosJ(j);
					this.getOwner().getDeadCharacters().remove(target);
					break;
					}
					else {
						throw new InvalidPowerTargetException("the target location is occupied", this, target);
					}
			}
		
		
		
		
		this.setPowerUsed(true);
		this.getGame().switchTurns();
	
	}

	@Override
	public String toString() {
		if(this.getOwner()==this.getGame().getPlayer1())
			return "Green Lantern";
		else
			return"Vision";
	}
}
