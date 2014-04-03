package org.skeleton.generator.bc.command.file.impl.conf.webapp;

import java.io.File;

import org.skeleton.generator.bc.command.file.impl.templatized.ProjectTemplatizedFileWriteCommand;
import org.skeleton.generator.model.om.Project;
import org.skeleton.generator.util.metadata.FileType;

public class SpringHibernateRichfacesFacesConfigFileWriteCommand extends ProjectTemplatizedFileWriteCommand {

	public SpringHibernateRichfacesFacesConfigFileWriteCommand(Project project) {
		super(project.workspaceFolder + File.separator + project.projectName + "-webapp/src/main/webapp/WEB-INF", "faces-config", FileType.XML, project);
	}

}
