package backgammon04.backgammon04_persistence_mongodb.model.impl;

import java.util.Date;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import backgammon04.backgammon04_persistence_interface.model.Checker;
import backgammon04.backgammon04_persistence_interface.model.Dice;
import backgammon04.backgammon04_persistence_interface.model.Game;
import backgammon04.backgammon04_persistence_interface.model.Movement;
import backgammon04.backgammon04_persistence_interface.model.Player;
import backgammon04.backgammon04_persistence_interface.model.Point;
import backgammon04.backgammon04_persistence_mongodb.util.JsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection = "movement")
public class MovementImpl implements Movement {

	@Id
	private long id;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date created;

	@DBRef
	@Field("game_id")
	private Game game;

	@DBRef
	@Field("player_id")
	private Player player;

	@DBRef
	@Field("checker_id")
	private Checker checker;

	@DBRef
	@Field("targetPoint_id")
	private Point targetPoint;

	@DBRef
	private Set<Dice> dices;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public Date getCreated() {
		return created;
	}

	@Override
	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public Player getPlayer() {
		return player;
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public Checker getChecker() {
		return checker;
	}

	@Override
	public void setChecker(Checker checker) {
		this.checker = checker;
	}

	@Override
	public Point getTargetPoint() {
		return targetPoint;
	}

	@Override
	public void setTargetPoint(Point targetPoint) {
		this.targetPoint = targetPoint;
	}

	@Override
	public Set<Dice> getDices() {
		return dices;
	}

	@Override
	public void setDices(Set<Dice> dices) {
		this.dices = dices;
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
	}

}
