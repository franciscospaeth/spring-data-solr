package org.springframework.data.solr.core.query.result;

import org.springframework.data.domain.Page;

public class SimpleGroupEntry<T> implements GroupEntry<T> {

	private String groupValue;
	private Page<T> result;

	public SimpleGroupEntry(String groupValue, Page<T> result) {
		super();
		this.groupValue = groupValue;
		this.result = result;
	}

	@Override
	public String getGroupValue() {
		return groupValue;
	}

	@Override
	public Page<T> getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "SimpleGroupEntry [groupValue=" + groupValue + ", result=" + result + "]";
	}

}
