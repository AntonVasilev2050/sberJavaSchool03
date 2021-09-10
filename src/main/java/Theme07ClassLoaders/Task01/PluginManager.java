package Theme07ClassLoaders.Task01;
// Ваша задача написать загрузчик плагинов в вашу систему. Допустим вы пишите свой
// браузер и хотите чтобы люди имели имели возможность писать плагины для него.
// Соответственно, разные разработчики могут назвать свои классы одинаковым именем,
// ваш загрузчик должен корректно это обрабатывать.
// PluginManager ищет скомпилированные классы плагина
// в папке pluginRootDirectory\pluginName\

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PluginManager {
    private final File pluginRootDirectory;
    private final List<Plugin> plugins = new LinkedList<>();
    private final ClassLoader pluginLoader;

    public PluginManager(String pluginRootDirectory) throws MalformedURLException {
        File rootDir = new File(pluginRootDirectory);
        if (!rootDir.isDirectory()) {
            throw new IllegalArgumentException("Переданный путь не является директорией");
        }
        this.pluginRootDirectory = rootDir;
        File file = new File(rootDir + "/HelloWorldPlugin");
        pluginLoader = new URLClassLoader(new URL[]{file.toURI().toURL()});
    }

    /**
     *
     * @param pluginName
     * @param pluginClassName
     * @return null if plugin not found
     */
    public Plugin load(String pluginName, String pluginClassName) {
        try {
            return (Plugin) pluginLoader.loadClass(pluginClassName).getConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Инициализирует все плагины из pluginRootDirectory
     */
    public void initializePlugin() {
        List<File> allPlugins = getAllPath();
        for (File file : allPlugins) {
            String pluginName = file.getName();
            plugins.add(load(pluginName, pluginName));
        }
    }

    /**
     * Запускает все имеющиеся плагины.  т.е вызывает метод doUsefull
     */
    public void startAll() {
        for (Plugin plugin : plugins) {
            plugin.doUseful();
        }
    }

    /**
     * @return все директории плагинов в рут директории
     */
    private List<File> getAllPath() {
        File[] files = pluginRootDirectory.listFiles();
        assert files != null;
        return Arrays.stream(files).filter(File::isDirectory).collect(Collectors.toList());
    }
}