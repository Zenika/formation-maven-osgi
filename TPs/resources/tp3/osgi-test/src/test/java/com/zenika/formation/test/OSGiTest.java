package com.zenika.formation.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.osgi.framework.BundleContext;

import javax.inject.Inject;

import static org.ops4j.pax.exam.CoreOptions.*;

/**
 * OSGi tests.
 */
@RunWith(PaxExam.class) 
public class OSGiTest {

	@Inject
	private BundleContext bundleContext;
	
	@Configuration
	public static Option[] configuration() {
		return options(
			systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("WARN"),
			junitBundles()
		);
	}

	@Test
	public void testBundleContext() {
		Assert.assertNotNull(bundleContext);
	}
}
