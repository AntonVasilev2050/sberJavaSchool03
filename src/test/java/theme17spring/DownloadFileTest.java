package theme17spring;

import org.junit.Test;

public class DownloadFileTest {
    DownloadFileImp downloadFileImp = new DownloadFileImp();
    String path = "C:\\Users\\USER\\OneDrive\\BBdocuments\\IdeaProjects\\sberJavaSchool02\\resources\\";
    String urlStr = "https://uprostim.com/wp-content/uploads/2021/05/image005-8.jpg";
    String fullPathToFile;

    @Test
    public void createDestinationFile() {
        fullPathToFile = downloadFileImp.createDestinationFile(path, urlStr);
        System.out.println(fullPathToFile);
    }

    @Test
    public void downloadOneFile() {
        downloadFileImp.download(urlStr, downloadFileImp.createDestinationFile(path, urlStr), 15);
    }


}