package Theme07ClassLoaders.Task01;
// Ваша задача написать загрузчик плагинов в вашу систему. Допустим вы пишите свой
// браузер и хотите чтобы люди имели имели возможность писать плагины для него.
// Соответственно, разные разработчики могут назвать свои классы одинаковым именем,
// ваш загрузчик должен корректно это обрабатывать.
// PluginManager ищет скомпилированные классы плагина
// в папке pluginRootDirectory\pluginName\

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class PluginManager {
    private final File  pluginRootDirectory;

    public PluginManager(String pluginRootDirectory){
        this.pluginRootDirectory = new File(pluginRootDirectory);
    }

    public Plugin load(String pluginName, String pluginClassName){

        return new Plugin() {
            @Override
            public void doUseful() {

            }
        };
    }

    public void initializePlugin(){
        List<File> allPlugins = getAllPath();
        for (File file: allPlugins){
            String pluginName = file.getName();
        }

    }

    public void startAll(){

    }

    private List<File> getAllPath(){
        List<File> listResult = new LinkedList<>();
        File[] files = pluginRootDirectory.listFiles();
        assert  files != null;
        return listResult;
    }
}
