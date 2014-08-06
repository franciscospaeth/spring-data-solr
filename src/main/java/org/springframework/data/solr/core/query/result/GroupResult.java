package org.springframework.data.solr.core.query.result;

import java.util.List;

public interface GroupResult<T> {

	int getMatches();
	
	Integer getGroupsCount();
	
	String getName();
	
	List<GroupEntry<T>> getGroupEntries();
	
}
