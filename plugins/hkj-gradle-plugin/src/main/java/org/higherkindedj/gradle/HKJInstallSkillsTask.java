// Copyright (c) 2025 - 2026 Magnus Smith
// Licensed under the MIT License. See LICENSE.md in the project root for license information.
package org.higherkindedj.gradle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.gradle.api.DefaultTask;
import org.gradle.api.GradleException;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.api.tasks.TaskAction;
import org.gradle.work.DisableCachingByDefault;

/**
 * Task that installs HKJ Claude Code skills into the project's {@code .claude/skills/} directory.
 *
 * <p>Skills are bundled as classpath resources in the plugin JAR under {@code
 * META-INF/hkj-skills/}. This task reads the manifest listing all skill files and copies them to
 * the project directory.
 *
 * <p>Caching is disabled because the task writes outside the build directory (into the consumer
 * project's {@code .claude/skills/} directory) and the copy cost is negligible compared to the
 * overhead of a cache lookup.
 */
@DisableCachingByDefault(because = "Writes to project directory, not build output; copy cost is negligible")
public abstract class HKJInstallSkillsTask extends DefaultTask {

    private static final String MANIFEST_RESOURCE = "/META-INF/hkj-skills/manifest.txt";

    private static final String SKILLS_RESOURCE_PREFIX = "/META-INF/hkj-skills/";

    /**
     * Creates a new install skills task.
     */
    public HKJInstallSkillsTask() {
        setGroup("hkj");
        setDescription("Installs HKJ Claude Code skills into .claude/skills/");
    }

    /**
     * Returns the output directory where skills are installed.
     *
     * @return the .claude/skills directory under the project root
     */
    @OutputDirectory
    public Path getOutputDir() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Copies skill files from the plugin's classpath resources to the project directory.
     */
    @TaskAction
    public void install() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
