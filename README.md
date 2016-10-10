# TestFairy JIRA add-on

This repository contains sources of TestFairy JIRA add-on targeted at standalone JIRA installations.

Atlassian SDK commands useful in development lifecycle:

* atlas-run   -- installs this plugin into the product and starts it on localhost
* atlas-debug -- same as atlas-run, but allows a debugger to attach at port 5005. For IDEA setup details, 
see: https://developer.atlassian.com/docs/developer-tools/working-in-an-ide/creating-a-remote-debug-target
* atlas-package -- rebuild, and redeploy (using QuickReload) to JIRA started using atlas-run or atlas-debug

* atlas-cli   -- after atlas-run or atlas-debug, opens a Maven command line window:
                 - 'pi' reinstalls the plugin into the running product instance
* atlas-help  -- prints description for all commands in the SDK

* atlas-clean -- reset JIRA state to that in src/test/resources/generated-test-resources.zip


Full documentation is always available at:

https://developer.atlassian.com/display/DOCS/Introduction+to+the+Atlassian+Plugin+SDK
