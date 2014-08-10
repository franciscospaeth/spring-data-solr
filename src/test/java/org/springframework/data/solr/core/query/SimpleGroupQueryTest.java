package org.springframework.data.solr.core.query;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class SimpleGroupQueryTest {

	@Test
	public void testAddGroupByFunction() {
		Function f1 = Mockito.mock(Function.class);
		Function f2 = Mockito.mock(Function.class);

		SimpleGroupQuery simpleGroupQuery = new SimpleGroupQuery();
		
		simpleGroupQuery.addGroupByFunction(f1);
		simpleGroupQuery.addGroupByFunction(f2);
		
		Assert.assertArrayEquals(new Function[] {f1, f2}, simpleGroupQuery.getGroupByFunctions().toArray());
	}

	@Test
	public void testAddGroupByQuery() {
		Query q1 = Mockito.mock(Query.class);
		Query q2 = Mockito.mock(Query.class);
		
		SimpleGroupQuery simpleGroupQuery = new SimpleGroupQuery();
		
		simpleGroupQuery.addGroupByQuery(q1);
		simpleGroupQuery.addGroupByQuery(q2);
		
		Assert.assertArrayEquals(new Query[] {q1, q2}, simpleGroupQuery.getGroupByQueries().toArray());
	}

	@Test
	public void testSetGroupTotalCount() {
		SimpleGroupQuery simpleGroupQuery = new SimpleGroupQuery();
		
		Assert.assertFalse(simpleGroupQuery.isGroupTotalCount());
		
		simpleGroupQuery.setGroupTotalCount(true);
		
		Assert.assertTrue(simpleGroupQuery.isGroupTotalCount());
	}

	@Test
	public void testGetGroupPageRequest() {
		SimpleGroupQuery simpleGroupQuery = new SimpleGroupQuery();
		Assert.assertNull(simpleGroupQuery.getGroupPageRequest());
		
		simpleGroupQuery.setGroupOffset(1);
		assertPageable(simpleGroupQuery.getGroupPageRequest(), 1, 1, null);
	}

	@Test
	public void testGetGroupPageRequestWithSort() {
		SimpleGroupQuery simpleGroupQuery = new SimpleGroupQuery();
		simpleGroupQuery.setGroupOffset(1);
		Sort sort = new Sort("field_1");
		simpleGroupQuery.addGroupSort(sort);
		assertPageable(simpleGroupQuery.getGroupPageRequest(), 1, 1, sort);
	}

	@Test
	public void testGetGroupPageRequestWithLimit() {
		SimpleGroupQuery simpleGroupQuery = new SimpleGroupQuery();
		simpleGroupQuery.setGroupLimit(10);
		assertPageable(simpleGroupQuery.getGroupPageRequest(), 0, 10, null);
	}

	private void assertPageable(Pageable groupPageRequest, int offset, int limit, Sort sort) {
		Assert.assertEquals(offset, groupPageRequest.getOffset());
		Assert.assertEquals(limit, groupPageRequest.getPageSize());
		Assert.assertEquals(sort, groupPageRequest.getSort());
	}

}