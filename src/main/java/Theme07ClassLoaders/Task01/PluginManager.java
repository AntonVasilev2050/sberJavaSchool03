package Theme07ClassLoaders.Task01;
// Ваша задача написать загрузчик плагинов в вашу систему. Допустим вы пишите свой
// браузер и хотите чтобы люди имели имели возможность писать плагины для него.
// Соответственно, разные разработчики могут назвать свои классы одинаковым именем,
// ваш загрузчик должен корректно это обрабатывать.
// PluginManager ищет скомпилированные классы плагина
// в папке pluginRootDirectory\pluginName\

public class PluginManager {
    private final String pluginRootDirectory;

    public PluginManager(String pluginRootDirectory){
        this.pluginRootDirectory = pluginRootDirectory;
    }

    public Plugin load(String pluginName, String pluginClassName){

        return null;
    }
}
