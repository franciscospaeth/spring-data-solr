package org.springframework.data.solr.core.query;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface GroupQuery extends Query {

	<T extends GroupQuery> T addGroupByFunction(Function function);
	
	List<Function> getGroupByFunctions();

	<T extends GroupQuery> T addGroupByQuery(Query query);
	
	List<Query> getGroupByQueries();

	<T extends GroupQuery> T setGroupTotalCount(boolean groupCount);
	
	boolean isGroupTotalCount();

	Integer getGroupOffset();

	<T extends GroupQuery> T setGroupOffset(Integer offset);

	Integer getGroupRows();

	<T extends GroupQuery> T setGroupRows(Integer rows);

	<T extends GroupQuery> T addGroupSort(Sort sort);

	Sort getGroupSort();
	
}
