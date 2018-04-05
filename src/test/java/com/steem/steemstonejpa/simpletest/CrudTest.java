package com.steem.steemstonejpa.simpletest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.steem.steemstonejpa.models.Unit;
import com.steem.steemstonejpa.repositories.UnitRepository;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SteemstoneJpaApplication.class)
public class CrudTest {

	@Autowired 
	private UnitRepository unitRepository;
	
	private List<Unit> unit;
	
	@Before
    public void setUp() throws Exception {
        unit = unitRepository.findByNameIgnoreCase("wizard");
    }

	@Test
    public void testFind() throws Exception {
        List<Unit> findUnit = unitRepository.findByName("Wizard");
        assertEquals(findUnit.get(0).getName(), unit.get(0).getName());
    }
	
	
}
