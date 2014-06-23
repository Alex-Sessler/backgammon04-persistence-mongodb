package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import java.util.Date;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import backgammon04.backgammon04_persistence_mongodb.model.impl.CheckerImpl;
import backgammon04.model.Checker;
import backgammon04.model.dao.CheckerDao;

@Repository
public class CheckerDaoImpl extends AbstractMongoDao implements CheckerDao {

	@Override
	public void save(Checker checker) {
		if (!getMongoTemplate().collectionExists(CheckerImpl.class)) {
			getMongoTemplate().createCollection(CheckerImpl.class);
		}
		if (checker.getId() == 0) {
			checker.setId(new Date().getTime());
		}
		getMongoTemplate().save(checker);

	}

	@Override
	public Checker get(long id) {
		return getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), CheckerImpl.class);
	}

	@Override
	public void delete(Checker checker) {
		getMongoTemplate().remove(checker);

	}

}
