package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import backgammon04.backgammon04_persistence_mongodb.model.impl.GameImpl;
import backgammon04.model.Game;
import backgammon04.model.User;
import backgammon04.model.dao.GameDao;

@Repository("mongoGameDao")
public class GameDaoImpl extends AbstractMongoDao implements GameDao {

	@Override
	public void save(Game game) {
		if (!getMongoTemplate().collectionExists(GameImpl.class)) {
			getMongoTemplate().createCollection(GameImpl.class);
		}
		getMongoTemplate().save(game);
	}

	@Override
	public Game get(long id) {
		return getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), GameImpl.class);
	}

	@Override
	public void delete(Game game) {
		getMongoTemplate().remove(game);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getOpenGames() {
		List<GameImpl> openGames = getMongoTemplate()
				.find(new Query(Criteria.where("ended").is(null)).addCriteria(Criteria
						.where("started").is(null)), GameImpl.class);
		return (List<Game>) (List<?>) openGames;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getOpenGames(User user) {
		List<GameImpl> openGames = getMongoTemplate().find(
				new Query(Criteria.where("user_id").is(user)).addCriteria(
						Criteria.where("ended").is(null)).addCriteria(
						Criteria.where("started").is(null)), GameImpl.class);
		return (List<Game>) (List<?>) openGames;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> getMyGames(User user) {
		List<GameImpl> openGames = getMongoTemplate().find(
				new Query(Criteria.where("user_id").is(user)), GameImpl.class);
		return (List<Game>) (List<?>) openGames;
	}

}
