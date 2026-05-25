// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.maven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * Installs HKJ Claude Code skills into the project's {@code .claude/skills/} directory.
 *
 * <p>Skills are bundled as classpath resources in the plugin JAR under {@code
 * META-INF/hkj-skills/}. This goal reads the manifest listing all skill files and copies them to
 * the project directory.
 *
 * <p>Usage: {@code mvn hkj:install-skills}
 */
@Mojo(name = "install-skills", requiresProject = true)
public class HKJInstallSkillsMojo extends AbstractMojo {

    /**
     * Creates a new HKJInstallSkillsMojo.
     */
    public HKJInstallSkillsMojo() {
    }

    private static final String MANIFEST_RESOURCE = "/META-INF/hkj-skills/manifest.txt";

    private static final String SKILLS_RESOURCE_PREFIX = "/META-INF/hkj-skills/";

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
