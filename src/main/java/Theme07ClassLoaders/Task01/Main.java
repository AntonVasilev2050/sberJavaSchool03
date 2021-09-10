package Theme07ClassLoaders.Task01;

import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
//        PluginManager pluginManager = new PluginManager("/Users/u17724333/Job/JavaШкола/ClassLoader/java-school/plugin-manager/plugins");
        PluginManager pluginManager = new PluginManager("C:\\Users\\USER\\OneDrive\\BBdocuments\\IdeaProjects\\sberJavaSchool02\\src\\main\\java\\Theme07ClassLoaders\\Task01\\plugins");
        System.out.println("Init");
        pluginManager.initializePlugin();
        pluginManager.startAll();
    }
}
