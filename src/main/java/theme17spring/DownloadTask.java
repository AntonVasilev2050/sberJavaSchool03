package theme17spring;

public class DownloadTask implements Runnable{
    private final String urlStr;
    private final String path;
    private final int rateLimit;

    public DownloadTask(String urlStr, String path,  int rateLimit) {
        this.urlStr = urlStr;
        this.path = path;
        this.rateLimit = rateLimit;
    }

    @Override
    public void run() {
        DownloadFile downloadFile = new DownloadFileImpl();
        String fullPathToFile = downloadFile.createDestinationFile(path, urlStr);
        downloadFile.download(urlStr, fullPathToFile, rateLimit);
    }
}
