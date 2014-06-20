package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import backgammon04.backgammon04_persistence_mongodb.model.impl.DiceImpl;
import backgammon04.model.Dice;
import backgammon04.model.dao.DiceDao;

@Repository("mongoDiceDao")
public class DiceDaoImpl extends AbstractMongoDao implements DiceDao {

	@Override
	public void save(Dice dice) {
		if (!getMongoTemplate().collectionExists(DiceImpl.class)) {
			getMongoTemplate().createCollection(DiceImpl.class);
		}
		getMongoTemplate().save(dice);

	}

	@Override
	public Dice get(long id) {
		return getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), DiceImpl.class);
	}

	@Override
	public void delete(Dice dice) {
		getMongoTemplate().remove(dice);

	}

}
