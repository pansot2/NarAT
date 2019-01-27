/*
 * #%L
 * Native ARchive plugin for Maven
 * %%
 * Copyright (C) 2002 - 2014 NAR Maven Plugin developers.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.github.maven_nar;

import java.io.IOException;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Move the GNU style include/lib to some output directory
 * 
 * @author Mark Donszelmann
 */
@Mojo(name = "nar-gnu-resources", defaultPhase = LifecyclePhase.PROCESS_RESOURCES, requiresProject = true)
public class NarGnuResources extends AbstractGnuMojo {
  @Override
  public final void narExecute() throws MojoExecutionException, MojoFailureException {
    if (getGnuSourceDirectory().exists()) {
      int copied = 0;

      try {
        copied += copyIncludes(getGnuSourceDirectory());
      } catch (final IOException e) {
        throw new MojoFailureException("NAR: Gnu could not copy resources", e);
      }

      if (copied > 0) {
        getLog().info("Copied " + copied + " GNU resources");
      }

    }
  }
}
