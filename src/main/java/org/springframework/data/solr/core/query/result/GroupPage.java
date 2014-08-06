package org.springframework.data.solr.core.query.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.solr.core.query.Field;
import org.springframework.data.solr.core.query.Function;
import org.springframework.data.solr.core.query.Query;

public class GroupPage<T> extends PageImpl<GroupResult<T>> {

	private static final long serialVersionUID = 1L;
	private Map<String, GroupResult<T>> resultMap;
	private Map<Object, String> objectsName;

	public GroupPage(List<GroupResult<T>> content, Map<Object, String> objectsName) {
		super(content);
		resultMap = new HashMap<String, GroupResult<T>>();
		for (GroupResult<T> gr : content) {
			resultMap.put(gr.getName(), gr);
		}
		this.objectsName = objectsName;
	}
	
	public GroupResult<T> getGroupResult(Field field) {
		return resultMap.get(field.getName());
	}
	
	public GroupResult<T> getGroupResult(Function function) {
		return resultMap.get(objectsName.get(function));
	}
	
	public GroupResult<T> getGroupResult(Query query) {
		return resultMap.get(objectsName.get(query));
	}
	
}
