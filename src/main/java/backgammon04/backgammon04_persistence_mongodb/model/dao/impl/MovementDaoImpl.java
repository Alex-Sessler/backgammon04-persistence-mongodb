package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import backgammon04.backgammon04_persistence_mongodb.model.impl.MovementImpl;
import backgammon04.model.Game;
import backgammon04.model.Movement;
import backgammon04.model.Player;
import backgammon04.model.dao.MovementDao;

@Repository("mongoMovementDao")
public class MovementDaoImpl extends AbstractMongoDao implements MovementDao {

	@Override
	public void save(Movement movement) {
		if (!getMongoTemplate().collectionExists(MovementImpl.class)) {
			getMongoTemplate().createCollection(MovementImpl.class);
		}
		getMongoTemplate().insert(movement);

	}

	@Override
	public Movement get(long id) {
		Movement movement = getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), MovementImpl.class);
		return movement;
	}

	@Override
	public void delete(Movement movement) {
		getMongoTemplate().remove(movement);
	}

	@Override
	public Movement get(Game game, Player player) {
		Movement movement = getMongoTemplate().findOne(
				new Query(Criteria.where("game_id").is(game)).addCriteria(
						Criteria.where("player_id").is(player)).with(
						new Sort(Sort.Direction.DESC, "id")),
				MovementImpl.class);
		return movement;
	}

	@Override
	public Movement getLast(Game game) {
		Movement movement = getMongoTemplate().findOne(
				new Query(Criteria.where("game_id").is(game))
						.addCriteria(Criteria.where("targetPoint_id").ne(null))
						.addCriteria(Criteria.where("checker_id").ne(null))
						.with(new Sort(Sort.Direction.DESC, "id")),
				MovementImpl.class);
		return movement;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Movement> getLast(Game game, int lastSize) {
		List<MovementImpl> result = getMongoTemplate().find(
				new Query(Criteria.where("game_id").is(game)).with(
						new Sort(Sort.Direction.DESC, "id")).limit(lastSize),
				MovementImpl.class);
		return (List<Movement>) (List<?>) result;
	}
}
