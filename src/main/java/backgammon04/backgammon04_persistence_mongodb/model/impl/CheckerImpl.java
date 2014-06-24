package backgammon04.backgammon04_persistence_mongodb.model.impl;

import javax.persistence.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import backgammon04.backgammon04_persistence_interface.model.Checker;
import backgammon04.backgammon04_persistence_interface.model.Player;
import backgammon04.backgammon04_persistence_interface.model.Point;

@Document(collection = "checker")
public class CheckerImpl implements Checker {

	@Id
	@Column(name = "checker_id")
	private long id;

	private byte internId;

	@DBRef
	@Field("player_id")
	private Player player;

	@DBRef
	@Field("point_id")
	private Point point;

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
	public Player getPlayer() {
		return player;
	}

	@Override
	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public Point getPoint() {
		return point;
	}

	@Override
	public void setPoint(Point point) {
		this.point = point;
	}
}
