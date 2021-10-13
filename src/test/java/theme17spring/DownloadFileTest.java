package theme17spring;

import org.junit.Test;

public class DownloadFileTest {
    DownloadFileImp downloadFileImp = new DownloadFileImp();

    @Test
    public void downloadOneFile(){
        String file = "C:\\Users\\USER\\OneDrive\\BBdocuments\\IdeaProjects\\sberJavaSchool02\\resources\\fff";
        String urlStr = "https://uprostim.com/wp-content/uploads/2021/05/image005-8.jpg";
        downloadFileImp.download(urlStr, file, 50);
    }

}