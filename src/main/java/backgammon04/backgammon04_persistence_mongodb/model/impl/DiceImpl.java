package backgammon04.backgammon04_persistence_mongodb.model.impl;

import java.util.Date;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import backgammon04.backgammon04_persistence_interface.model.Dice;
import backgammon04.backgammon04_persistence_interface.model.Movement;
import backgammon04.backgammon04_persistence_mongodb.util.JsonDateSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection = "dice")
public class DiceImpl implements Dice {

	@Id
	private long id;

	private byte value;

	@DBRef
	@Field("movement_id")
	private Movement movement;

	private boolean played;

	@JsonSerialize(using = JsonDateSerializer.class)
	@Field("play_time")
	private Date playTime;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public byte getValue() {
		return value;
	}

	@Override
	public void setValue(byte value) {
		this.value = value;
	}

	@Override
	public Movement getMovement() {
		return movement;
	}

	@Override
	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	@Override
	public boolean isPlayed() {
		return played;
	}

	@Override
	public void setPlayed(boolean played) {
		this.played = played;
	}

	@Override
	public Date getPlayTime() {
		return playTime;
	}

	@Override
	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}
}
