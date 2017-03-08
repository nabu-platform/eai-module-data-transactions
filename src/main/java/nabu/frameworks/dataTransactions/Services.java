package nabu.frameworks.dataTransactions;

import java.io.IOException;

import javax.jws.WebParam;
import javax.jws.WebService;

import be.nabu.libs.datatransactions.api.DataTransactionHandle;

@WebService
public class Services {
	public void done(@WebParam(name = "transactionHandle") DataTransactionHandle handle) throws IOException {
		if (handle != null) {
			handle.done();
		}
	}
	public void fail(@WebParam(name = "transactionHandle") DataTransactionHandle handle, @WebParam(name = "message") String message) throws IOException {
		if (handle != null) {
			handle.fail(message);
		}
	}
}
