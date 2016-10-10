package it.com.testfairy.atlassian.plugins;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.atlassian.plugins.osgi.test.AtlassianPluginsTestRunner;
import com.testfairy.atlassian.plugins.api.TestFairyPluginComponent;
import com.atlassian.sal.api.ApplicationProperties;

import static org.junit.Assert.assertEquals;

@RunWith(AtlassianPluginsTestRunner.class)
public class TestFairyComponentWiredTest
{
    private final ApplicationProperties applicationProperties;
    private final TestFairyPluginComponent testfairyPluginComponent;

    public TestFairyComponentWiredTest(ApplicationProperties applicationProperties, TestFairyPluginComponent testfairyPluginComponent)
    {
        this.applicationProperties = applicationProperties;
        this.testfairyPluginComponent = testfairyPluginComponent;
    }

    @Test
    public void testMyName()
    {
        assertEquals("names do not match!", "testfairyComponent:" + applicationProperties.getDisplayName(), testfairyPluginComponent.getName());
    }
}