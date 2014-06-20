package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import backgammon04.backgammon04_persistence_mongodb.model.impl.PlayerImpl;
import backgammon04.model.Game;
import backgammon04.model.Player;
import backgammon04.model.User;
import backgammon04.model.dao.PlayerDao;
import backgammon04.util.Color;

@Repository
public class PlayerDaoImpl extends AbstractMongoDao implements PlayerDao {

	@Override
	public void save(Player player) {
		if (!getMongoTemplate().collectionExists(PlayerImpl.class)) {
			getMongoTemplate().createCollection(PlayerImpl.class);
		}
		getMongoTemplate().insert(player);
	}

	@Override
	public Player get(long id) {
		Player player = getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), PlayerImpl.class);
		return player;
	}

	@Override
	public void delete(Player player) {
		getMongoTemplate().remove(player);
	}

	@Override
	public Player get(Game game, Color color) {
		Player player = getMongoTemplate()
				.findOne(
						new Query(Criteria.where("game_id").is(game)).addCriteria(Criteria
								.where("color").is(color)), PlayerImpl.class);

		return player;
	}

	@Override
	public Player get(Game game, User user) {
		Player player = getMongoTemplate()
				.findOne(
						new Query(Criteria.where("game_id").is(game)).addCriteria(Criteria
								.where("user_id").is(user)), PlayerImpl.class);

		return player;
	}

}
