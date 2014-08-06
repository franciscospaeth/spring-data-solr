package org.springframework.data.solr.core.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

public class SimpleGroupQuery extends SimpleQuery implements GroupQuery {

	private List<Function> groupByFunctions = new ArrayList<Function>(0);
	private List<Query> groupByQuery = new ArrayList<Query>(0);

	private Integer offset = null;
	private Integer rows = null;

	private Sort sort;

	private boolean groupCount = false;
	private Map<Object, String> queriedGroupObjectsToName = new HashMap<Object, String>();

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T addGroupByFunction(Function function) {
		Assert.notNull(function, "Function for grouping must not be null.");
		Assert.hasText(function.getOperation(), "Function.operation for grouping must not be null/empty.");

		groupByFunctions.add(function);

		return (T) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T addGroupByQuery(Query query) {
		Assert.notNull(query, "Query for grouping must not be null.");

		groupByQuery.add(query);

		return (T) this;
	}

	@Override
	public List<Function> getGroupByFunctions() {
		return groupByFunctions;
	}

	@Override
	public List<Query> getGroupByQueries() {
		return groupByQuery;
	}

	@Override
	public Integer getGroupOffset() {
		return offset;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T setGroupOffset(Integer offset) {
		this.offset = offset;
		return (T) this;
	}

	@Override
	public Integer getGroupRows() {
		return rows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T setGroupRows(Integer rows) {
		this.rows = rows;
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T addGroupSort(Sort sort) {
		if (sort == null) {
			return (T) this;
		}

		if (this.sort == null) {
			this.sort = sort;
		} else {
			this.sort = this.sort.and(sort);
		}

		return (T) this;
	}
	
	@Override
	public Sort getGroupSort() {
		return sort;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T setGroupTotalCount(boolean groupCount) {
		this.groupCount = groupCount;
		return (T) this;
	}

	@Override
	public boolean isGroupTotalCount() {
		return groupCount;
	}

	protected void setQueriedGroupObjectsToName(Map<Object, String> queriedGroupObjectsToName) {
		this.queriedGroupObjectsToName = queriedGroupObjectsToName;
	}

	protected Map<Object, String> getQueriedGroupObjectsToName() {
		return queriedGroupObjectsToName;
	}

}
