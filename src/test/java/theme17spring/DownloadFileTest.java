package theme17spring;

import org.junit.Test;

import java.io.IOException;

public class DownloadFileTest {
    DownloadFileImpl downloadFileImp = new DownloadFileImpl();
    String path = "C:\\Users\\USER\\OneDrive\\BBdocuments\\IdeaProjects\\sberJavaSchool02\\resources\\";
    String urlStr = "https://c.stocksy.com/a/s0V000/z9/119218.jpg";
    String fullPathToFile;

    @Test
    public void createDestinationFile() {
        fullPathToFile = downloadFileImp.createDestinationFile(path, urlStr);
        System.out.println(fullPathToFile);
    }

    @Test
    public void downloadOneFile()  {
        downloadFileImp.download(urlStr, downloadFileImp.createDestinationFile(path, urlStr), 15);
    }


}