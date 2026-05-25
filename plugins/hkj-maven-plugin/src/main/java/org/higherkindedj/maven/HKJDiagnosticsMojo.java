// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.maven;

import java.util.ArrayList;
import java.util.List;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Plugin;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * Prints the current HKJ configuration for diagnostics and troubleshooting.
 *
 * <p>Usage: {@code mvn hkj:diagnostics}
 */
@Mojo(name = "diagnostics", requiresProject = true)
public class HKJDiagnosticsMojo extends AbstractMojo {

    /**
     * Creates a new HKJDiagnosticsMojo.
     */
    public HKJDiagnosticsMojo() {
    }

    private static final String GROUP_ID = "io.github.higher-kinded-j";

    private static final String PLUGIN_KEY = GROUP_ID + ":hkj-maven-plugin";

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Override
    public void execute() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Plugin findHKJPlugin() {
        for (Plugin plugin : project.getBuildPlugins()) {
            if (PLUGIN_KEY.equals(plugin.getKey())) {
                return plugin;
            }
        }
        return null;
    }
}
