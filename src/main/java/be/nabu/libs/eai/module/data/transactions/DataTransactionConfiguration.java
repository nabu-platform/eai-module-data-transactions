package be.nabu.libs.eai.module.data.transactions;

import java.util.TimeZone;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import be.nabu.eai.repository.jaxb.ArtifactXMLAdapter;
import be.nabu.eai.repository.jaxb.TimeZoneAdapter;
import be.nabu.libs.artifacts.api.DataSourceProviderArtifact;

public class DataTransactionConfiguration {
	private DataSourceProviderArtifact datasource;
	private TimeZone timezone;
	
	@XmlJavaTypeAdapter(value = ArtifactXMLAdapter.class)
	public DataSourceProviderArtifact getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSourceProviderArtifact datasource) {
		this.datasource = datasource;
	}
	
	@XmlJavaTypeAdapter(value = TimeZoneAdapter.class)
	public TimeZone getTimezone() {
		return timezone;
	}
	public void setTimezone(TimeZone timezone) {
		this.timezone = timezone;
	}
	
}
