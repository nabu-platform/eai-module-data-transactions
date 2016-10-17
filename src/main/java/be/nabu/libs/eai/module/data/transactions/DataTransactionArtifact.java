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
