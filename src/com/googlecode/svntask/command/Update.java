package com.googlecode.svntask.command;

import java.io.File;

import org.tmatesoft.svn.core.SVNDepth;
import org.tmatesoft.svn.core.wc.SVNRevision;
import org.tmatesoft.svn.core.wc.SVNUpdateClient;

import com.googlecode.svntask.Command;


/**
 * Used for executing svn update. Defaults to recursive and force == true.
 *
 * @author jonstevens
 */
public class Update extends Command
{
	private String path;
	private SVNRevision revision = SVNRevision.HEAD;
	private SVNDepth depth = SVNDepth.INFINITY;
	private boolean recursive = true;
	private boolean force = true;

	@Override
	public void execute() throws Exception
	{
		File filePath = new File(this.path);

		this.getTask().log("update " + filePath.getCanonicalPath());

		// Get the Update Client
		SVNUpdateClient client = this.getTask().getSvnClient().getUpdateClient();

		// Execute svn info
		client.doUpdate(filePath, this.revision, this.depth, this.recursive, this.force);
	}

	/** */
	@Override
	protected void validateAttributes() throws Exception
	{
		if (this.path == null)
			throw new Exception("path cannot be null");
	}

	/** */
	public void setPath(String path)
	{
		this.path = path;
	}

	/** */
	public void setRevision(long revision)
	{
		this.revision = SVNRevision.create(revision);
	}

	/** */
	public void setDepth(String depth)
	{
		this.depth = SVNDepth.fromString(depth);
	}

	/** */
	public void setRecursive(boolean recursive)
	{
		this.recursive = recursive;
	}

	/** */
	public void setForce(boolean force)
	{
		this.force = force;
	}
}