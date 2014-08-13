package org.springframework.data.solr.core.query.result;

import org.springframework.data.solr.core.query.Field;
import org.springframework.data.solr.core.query.Function;
import org.springframework.data.solr.core.query.Query;

/**
 * Representation of a Group result page, holding one {@link GroupResult} for each grouping requested on a
 * {@link org.springframework.data.solr.core.query.GroupQuery}.
 * 
 * @author Francisco Spaeth
 * 
 * @param <T>
 */
public interface GroupPage<T> extends FacetPage<GroupResult<T>> {

	/**
	 * Get a group result done for the given {@link Field}.
	 * 
	 * @param field
	 * @return
	 */
	public GroupResult<T> getGroupResult(Field field);

	/**
	 * Get a group result done for the given {@link Function}.
	 * 
	 * @param function
	 * @return
	 */
	public GroupResult<T> getGroupResult(Function function);

	/**
	 * Get a group result done for the given {@link Query}.
	 * 
	 * @param query
	 * @return
	 */
	public GroupResult<T> getGroupResult(Query query);

	/**
	 * Get a group result with the given name.
	 * 
	 * @param name
	 * @return
	 */
	public GroupResult<T> getGroupResult(String name);

}
