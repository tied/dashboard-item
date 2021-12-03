package com.example.jira.plugin;

import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.plugin.Plugin;
import com.atlassian.plugin.PluginAccessor;
import com.atlassian.plugin.PluginParseException;
import com.atlassian.plugin.spring.scanner.annotation.component.Scanned;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.plugin.web.ContextProvider;
import com.google.common.collect.Maps;

import java.util.Map;

@Scanned
public class DashboardItemContextProvider implements ContextProvider {

    private final PluginAccessor pluginAccessor;

    public DashboardItemContextProvider(
            @ComponentImport PluginAccessor pluginAccessor) {
        this.pluginAccessor = pluginAccessor;
    }

    @Override
    public void init(final Map<String, String> params) throws PluginParseException {

    }

    @Override
    public Map<String, Object> getContextMap(final Map<String, Object> context) {
        final Map<String, Object> newContext = Maps.newHashMap(context);
        Plugin plugin = pluginAccessor.getEnabledPlugin("com.example.jira.dashboard-item");
        newContext.put("pluginName", plugin.getName());

        newContext.put("projects", ComponentAccessor.getProjectManager().getProjects());
        newContext.put("projectsList", ComponentAccessor.getProjectManager().getProjects());
        return newContext;

    }

}
