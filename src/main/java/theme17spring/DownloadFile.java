package theme17spring;

public interface DownloadFile {
    String createDestinationFile(String path, String urlStr);
    void download(String urlStr, String fullPathToFile, int rateLimit);
}
