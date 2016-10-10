package ut.com.testfairy.atlassian.plugins;

import org.junit.Test;
import com.testfairy.atlassian.plugins.api.TestFairyPluginComponent;
import com.testfairy.atlassian.plugins.impl.TestFairyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class TestFairyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        TestFairyPluginComponent component = new TestFairyPluginComponentImpl(null);
        assertEquals("names do not match!", "testfairyComponent",component.getName());
    }
}