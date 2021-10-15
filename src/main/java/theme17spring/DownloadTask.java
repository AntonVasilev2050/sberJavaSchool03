package theme17spring;

public class DownloadTask implements Runnable{
    private final String urlStr; // web link of the file to download
    private final String path; //path to the folder where we save downloaded files
    private final int rateLimit; // kB per sek
    private final DownloadFile downloadFile;

    public DownloadTask(String urlStr, String path, int rateLimit) {
        this.urlStr = urlStr;
        this.path = path;
        this.rateLimit = rateLimit;
        downloadFile = new DownloadFileImpl();
    }

    @Override
    public void run() {
        String fullPathToFile = downloadFile.createDestinationFile(path, urlStr);
        downloadFile.download(urlStr, fullPathToFile, rateLimit);
    }
}
