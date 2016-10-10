package com.testfairy.atlassian.plugins.impl;

import com.atlassian.event.api.EventListener;
import com.atlassian.event.api.EventPublisher;
import com.atlassian.jira.event.issue.IssueEvent;
import com.atlassian.jira.event.type.EventType;
import com.atlassian.jira.issue.Issue;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;
import com.testfairy.atlassian.plugins.api.TestFairyPluginComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

@ExportAsService ({TestFairyPluginComponent.class})
@Named ("testfairyPluginComponent")
public class TestFairyPluginComponentImpl implements TestFairyPluginComponent
{
    private static final Logger log = LoggerFactory.getLogger(TestFairyPluginComponentImpl.class);

    @ComponentImport
    private final ApplicationProperties applicationProperties;

    @Inject
    public TestFairyPluginComponentImpl(final ApplicationProperties applicationProperties)
    {
        this.applicationProperties = applicationProperties;
    }

    public String getName()
    {
        if(null != applicationProperties)
        {
            return "testfairyComponent:" + applicationProperties.getDisplayName();
        }

        return "testfairyComponent";
    }

}