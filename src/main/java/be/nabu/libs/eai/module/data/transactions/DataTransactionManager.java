package be.nabu.libs.eai.module.data.transactions;

import be.nabu.eai.repository.api.Repository;
import be.nabu.eai.repository.managers.base.JAXBArtifactManager;
import be.nabu.libs.resources.api.ResourceContainer;

public class DataTransactionManager extends JAXBArtifactManager<DataTransactionConfiguration, DataTransactionArtifact> {

	public DataTransactionManager() {
		super(DataTransactionArtifact.class);
	}

	@Override
	protected DataTransactionArtifact newInstance(String id, ResourceContainer<?> container, Repository repository) {
		return new DataTransactionArtifact(id, container, repository);
	}

}
