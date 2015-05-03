package com.zenika.plugins;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.model.Resource;

/**
 * @goal trace
 *  
 * @phase generate-resources 
 * 
 * @execute lifecycle="tracePackageCycle" phase="package" 
 */ 
public class TraceMojo extends AbstractMojo
{
    /**
     * The current message
     * @parameter expression="${trace.message}" default-value="Welcome Zenika!"
     */
    private String message ;
    
    /**
     * @parameter
     */
    private String[] properties ;

    
    /**
    * List of Resource objects for the current build, containing
    * directory, includes, and excludes.
    * @parameter default-value="${project.resources}"
    * @required
    * @readonly
    */
    private List<Resource> resources;
    
    
    public void execute()
        throws MojoExecutionException
    {
    	getLog().info(message);
    	
    	String resourceRoot = null;
    	if (resources != null && !resources.isEmpty()) {
			for (Iterator it = resources.iterator(); it.hasNext();) {
				Resource resource = (Resource) it.next();
				resourceRoot = resource.getDirectory();
			}
		}
    	if (resourceRoot == null){
    		throw new MojoExecutionException("");
    	}
    	
        File f = new File(resourceRoot + "/META-INF");
        if ( !f.exists() ){
            f.mkdirs();
        }
        File traceFile = new File( f, "trace.txt" );
        FileWriter w = null;
        try
        {
            w = new FileWriter( traceFile );
        	if (properties!=null){
       		 for (int i=0;i<properties.length;i++){
       			w.write(properties[i] + " a la valeur : " + System.getProperty(properties[i]) + "\n"); 
       		 }
       		}
       		else{
       			Properties properties = System.getProperties();
       			for (Iterator it =  properties.entrySet().iterator();it.hasNext();){
       			 	Map.Entry entry =  (Map.Entry)it.next();
       			 	w.write(entry.getKey() + " a la valeur : " + entry.getValue() +"\n");        			
       			}
       		}
        }
        catch ( IOException e )
        {
            throw new MojoExecutionException( "Error creating file " + traceFile, e );
        }
        finally
        {
            if ( w != null )
            {
                try
                {
                    w.close();
                }
                catch ( IOException e )
                {
                    // ignore
                }
            }
        }
  	
    }
}
