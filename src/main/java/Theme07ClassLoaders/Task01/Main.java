package Theme07ClassLoaders.Task01;

public class Main {
    public static void main(String[] args) {
    PluginManager pluginManager = new PluginManager("");
    pluginManager.initializePlugin();
    pluginManager.startAll();
    }
}
