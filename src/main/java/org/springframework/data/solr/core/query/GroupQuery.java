package org.springframework.data.solr.core.query;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Query request to get a grouped response.
 * 
 * @author Francisco Spaeth
 * 
 * @since 1.3
 * 
 */
public interface GroupQuery extends FacetQuery {

	int DEFAULT_GROUP_LIMIT = 1;
	int DEFAULT_CACHE_PERCENT = 0;

	/**
	 * Adds a group by function request.
	 * 
	 * @param function
	 * @return
	 */
	<T extends GroupQuery> T addGroupByFunction(Function function);

	/**
	 * @return all group by function request.
	 */
	List<Function> getGroupByFunctions();

	/**
	 * Adds a group by query request.
	 * 
	 * @param query
	 * @return
	 */
	<T extends GroupQuery> T addGroupByQuery(Query query);

	/**
	 * @return all group by query requests.
	 */
	List<Query> getGroupByQueries();

	/**
	 * Defines if response should hold total count of groups for each
	 * {@link org.springframework.data.solr.core.query.result.GroupResult}
	 * 
	 * @param groupCount
	 * @return
	 */
	<T extends GroupQuery> T setGroupTotalCount(boolean groupCount);

	/**
	 * @return if response shall hold total count of groups for each
	 *         {@link org.springframework.data.solr.core.query.result.GroupResult}.
	 */
	boolean isGroupTotalCount();

	/**
	 * Set the number of rows to skip in each {@link org.springframework.data.solr.core.query.result.GroupEntry}
	 * 
	 * @param offset
	 * @return
	 */
	<T extends GroupQuery> T setGroupOffset(Integer offset);

	/**
	 * @return number of rows to skip in each {@link org.springframework.data.solr.core.query.result.GroupEntry}
	 */
	Integer getGroupOffset();

	/**
	 * Set the number of rows to be presented in each {@link org.springframework.data.solr.core.query.result.GroupEntry}
	 * 
	 * @param rows
	 * @return
	 */
	<T extends GroupQuery> T setGroupLimit(Integer rows);

	/**
	 * @return number of rows to be presented in each {@link org.springframework.data.solr.core.query.result.GroupEntry}
	 */
	Integer getGroupRows();

	/**
	 * Add sort constraint to group query to sort the group content.
	 * 
	 * @param sort
	 * @return
	 */
	<T extends GroupQuery> T addGroupSort(Sort sort);

	/**
	 * @return the group query sort constraints.
	 */
	Sort getGroupSort();

	/**
	 * Enables caching for grouping result.
	 * 
	 * @param cachePercent
	 * @return
	 */
	<T extends GroupQuery> T setCachePercent(int cachePercent);

	/**
	 * @return percent of caching for grouping result.
	 */
	int getCachePercent();

	/**
	 * Returns a {@link Pageable} object representing group request.
	 * 
	 * @return
	 */
	@Deprecated
	Pageable getGroupPageRequest();

}