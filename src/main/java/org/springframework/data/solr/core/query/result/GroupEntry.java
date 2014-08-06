package org.springframework.data.solr.core.query.result;

import org.springframework.data.domain.Page;

public interface GroupEntry<T> {

	String getGroupName();
	
	Page<T> getResult();
	
}
