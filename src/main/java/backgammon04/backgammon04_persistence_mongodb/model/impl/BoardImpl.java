package backgammon04.backgammon04_persistence_mongodb.model.impl;

import java.util.Set;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import backgammon04.model.Board;
import backgammon04.model.Game;
import backgammon04.model.Point;

@Document(collection = "board")
public class BoardImpl implements Board {

	@Id
	private long id;

	@DBRef
	@Field("game_id")
	private Game game;

	@DBRef
	@Field("points")
	private Set<Point> pointList;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public Set<Point> getPointList() {
		return pointList;
	}

	@Override
	public void setPointList(Set<Point> pointList) {
		this.pointList = pointList;
	}

}
