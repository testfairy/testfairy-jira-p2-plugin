package com.testfairy.atlassian.plugins.webfragment.conditions;

import com.atlassian.jira.bc.issue.properties.IssuePropertyService;
import com.atlassian.jira.entity.property.EntityPropertyService;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.plugin.webfragment.conditions.AbstractIssueWebCondition;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

/**
 * Custom condition used to check if TestFairy Session Panel should be rendered.
 */
public class IssueHasTestFairySessionProperty extends AbstractIssueWebCondition {

    @ComponentImport
    private final IssuePropertyService issuePropertyService;

    public IssueHasTestFairySessionProperty(IssuePropertyService issuePropertyService) {
        this.issuePropertyService = issuePropertyService;
    }
    public boolean shouldDisplay(ApplicationUser applicationUser, Issue issue, JiraHelper jiraHelper) {
        EntityPropertyService.PropertyResult testfairySessionProperty = issuePropertyService.getProperty(applicationUser, issue.getId(), "testfairySession");
        return testfairySessionProperty.getEntityProperty().getOrNull() != null;
    }
}
