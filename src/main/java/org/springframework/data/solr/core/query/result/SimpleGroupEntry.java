package org.springframework.data.solr.core.query.result;

import org.springframework.data.domain.Page;

public class SimpleGroupEntry<T> implements GroupEntry<T> {

	private String groupName;
	private Page<T> result;

	public SimpleGroupEntry(String groupName, Page<T> result) {
		super();
		this.groupName = groupName;
		this.result = result;
	}

	@Override
	public String getGroupName() {
		return groupName;
	}

	@Override
	public Page<T> getResult() {
		return result;
	}

}
