package theme17spring;

public class DownloadTask implements Runnable{
    private String urlStr; // web link of the file to download
    private String path; //path to the folder where we save downloaded files
    private int rateLimit; // kB per sek

    public DownloadTask(String urlStr, String path, int rateLimit) {
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
