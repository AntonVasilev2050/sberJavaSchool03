package theme17spring;

import java.util.List;

public class FileDownloader {
    ReadUrlStrFromFile readUrlStrFromFile = new ReadUrlStrFromFileImpl();
    DownloadFileImpl downloadFileImp = new DownloadFileImpl();
    String path = "C:\\Users\\USER\\OneDrive\\BBdocuments\\IdeaProjects\\sberJavaSchool02\\resources\\";
    String fileWithUrls = "src\\main\\java\\theme17spring\\weblinks.txt";
    String fullPathToFile;

    public void start(){
        List<String > list = readUrlStrFromFile.read(fileWithUrls);
    }
    //Read list of urls from file

//    Create empty files in destination folder
//    Download files

}
