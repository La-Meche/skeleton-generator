package org.sklsft.generator.repository.backup.command.impl;

import org.sklsft.generator.repository.backup.command.interfaces.BackupArgumentsCommand;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * searches for a generated {@link BackupArgumentsCommand} in the populator spring context
 * 
 * @author Nicolas Thibault
 *
 */
@Component
public class BackupArgumentsCommandFactory implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * create the appropriate command depending on what table is used for
	 * population.
	 */
	public BackupArgumentsCommand getCommand(String classSimpleName) {

		return (BackupArgumentsCommand) applicationContext.getBean(classSimpleName);
	}
	
	public BackupArgumentsCommand getCommand(Class<?> commandClass) {

		return (BackupArgumentsCommand) applicationContext.getBean(commandClass);
	}
}