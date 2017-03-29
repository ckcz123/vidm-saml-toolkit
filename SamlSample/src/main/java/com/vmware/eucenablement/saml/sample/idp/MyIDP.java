package com.vmware.eucenablement.saml.sample.idp;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vmware.eucenablement.saml.sample.MySSO;
import com.vmware.samltookit.idp.IDPService;
import com.vmware.samltookit.idp.SAMLIDPConf;

public class MyIDP {

	private static IDPService service;

	private static Logger log = LoggerFactory.getLogger(MySSO.class);

	/**
	 *
	 * @param issuer like https://localhost:8443/SamlSample/idp.xml
	 * @return
	 */
	public static IDPService initIDPService(String issuer, InputStream kestoreStream, String keystorepwd) {


		try {
			SAMLIDPConf conf = new SAMLIDPConf(issuer, kestoreStream, keystorepwd);


			service = new IDPService(conf);
		} catch (Exception e) {
			log.error("Error initializing service", e);
			service = null;
		}
		return service;
	}



	public static IDPService getIDPService() {

		if (service == null)
			log.error("IDPService is null!! Please init it again!");

		return service;
	}


}