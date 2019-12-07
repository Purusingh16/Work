package utils;

import org.apache.http.impl.client.CloseableHttpClient;
import org.openqa.selenium.remote.internal.HttpClientFactory;
import org.openqa.selenium.remote.internal.ApacheHttpClient.Factory;
import org.powermock.reflect.Whitebox;


 

public class HttpParamsSetter {

	private HttpParamsSetter() {
	}

	public static void setSoTimeout(int soTimeout) {
	injectIntoHttpCommandExecutor(createClientFactoryWithSoTimeout(soTimeout));
	}

	private static HttpClientFactory createClientFactoryWithSoTimeout(int soTimeout) {
	HttpClientFactory httpClientFactory = new HttpClientFactory();
	//Whitebox.setInternalState(httpClientFactory, "TIMEOUT_THREE_HOURS", soTimeout); //Selenium 2.45
	Whitebox.setInternalStateFromContext(httpClientFactory, "TIMEOUT_THREE_HOURS", soTimeout); //Selenium 2.46 (compatible con la 2.48.2)
	CloseableHttpClient httpClient = httpClientFactory.createHttpClient(null);
	Whitebox.setInternalState(httpClientFactory, "httpClient", httpClient);
	return httpClientFactory;
	}

	private static void injectIntoHttpCommandExecutor(HttpClientFactory httpClientFactory) {
	Whitebox.setInternalState(Factory.class, "defaultClientFactory", httpClientFactory);
	}
	}



