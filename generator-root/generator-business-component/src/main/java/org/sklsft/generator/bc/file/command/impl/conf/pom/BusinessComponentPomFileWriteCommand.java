package org.sklsft.generator.bc.file.command.impl.conf.pom;

import java.io.File;

import org.sklsft.generator.bc.file.command.impl.templatized.ProjectTemplatizedFileWriteCommand;
import org.sklsft.generator.model.domain.Project;
import org.sklsft.generator.model.metadata.FileType;

public class BusinessComponentPomFileWriteCommand extends ProjectTemplatizedFileWriteCommand {

	public BusinessComponentPomFileWriteCommand(Project project) {
		super(project.workspaceFolder + File.separator + project.projectName + "-business-component", "pom", FileType.XML, project);
	}

}