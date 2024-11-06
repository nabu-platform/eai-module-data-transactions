/*
* Copyright (C) 2016 Alexander Verbruggen
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <https://www.gnu.org/licenses/>.
*/

package be.nabu.libs.eai.module.data.transactions;

import java.util.TimeZone;

import be.nabu.eai.repository.api.Repository;
import be.nabu.eai.repository.artifacts.jaxb.JAXBArtifact;
import be.nabu.libs.datatransactions.database.DatabaseTransactionProvider;
import be.nabu.libs.resources.api.ResourceContainer;

public class DataTransactionArtifact extends JAXBArtifact<DataTransactionConfiguration> {

	private DatabaseTransactionProvider provider;
	
	public DataTransactionArtifact(String id, ResourceContainer<?> directory, Repository repository) {
		super(id, directory, repository, "data-transaction-provider.xml", DataTransactionConfiguration.class);
	}
	
	public DatabaseTransactionProvider getProvider() {
		if (provider == null) {
			synchronized(this) {
				if (provider == null) {
					provider = new DatabaseTransactionProvider(getConfig().getDatasource().getDataSource(), getConfig().getTimezone() == null ? TimeZone.getTimeZone("UTC") : getConfig().getTimezone());
				}
			}
		}
		return provider;
	}
}
