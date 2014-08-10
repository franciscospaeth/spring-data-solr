package org.springframework.data.solr.core.query;

/**
 * General purpose {@link FacetQuery} decorator.
 * 
 * @author Francisco Spaeth
 *
 */
public abstract class AbstractFacetQueryDecorator extends AbstractQueryDecorator implements FacetQuery {

	private FacetQuery query;

	public AbstractFacetQueryDecorator(FacetQuery query) {
		super(query);
		this.query = query;
	}

	@Override
	public <T extends SolrDataQuery> T setFacetOptions(FacetOptions facetOptions) {
		return query.setFacetOptions(facetOptions);
	}

	@Override
	public FacetOptions getFacetOptions() {
		return query.getFacetOptions();
	}

	@Override
	public boolean hasFacetOptions() {
		return query.hasFacetOptions();
	}

}
