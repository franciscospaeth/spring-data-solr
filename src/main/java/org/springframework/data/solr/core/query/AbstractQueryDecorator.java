package org.springframework.data.solr.core.query;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.Assert;

public abstract class AbstractQueryDecorator implements Query {

	private Query query;

	public AbstractQueryDecorator(Query query) {
		Assert.notNull(query, "query must not be null");
		this.query = query;
	}

	public <T extends SolrDataQuery> T addCriteria(Criteria criteria) {
		return this.query.addCriteria(criteria);
	}

	public Criteria getCriteria() {
		return this.query.getCriteria();
	}

	public void setJoin(Join join) {
		this.query.setJoin(join);
	}

	public Join getJoin() {
		return this.query.getJoin();
	}

	public <T extends Query> T addProjectionOnField(Field field) {
		return this.query.addProjectionOnField(field);
	}

	public <T extends Query> T setPageRequest(Pageable pageable) {
		return this.query.setPageRequest(pageable);
	}

	public <T extends Query> T addGroupByField(Field field) {
		return this.query.addGroupByField(field);
	}

	public <T extends Query> T addFilterQuery(FilterQuery query) {
		return this.query.addFilterQuery(query);
	}

	public <T extends Query> T setTimeAllowed(Integer timeAllowed) {
		return this.query.setTimeAllowed(timeAllowed);
	}

	public List<FilterQuery> getFilterQueries() {
		return this.query.getFilterQueries();
	}

	public Pageable getPageRequest() {
		return this.query.getPageRequest();
	}

	public List<Field> getGroupByFields() {
		return this.query.getGroupByFields();
	}

	public List<Field> getProjectionOnFields() {
		return this.query.getProjectionOnFields();
	}

	public <T extends Query> T addSort(Sort sort) {
		return this.query.addSort(sort);
	}

	public Sort getSort() {
		return this.query.getSort();
	}

	public Integer getTimeAllowed() {
		return this.query.getTimeAllowed();
	}

	public void setDefaultOperator(Operator operator) {
		this.query.setDefaultOperator(operator);
	}

	public Operator getDefaultOperator() {
		return this.query.getDefaultOperator();
	}

	public String getDefType() {
		return this.query.getDefType();
	}

	public void setDefType(String defType) {
		this.query.setDefType(defType);
	}

	public String getRequestHandler() {
		return this.query.getRequestHandler();
	}

	public void setRequestHandler(String requestHandler) {
		this.query.setRequestHandler(requestHandler);
	}

	@Override
	public <T extends Query> T setOffset(Integer offset) {
		return this.query.setOffset(offset);
	}

	@Override
	public <T extends Query> T setRows(Integer rows) {
		return this.query.setRows(rows);
	}

	@Override
	public Integer getOffset() {
		return this.query.getOffset();
	}

	@Override
	public Integer getRows() {
		return this.query.getRows();
	}

}
