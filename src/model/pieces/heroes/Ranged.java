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

public class Ranged extends ActivatablePowerHero {

	public Ranged(Player player, Game game, String name) {
		super(player, game, name);
	}

	@Override
	public void  usePower(Direction d, Piece target, Point newPos) throws WrongTurnException, UnallowedMovementException, InvalidPowerUseException {
		super.usePower(d, target, newPos);
		switch(d) {
		case LEFT:
			for(int j=this.getPosJ()-1;j>=0;j--) {
				if(this.getGame().getCellAt(this.getPosI(), j).getPiece()==null) {
					continue;
				}
				else if(this.getGame().getCellAt(this.getPosI(), j).getPiece().getOwner()==this.getOwner()) {
					throw new InvalidPowerDirectionException("this direction will result in hitting a friendly piece", this, d);
				}
				else {
					this.attack(this.getGame().getCellAt(this.getPosI(), j).getPiece());
					this.setPowerUsed(true);
					this.getGame().switchTurns();
					return;
				}
				
			}
			throw new InvalidPowerDirectionException("this direction will result in hitting no enemies.", this, d);
			
			
			
			
			
			
		case RIGHT:
			for(int j=this.getPosJ()+1;j<6;j++) {
				if(this.getGame().getCellAt(this.getPosI(), j).getPiece()==null) {
					continue;
				}
				else if(this.getGame().getCellAt(this.getPosI(), j).getPiece().getOwner()==this.getOwner()) {
					throw new InvalidPowerDirectionException("this direction will result in hitting a friendly piece", this, d);
				}
				else {
					this.attack(this.getGame().getCellAt(this.getPosI(), j).getPiece());
					this.setPowerUsed(true);
					this.getGame().switchTurns();
					return;
				}
				
			}
			throw new InvalidPowerDirectionException("this direction will result in hitting no enemies.", this, d);
		case UP:
			for(int i=this.getPosI()-1;i>=0;i--) {
				if(this.getGame().getCellAt(i,this.getPosJ()).getPiece()==null) {
					continue;
				}
				else if(this.getGame().getCellAt(i, this.getPosJ()).getPiece().getOwner()==this.getOwner()) {
					throw new InvalidPowerDirectionException("this direction will result in hitting a friendly piece", this, d);
				}
				else {
					this.attack(this.getGame().getCellAt(i, this.getPosJ()).getPiece());
					this.setPowerUsed(true);
					this.getGame().switchTurns();
					return;
				}
				
			}
			throw new InvalidPowerDirectionException("this direction will result in hitting no enemies.", this, d);
		case DOWN:
			for(int i=this.getPosI()+1;i<7;i++) {
				if(this.getGame().getCellAt(i,this.getPosJ()).getPiece()==null) {
					continue;
				}
				else if(this.getGame().getCellAt(i, this.getPosJ()).getPiece().getOwner()==this.getOwner()) {
					throw new InvalidPowerDirectionException("this direction will result in hitting a friendly piece", this, d);
				}
				else {
					this.attack(this.getGame().getCellAt(i, this.getPosJ()).getPiece());
					this.setPowerUsed(true);
					this.getGame().switchTurns();
					return;
				}
				
			}
			throw new InvalidPowerDirectionException("this direction will result in hitting no enemies.", this, d);
		default: throw new InvalidPowerDirectionException("this direction is not allowed", this, d);
		}
		
		
		
		
	}

	@Override
	public String toString() {
		if(this.getOwner()==this.getGame().getPlayer1())
			return "Green Arrow";
		else
			return"Hawk Eye";
	}
}
