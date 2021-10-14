package theme17spring;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {
private final ReadUrlStrFromFile readUrlStrFromFile;
private final ExecutorService executorService;
private final String path = "C:\\temp\\res\\";
private final String fileWithUrls = "src\\main\\java\\theme17spring\\weblinks.txt";
private final int rateLimit = 500;  //Kb per sek

    public FileDownloader(ReadUrlStrFromFile readUrlStrFromFile, ExecutorService executorService) {
        this.readUrlStrFromFile = readUrlStrFromFile;
        this.executorService = executorService;
    }

    public void start() {
        List<String> list = readUrlStrFromFile.read(fileWithUrls);  //Read list of urls from file
        for (String urlStr : list) {
            executorService.submit(new DownloadTask(urlStr, path, rateLimit));
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        FileDownloader fileDownloader = new FileDownloader(
                new ReadUrlStrFromFileImpl(),
                Executors.newFixedThreadPool(3));
        fileDownloader.start();
    }
}

