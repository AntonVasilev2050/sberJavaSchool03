package Theme08Serialization;

import java.util.Date;
import java.util.List;

public interface Service {
    int IN_MEMORY = 0;
    int FILE = 1;

    @Cache(cacheType = FILE, zip = true, accountableParameter = "0")
    List<String> run(String item, double value, Date date);

    @Cache(cacheType = FILE, zip = true, listList = 100_000)
    List<String> work(String item);

    @Cache(cacheType = FILE, zip = true, fileNamePrefix = "facto")
    int factorial(int number);

}
