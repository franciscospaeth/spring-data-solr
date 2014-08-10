package org.springframework.data.solr.core.query.result;

import org.springframework.data.domain.Page;
import org.springframework.util.Assert;

public class SimpleGroupResult<T> implements GroupResult<T> {

	private int matches;
	private Integer groupsCount;
	private String name;
	private Page<GroupEntry<T>> groupEntries;

	public SimpleGroupResult(int matches, Integer groupsCount, String name, Page<GroupEntry<T>> groupEntries) {
		Assert.isTrue(matches >= 0, "matches must be >= 0");
		Assert.hasLength(name, "group result name must be not empty");
		Assert.notNull(groupEntries, "groupEntries must be not null");
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
	public Page<GroupEntry<T>> getGroupEntries() {
		return groupEntries;
	}

	@Override
	public String toString() {
		return new StringBuilder() //
				.append("SimpleGroupResult [name=").append(name) //
				.append(", matches=").append(matches) //
				.append(", groupsCount=").append(groupsCount) //
				.append(", groupsEntries.total=").append(groupEntries.getTotalElements()) //
				.append("]").toString();
	}

}
