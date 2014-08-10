package org.springframework.data.solr.core.query.result;

import org.springframework.data.domain.Page;

/**
 * Representation of a group in response to group request (i.e.
 * {@link org.springframework.data.solr.core.query.GroupQuery#addGroupByField(org.springframework.data.solr.core.query.Field)},
 * {@link org.springframework.data.solr.core.query.GroupQuery#addGroupByFunction(org.springframework.data.solr.core.query.Function)},
 * {@link org.springframework.data.solr.core.query.GroupQuery#addGroupByQuery(org.springframework.data.solr.core.query.Query)}
 * ) will have a {@link GroupResult} representation.
 * 
 * @author Francisco Spaeth
 * 
 * @param <T>
 *            grouped content type
 * 
 * @since 1.3
 */
public interface GroupResult<T> {

	/**
	 * Matched documents for this group.
	 * 
	 * @return
	 */
	int getMatches();

	/**
	 * Groups count.
	 * 
	 * @return
	 */
	Integer getGroupsCount();

	/**
	 * Grouping result name.
	 * 
	 * @return
	 */
	String getName();

	/**
	 * Group entries.
	 * 
	 * @see GroupEntry
	 * 
	 * @return
	 */
	Page<GroupEntry<T>> getGroupEntries();

}
