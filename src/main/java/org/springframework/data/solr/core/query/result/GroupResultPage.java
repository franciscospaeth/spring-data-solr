package org.springframework.data.solr.core.query.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.solr.core.query.Field;
import org.springframework.data.solr.core.query.Function;
import org.springframework.data.solr.core.query.Query;
import org.springframework.util.Assert;

/**
 * Implementation for solr group result page.
 * 
 * @author Francisco Spaeth
 *
 * @param <T>
 */
public class GroupResultPage<T> extends PageImpl<GroupResult<T>> {

	private static final long serialVersionUID = 1L;
	private Map<String, GroupResult<T>> resultMap;
	private Map<Object, String> objectsName;

	public GroupResultPage(List<GroupResult<T>> content, Map<Object, String> objectsName) {
		super(content);
		resultMap = new HashMap<String, GroupResult<T>>();
		for (GroupResult<T> gr : content) {
			resultMap.put(gr.getName(), gr);
		}
		this.objectsName = objectsName;
	}
	
	public GroupResult<T> getGroupResult(Field field) {
		Assert.notNull(field, "group result field must not be null");
		return resultMap.get(field.getName());
	}
	
	public GroupResult<T> getGroupResult(Function function) {
		Assert.notNull(function, "group result function must not be null");
		return resultMap.get(objectsName.get(function));
	}
	
	public GroupResult<T> getGroupResult(Query query) {
		Assert.notNull(query, "group result query must not be null");
		return resultMap.get(objectsName.get(query));
	}
	
	public GroupResult<T> getGroupResult(String name) {
		Assert.notNull(name, "group result name must not be null");
		return resultMap.get(name);
	}
	
}
