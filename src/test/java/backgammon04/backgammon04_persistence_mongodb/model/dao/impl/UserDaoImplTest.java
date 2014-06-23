package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import backgammon04.backgammon04_persistence_mongodb.model.impl.UserImpl;
import backgammon04.model.User;
import backgammon04.model.dao.UserDao;

@Ignore
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class UserDaoImplTest {

	@Autowired
	private UserDao userDao;

	@After
	public void tearDown() {
		User dbUser = userDao.getUser("alex");
		if (dbUser != null) {
			userDao.delete(dbUser);
		}
	}

	@Test
	public void test() {
		User user = new UserImpl();

		user.setEmail("alex2@alex.de");
		user.setPassword("alex2");
		user.setUsername("alex2");
		userDao.save(user);
		User dbUser = userDao.getUser("alex2");
		Assert.assertNotNull(dbUser);

		User user2 = new UserImpl();
		user2.setEmail("alex@alex2.de");
		user2.setPassword("alex2");
		user2.setUsername("alex2");
		userDao.save(user2);
		User dbUser2 = userDao.getUser("alex2");

		userDao.delete(dbUser);
		Assert.assertNull(userDao.getUser("alex"));
	}

	@Test
	public void createMultiple() {
		for (int i = 0; i < 10; i++) {
			User user = new UserImpl();
			user.setId(Long.valueOf(i));
			user.setEmail("alex@alex" + i + ".de");
			user.setPassword("alex" + i);
			user.setUsername("alex" + i);
			userDao.save(user);
		}

		for (int i = 0; i < 10; i++) {
			User user = userDao.getUser("alex" + i);
			userDao.delete(user);
		}
	}

}
