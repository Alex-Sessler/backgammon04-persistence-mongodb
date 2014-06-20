package backgammon04.backgammon04_persistence_mongodb.model.impl;

import java.util.Date;
import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import backgammon04.backgammon04_persistence_mongodb.util.JsonDateSerializer;
import backgammon04.model.Board;
import backgammon04.model.Game;
import backgammon04.model.Movement;
import backgammon04.model.Player;
import backgammon04.util.Color;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection = "game")
public class GameImpl implements Game {

	@Id
	private long id;

	@DBRef
	private Set<Player> players;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date initialized;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date started;

	@JsonSerialize(using = JsonDateSerializer.class)
	private Date ended;

	@DBRef
	@Field("board_id")
	private Board board;

	@DBRef
	@Field("movements")
	private Set<Movement> movementList;

	private Color color;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public Date getStarted() {
		return started;
	}

	@Override
	public void setStarted(Date started) {
		this.started = started;
	}

	@Override
	public Date getInitialized() {
		return initialized;
	}

	@Override
	public void setInitialized(Date initialized) {
		this.initialized = initialized;
	}

	@Override
	public Board getBoard() {
		return board;
	}

	@Override
	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public Set<Movement> getMovementList() {
		return movementList;
	}

	@Override
	public void setMovementList(Set<Movement> movementList) {
		this.movementList = movementList;
	}

	@Override
	public Set<Player> getPlayers() {
		return players;
	}

	@Override
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public Date getEnded() {
		return ended;
	}

	@Override
	public void setEnded(Date ended) {
		this.ended = ended;
	}

}
