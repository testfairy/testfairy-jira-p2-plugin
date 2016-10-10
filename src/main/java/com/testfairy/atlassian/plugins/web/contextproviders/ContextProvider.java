package com.testfairy.atlassian.plugins.web.contextproviders;

import com.atlassian.jira.bc.issue.properties.IssuePropertyService;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.properties.APKeys;
import com.atlassian.jira.entity.property.EntityPropertyService;
import com.atlassian.jira.issue.Issue;
import com.atlassian.jira.plugin.webfragment.contextproviders.AbstractJiraContextProvider;
import com.atlassian.jira.plugin.webfragment.model.JiraHelper;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.jira.util.json.JSONException;
import com.atlassian.jira.util.json.JSONObject;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;

import java.util.HashMap;
import java.util.Map;

public class ContextProvider extends AbstractJiraContextProvider {

    @ComponentImport
    private final IssuePropertyService issuePropertyService;

    public ContextProvider(final IssuePropertyService issuePropertyService) {
        this.issuePropertyService = issuePropertyService;
    }

    public Map getContextMap(ApplicationUser applicationUser, JiraHelper jiraHelper) {
        HashMap<String, Object> contextMap = new HashMap<String, Object>(5);
        Issue issue = (Issue) jiraHelper.getContextParams().get("issue");

        try {
            EntityPropertyService.PropertyResult testfairySessionProperty = issuePropertyService.getProperty(applicationUser, issue.getId(), "testfairySession");
            String testfairySessionJson = testfairySessionProperty.getEntityProperty().getOrNull().getValue();
            JSONObject jsonObject = new JSONObject(testfairySessionJson);
            String baseUrl = ComponentAccessor.getApplicationProperties().getString(APKeys.JIRA_BASEURL);

            contextMap.put("user", applicationUser);
            contextMap.put("issue", issue);
            contextMap.put("helper", jiraHelper);
            contextMap.put("baseUrl", baseUrl);
            contextMap.put("testerEmail", jsonObject.getString("testerEmail"));
            contextMap.put("osVersion", jsonObject.getString("osVersion"));
            contextMap.put("platform", jsonObject.getString("platform"));
            contextMap.put("deviceModel", jsonObject.getString("deviceModel"));
            contextMap.put("sessionUrl", jsonObject.getString("sessionUrl"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return contextMap;
    }

}
