package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import java.util.Date;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import backgammon04.backgammon04_persistence_mongodb.model.impl.UserImpl;
import backgammon04.model.User;
import backgammon04.model.dao.UserDao;

@Repository
public class UserDaoImpl extends AbstractMongoDao implements UserDao {

	@Override
	public void save(User user) {
		if (!getMongoTemplate().collectionExists(UserImpl.class)) {
			getMongoTemplate().createCollection(UserImpl.class);
		}
		if (user.getId() == null || user.getId().longValue() == 0) {
			user.setId(new Date().getTime());
		}
		getMongoTemplate().insert(user);
	}

	@Override
	public User get(long id) {
		User user = getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), UserImpl.class);
		return user;
	}

	@Override
	public User getUser(String username) {
		User user = getMongoTemplate().findOne(
				new Query(Criteria.where("username").is(username)),
				UserImpl.class);
		return user;
	}

	@Override
	public User getByEmail(String email) {
		User user = getMongoTemplate().findOne(
				new Query(Criteria.where("email").is(email)), UserImpl.class);
		return user;
	}

	@Override
	public void delete(User user) {
		getMongoTemplate().remove(user);
	}

}
