package com.zenika.formation.test;

import com.zenika.formation.ExampleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.jdbc.DataSourceFactory;

import javax.inject.Inject;
import java.sql.Driver;
import java.sql.SQLException;

import static org.ops4j.pax.exam.CoreOptions.*;

/**
 * OSGi tests.
 */
@RunWith(PaxExam.class) 
public class OSGiTest {

	@Inject
	private BundleContext bundleContext;
	
	@Inject
	private DataSourceFactory dataSourceFactory;
	
	@Configuration
	public static Option[] configuration() {
		return options(
				mavenBundle("org.osgi", "org.osgi.compendium", "4.3.1").noStart(),
				mavenBundle("com.zenika.formation", "resanet-tools", "1.0.0-SNAPSHOT"),
				mavenBundle("com.zenika.formation.osgi", "jdbc-provider", "1.0.0-SNAPSHOT"),
				wrappedBundle(mavenBundle("javax.servlet", "servlet-api", "2.5")).noStart(),
				junitBundles(),
				vmOption("-Xmx512m")
		);
	}

	@Test
	public void testBundleContext() {
		Assert.assertNotNull(bundleContext);
	}
	
	/**
	 * Verify that the LogService bundle is correctly installed.
	 */
	@Test
	public void testLogServiceProviderBundleIsInstalled() {
		for (Bundle bundle : bundleContext.getBundles()) {
			if (bundle.getSymbolicName().equals("com.zenika.formation.resanet-tools")) {
				return;
			}
		}
		Assert.fail("resanet is not installed");
	}
	
	/**
	 * Verify that the LogService bundle is correctly installed and active.
	 */
	@Test
	public void testLogServiceProviderBundleIsActive() {
		for (Bundle bundle : bundleContext.getBundles()) {
			if (bundle.getSymbolicName().equals("com.zenika.formation.resanet-tools") && (bundle.getState() == Bundle.ACTIVE)) {
				return;
			}
		}
		Assert.fail("resanet tools is not installed and active");
	}

	/**
	 * Verify that a ExampleService is correctly registered.
	 */
	@Test
	public void testExampleServiceIsRegistered() {
		ServiceReference<ExampleService> serviceReference = bundleContext.getServiceReference(ExampleService.class);
		ExampleService exampleService = bundleContext.getService(serviceReference);
		Assert.assertNotNull(exampleService);
	}
	
	/**
	 * Verify that the Driver version is equal to 1.3 (by injection).
	 * @throws SQLException 
	 */
	@Test
	public void testDataSourceConnectionisActive() throws SQLException {
		Driver driver = dataSourceFactory.createDriver(null);
		Assert.assertEquals(driver.getMajorVersion(), 1);
		Assert.assertEquals(driver.getMinorVersion(), 3);
	}
}
