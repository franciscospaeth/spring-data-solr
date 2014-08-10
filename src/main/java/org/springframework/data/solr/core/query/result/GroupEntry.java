package org.springframework.data.solr.core.query.result;

import org.springframework.data.domain.Page;

/**
 * Representation of a group in a {@link GroupResult}.
 * 
 * @author Francisco Spaeth
 * 
 * @param <T>
 *            result content type
 */
public interface GroupEntry<T> {

	/**
	 * Group name, the value on which the results were grouped by.
	 * 
	 * @return
	 */
	String getGroupValue();

	/**
	 * Results for the current group.
	 * 
	 * @return
	 */
	Page<T> getResult();

}
