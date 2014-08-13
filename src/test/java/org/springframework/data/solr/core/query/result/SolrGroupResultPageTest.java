package org.springframework.data.solr.core.query.result;

import java.util.Collections;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.query.Field;
import org.springframework.data.solr.core.query.Function;
import org.springframework.data.solr.core.query.Query;

public class SolrGroupResultPageTest {

	@Test
	public void testGetGroupResultField() {
		@SuppressWarnings("unchecked")
		GroupResult<Object> gr = new SimpleGroupResult<Object>(1, null, "name", Mockito.mock(Page.class));

		Field field = Mockito.mock(Field.class);
		Mockito.when(field.getName()).thenReturn("name");

		Map<Object, String> objectsName = Collections.<Object, String> singletonMap(field, "name");

		SolrGroupResultPage<Object> result = new SolrGroupResultPage<Object>(Collections.singletonList(gr), objectsName);

		Assert.assertEquals(gr, result.getGroupResult(field));
		Assert.assertEquals(gr, result.getGroupResult("name"));
	}

	@Test
	public void testGetGroupResultFunction() {
		@SuppressWarnings("unchecked")
		GroupResult<Object> gr = new SimpleGroupResult<Object>(1, null, "name", Mockito.mock(Page.class));

		Function func = Mockito.mock(Function.class);

		Map<Object, String> objectsName = Collections.<Object, String> singletonMap(func, "name");

		SolrGroupResultPage<Object> result = new SolrGroupResultPage<Object>(Collections.singletonList(gr), objectsName);

		Assert.assertEquals(gr, result.getGroupResult(func));
	}

	@Test
	public void testGetGroupResultQuery() {
		@SuppressWarnings("unchecked")
		GroupResult<Object> gr = new SimpleGroupResult<Object>(1, null, "name", Mockito.mock(Page.class));

		Query query = Mockito.mock(Query.class);

		Map<Object, String> objectsName = Collections.<Object, String> singletonMap(query, "name");

		SolrGroupResultPage<Object> result = new SolrGroupResultPage<Object>(Collections.singletonList(gr), objectsName);

		Assert.assertEquals(gr, result.getGroupResult(query));
	}

	@Test
	public void testGetGroupResultString() {
		@SuppressWarnings("unchecked")
		GroupResult<Object> gr = new SimpleGroupResult<Object>(1, null, "name", Mockito.mock(Page.class));

		SolrGroupResultPage<Object> result = new SolrGroupResultPage<Object>(Collections.singletonList(gr),
				Collections.<Object, String> emptyMap());

		Assert.assertEquals(gr, result.getGroupResult("name"));
	}

	@Test
	public void testInexistentGroupResult() {
		SolrGroupResultPage<Object> result = new SolrGroupResultPage<Object>(Collections.<GroupResult<Object>>emptyList(),
				Collections.<Object, String> emptyMap());

		Assert.assertNull(result.getGroupResult("name"));
		Assert.assertNull(result.getGroupResult(Mockito.mock(Query.class)));
		Assert.assertNull(result.getGroupResult(Mockito.mock(Field.class)));
		Assert.assertNull(result.getGroupResult(Mockito.mock(Function.class)));
	}

}
