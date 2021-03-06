package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import java.util.Date;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import backgammon04.backgammon04_persistence_interface.model.Board;
import backgammon04.backgammon04_persistence_interface.model.dao.BoardDao;
import backgammon04.backgammon04_persistence_mongodb.model.impl.BoardImpl;

@Repository
public class BoardDaoImpl extends AbstractMongoDao implements BoardDao {

	@Override
	public void save(Board board) {
		if (!getMongoTemplate().collectionExists(BoardImpl.class)) {
			getMongoTemplate().createCollection(BoardImpl.class);
		}
		if (board.getId() == 0) {
			board.setId(new Date().getTime());
		}
		getMongoTemplate().save(board);

	}

	@Override
	public Board get(long id) {

		return getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(id)), BoardImpl.class);
	}

	@Override
	public void delete(Board board) {
		getMongoTemplate().remove(board);
	}

}
