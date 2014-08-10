package org.springframework.data.solr.core.query;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

public class SimpleGroupQuery extends SimpleFacetQuery implements GroupQuery {

	private List<Function> groupByFunctions = new ArrayList<Function>(0);
	private List<Query> groupByQuery = new ArrayList<Query>(0);

	private Integer offset = null;
	private Integer limit = null;

	private Sort sort;

	private boolean groupCount = false;
	private int cachePercent = DEFAULT_CACHE_PERCENT;

	public SimpleGroupQuery() {
		super();
	}

	public SimpleGroupQuery(Criteria criteria, Pageable pageable) {
		super(criteria, pageable);
	}

	public SimpleGroupQuery(Criteria criteria) {
		super(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T addGroupByFunction(Function function) {
		Assert.notNull(function, "Function for grouping must not be null.");
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
		return limit;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T setGroupLimit(Integer limit) {
		this.limit = limit;
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

	@SuppressWarnings("unchecked")
	@Override
	public <T extends GroupQuery> T setCachePercent(int cachePercent) {
		this.cachePercent = cachePercent;
		return (T) this;
	}

	@Override
	public int getCachePercent() {
		return cachePercent;
	}

	@Override
	@Deprecated
	public Pageable getGroupPageRequest() {

		if (this.limit == null && this.offset == null) {
			return null;
		}

		int rows = this.limit != null ? this.limit : DEFAULT_GROUP_LIMIT;
		int offset = this.offset != null ? this.offset : 0;

		return new SolrPageRequest(rows != 0 ? offset / rows : 0, rows, this.sort);
	}

}
