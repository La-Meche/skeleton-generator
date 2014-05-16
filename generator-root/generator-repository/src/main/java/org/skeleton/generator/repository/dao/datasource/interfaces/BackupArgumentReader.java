package org.skeleton.generator.repository.dao.datasource.interfaces;

import org.skeleton.generator.exception.ReadBackupFailureException;
import org.skeleton.generator.repository.dao.datasource.impl.BackupCommandArguments;

/**
 * This class provides a representation of Backup data through a List of object arrays<br/>
 * Depending on the implementation, the data will be fetched from a database query, a csv file, ...
 * @author Nicolas Thibault
 *
 */
public interface BackupArgumentReader {

	BackupCommandArguments readBackupArgs(String backupFilePath) throws ReadBackupFailureException;
}
