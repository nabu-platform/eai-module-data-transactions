package be.nabu.libs.eai.module.data.transactions;

import java.io.IOException;
import java.util.List;

import be.nabu.eai.developer.MainController;
import be.nabu.eai.developer.managers.base.BaseJAXBGUIManager;
import be.nabu.eai.repository.resources.RepositoryEntry;
import be.nabu.libs.property.api.Property;
import be.nabu.libs.property.api.Value;

public class DataTransactionGUIManager extends BaseJAXBGUIManager<DataTransactionConfiguration, DataTransactionArtifact> {

	public DataTransactionGUIManager() {
		super("Data Transaction Provider", DataTransactionArtifact.class, new DataTransactionManager(), DataTransactionConfiguration.class);
	}

	@Override
	protected List<Property<?>> getCreateProperties() {
		return null;
	}

	@Override
	protected DataTransactionArtifact newInstance(MainController controller, RepositoryEntry entry, Value<?>... values) throws IOException {
		return new DataTransactionArtifact(entry.getId(), entry.getContainer(), entry.getRepository());
	}

	@Override
	public String getCategory() {
		return "Frameworks";
	}
}
