package theme17spring;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader {
    String path = "C:\\Users\\USER\\OneDrive\\BBdocuments\\IdeaProjects\\sberJavaSchool02\\resources\\";
    String fileWithUrls = "src\\main\\java\\theme17spring\\weblinks.txt";
    int rateLimit = 300; //Kb per sek

    public void start() {
        //Read list of urls from file
        ReadUrlStrFromFile readUrlStrFromFile = new ReadUrlStrFromFileImpl();
        List<String> list = readUrlStrFromFile.read(fileWithUrls);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (String urlStr : list) {
            executorService.submit(new DownloadTask(urlStr, path, rateLimit));
        }
        executorService.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        FileDownloader fileDownloader = new FileDownloader();
        fileDownloader.start();
    }
}

