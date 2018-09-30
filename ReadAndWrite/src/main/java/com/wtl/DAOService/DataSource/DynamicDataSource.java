package com.wtl.DAOService.DataSource;

import javax.annotation.Nullable;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	
	@Nullable
	@Override
	protected Object determineCurrentLookupKey() {
		DatabaseType type = DatabaseContextHolder.getDatabaseType();
		System.out.println("type========" + type);
		return type;
	}

}
