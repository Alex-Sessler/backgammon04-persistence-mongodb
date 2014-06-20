package backgammon04.backgammon04_persistence_mongodb.model.dao.impl;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import backgammon04.model.dao.DiceDao;

@Ignore
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class DiceDaoImplTest {

	@Autowired
	private DiceDao diceDao;

	@Test
	public void test() {
		Assert.assertNotNull(diceDao);
	}

}
