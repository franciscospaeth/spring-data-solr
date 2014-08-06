package org.springframework.data.solr.core.query.result;

import java.util.List;

public class SimpleGroupResult<T> implements GroupResult<T> {

	private int matches;
	private Integer groupsCount;
	private String name;
	private List<GroupEntry<T>> groupEntries;

	public SimpleGroupResult(int matches, Integer groupsCount, String name, List<GroupEntry<T>> groupEntries) {
		super();
		this.matches = matches;
		this.groupsCount = groupsCount;
		this.name = name;
		this.groupEntries = groupEntries;
	}

	@Override
	public int getMatches() {
		return matches;
	}

	@Override
	public Integer getGroupsCount() {
		return groupsCount;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public List<GroupEntry<T>> getGroupEntries() {
		return groupEntries;
	}

}
