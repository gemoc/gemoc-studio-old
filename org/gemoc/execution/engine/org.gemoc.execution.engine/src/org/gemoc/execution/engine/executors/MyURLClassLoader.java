package org.gemoc.execution.engine.executors;

import java.net.URL;  
import java.net.URLClassLoader;  
   
   
public class MyURLClassLoader extends URLClassLoader{  
   
    /** 
     * @param urls, to carryforward the existing classpath. 
     */  
    public MyURLClassLoader(URL[] urls, ClassLoader parent) {  
        super(urls, parent);  
    }  
      
    @Override  
    /** 
     * add an URL classpath to the loader. 
     */  
    public void addURL(URL url) {  
        super.addURL(url);  
    }  
   
}  
