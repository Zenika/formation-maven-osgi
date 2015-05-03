import org.codehaus.groovy.maven.mojo.GroovyMojo

/**
* @goal backup
*/
public class BackupMojo extends GroovyMojo {

  /**
    * @parameter expression="${project}"
    * @required
    * @readonly
    */
    private org.apache.maven.project.MavenProject project;

    void execute() {
        log.info('Backup...!')
	def dir = "${project.basedir}" + "/backup"
	ant.mkdir(dir: dir)
	ant.copy(todir: dir) {
	    	fileset(dir: "${project.build.sourceDirectory}") {
        	  include(name: '**/*.*')
        	}
	}
    }

}