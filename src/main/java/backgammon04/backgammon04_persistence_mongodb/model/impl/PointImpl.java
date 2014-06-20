package backgammon04.backgammon04_persistence_mongodb.model.impl;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import backgammon04.model.Board;
import backgammon04.model.Checker;
import backgammon04.model.Point;

@Document(collection = "point")
public class PointImpl implements Point {

	@Id
	private long id;

	@Field("intern_id")
	private byte internId;

	@DBRef
	@Field("board_id")
	private Board board;

	@DBRef
	@Field("checkers")
	private Set<Checker> checkerList;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public byte getInternId() {
		return internId;
	}

	@Override
	public void setInternId(byte internId) {
		this.internId = internId;
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
	public Set<Checker> getCheckerList() {
		return checkerList;
	}

	@Override
	public void setCheckerList(Set<Checker> checkerList) {
		this.checkerList = checkerList;
	}

}
