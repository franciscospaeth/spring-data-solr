package org.springframework.data.solr.core.query;

import java.util.List;

import org.springframework.data.domain.Sort;

public abstract class AbstractGroupQueryDecorator extends AbstractQueryDecorator implements GroupQuery {

	private GroupQuery query;

	public AbstractGroupQueryDecorator(GroupQuery query) {
		super(query);
		this.query = query;
	}

	public <T extends GroupQuery> T addGroupByFunction(Function function) {
		return this.query.addGroupByFunction(function);
	}

	public List<Function> getGroupByFunctions() {
		return this.query.getGroupByFunctions();
	}

	public <T extends GroupQuery> T addGroupByQuery(Query query) {
		return this.query.addGroupByQuery(query);
	}

	public List<Query> getGroupByQueries() {
		return this.query.getGroupByQueries();
	}

	public <T extends GroupQuery> T setGroupTotalCount(boolean groupCount) {
		return this.query.setGroupTotalCount(groupCount);
	}

	public boolean isGroupTotalCount() {
		return this.query.isGroupTotalCount();
	}

	public Integer getGroupOffset() {
		return query.getGroupOffset();
	}

	public <T extends GroupQuery> T setGroupOffset(Integer offset) {
		return query.setGroupOffset(offset);
	}

	public Integer getGroupRows() {
		return query.getGroupRows();
	}

	public <T extends GroupQuery> T setGroupRows(Integer rows) {
		return query.setGroupRows(rows);
	}

	public <T extends GroupQuery> T addGroupSort(Sort sort) {
		return query.addGroupSort(sort);
	}

	public Sort getGroupSort() {
		return query.getGroupSort();
	}

	
	
}
