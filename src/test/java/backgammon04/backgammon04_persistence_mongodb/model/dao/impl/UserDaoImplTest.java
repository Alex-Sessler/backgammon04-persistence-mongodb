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
		user.setEmail("alex@alex.de");
		user.setPassword("alex");
		user.setUsername("alex");
		userDao.save(user);
		System.out.println(userDao);
		User dbUser = userDao.getUser("alex");
		Assert.assertNotNull(dbUser);

		userDao.delete(dbUser);
		Assert.assertNull(userDao.getUser("alex"));
	}

}
