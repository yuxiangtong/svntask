# Dropping Subversion like a hot rock #

At this point, I've moved to git. My reasons vary, but primarily subversion has just missed the boat in a lot of ways. All future releases of subversion will only be to add features that git already supports. I recently tried to update the svnkit libraries to support svn 1.7 and they now add two (or more, I stopped after the second failure) jar dependencies.

I'm not going to do any more updates to this project. Sorry.


```





















```
# Introduction #
svntask is a super simple solution for using svn from ant. Unfortunately, nobody has come up with a good solution until now. At [work](http://kink.com/), instead of using version numbers for our releases, we just use our svn revision number. We needed an easy way to get that number from ant.

[SvnAnt](http://subclipse.tigris.org/svnant.html) is the alternative to this project. However, there are still a good reason why I like this project better. I don't care about and don't want to mess with native library access javahl or command line access. I just want a 100% Java solution that uses the nice [svnkit library](http://svnkit.com). Include two simple jar files and go.

In the future, if I need more features, I'll add them. Or, you are welcome to file a new issue with a patch. If you file a patch, make sure you write clean code and format it the same way that I've formatted it so that integrating it is just a small amount of work for me.

If you feel like making a small beer money donation to me for spending many hours working on this project, you can donate by clicking the button below. No amount is too large or too small.

&lt;wiki:gadget url="http://svntask.googlecode.com/svn/wiki/donate.xml" border="0" width="150" height="70" /&gt;

## Usage ##

```
<target name="version">
	<typedef resource="com/googlecode/svntask/svntask.xml">
		<classpath>
			<fileset dir="${base.dir}/lib">
				<include name="svnkit.jar"/>
				<include name="svntask.jar"/>
			</fileset>
		</classpath>
	</typedef>

        <!-- Do an update first to make sure you have the latest version -->
	<svn><update path="." force="true" recursive="true" /></svn>

	<svn><info path="." revisionProperty="revisionVersion" /></svn>
	<property name="version" value="${revisionVersion}" />
</target>
```

### Releases ###
**1.0.8 - Nov, 20, 2010**

  * Bundled with latest svnkit 1.3.4.

**1.0.7 - June 25, 2009**

  * Force javac to compile the classes in the jar as 1.5.

**1.0.6 - June 25, 2009**

  * Added log command.
  * Set a property for the svn update command with the updated version.

**1.0.5 - June 3, 2009**

  * Added ls command.

**1.0.4 - May 30th, 2009**

  * Updated to svnkit 1.3.0.5847 (supports svn 1.6.2)
  * Added add, commit and switch commands.
  * Added a few more parameters to existing commands.

**1.0.3 - July 15th, 2008**

  * Added more properties to the svn info command.

**1.0.2 - July 11th, 2008**

  * Added svn update. See example above for usage.
  * Updated to svnkit 1.2b2.
  * Added a bit of logging which shows up nicely in ant.

**1.0.1 - July 1st, 2008**

  * Minor bug fixes. Default to -1 for the revision number if you run svn info on a path that isn't in svn.

**1.0 - June 27th, 2008**

  * To begin with, I just need the revision number output from svn info.