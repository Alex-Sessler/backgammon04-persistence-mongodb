package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import java.util.Date;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import backgammon04.backgammon04_persistence_interface.model.Board;
import backgammon04.backgammon04_persistence_interface.model.Point;
import backgammon04.backgammon04_persistence_interface.model.dao.PointDao;
import backgammon04.backgammon04_persistence_mongodb.model.impl.PointImpl;

@Repository
public class PointDaoImpl extends AbstractMongoDao implements PointDao {

	@Override
	public void save(Point point) {
		if (!getMongoTemplate().collectionExists(PointImpl.class)) {
			getMongoTemplate().createCollection(PointImpl.class);
		}
		if (point.getId() == 0) {
			point.setId(new Date().getTime());
		}
		getMongoTemplate().save(point);
	}

	@Override
	public Point get(long id) {
		Point point = getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), PointImpl.class);
		return point;
	}

	@Override
	public void delete(Point point) {
		getMongoTemplate().remove(point);
	}

	@Override
	public Point get(Board board, byte internId) {
		Point point = getMongoTemplate()
				.findOne(
						new Query(Criteria.where("intern_id").is(internId)).addCriteria(Criteria
								.where("game_id").is(board.getGame())),
						PointImpl.class);
		return point;
	}

}
