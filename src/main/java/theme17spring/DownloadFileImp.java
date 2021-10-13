package theme17spring;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadFileImp implements DownloadFile {
    private static int count;
    private static byte[] buffer;
    private static URL url;
    private static BufferedInputStream bis;
    private static FileOutputStream fos;
    private static int n;

    @Override
    public String createDestinationFile(String path, String urlStr) {
        int lastSlashIndex = 0;
        for (int i = urlStr.length() - 1; i >= 0; i--) {
            char c = urlStr.charAt(i);
            if(c == '/'){
                lastSlashIndex = i;
                break;
            }
        }
        String fileName = urlStr.substring(lastSlashIndex +1);

//      Create File
        try {
            File file = new File(path);
            file.mkdirs();
            file = new File(path + fileName);
            file.createNewFile();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return path + fileName;
    }

    @Override
    public void download(String urlStr, String fullPathToFile, int rateLimit) {
        try {
            url = new URL(urlStr);
            bis = new BufferedInputStream(url.openStream());
            fos = new FileOutputStream(fullPathToFile);
            buffer = new byte[1024];
            count = 0;
            count = bis.read(buffer, 0, 1024);
            int finished;
            do {
                n = rateLimit;
                finished = downloadOneSlot();
            } while (finished != -1);
            fos.close();
            bis.close();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    private int downloadOneSlot() throws IOException, InterruptedException {
        long before = System.currentTimeMillis();
        while (n != 0 && count != -1) {
            fos.write(buffer, 0, count);
            count = bis.read(buffer, 0, 1024);
            n--;
        }
        long timeToDownload = System.currentTimeMillis() - before;
        if (timeToDownload < 1000) {
            Thread.sleep(1000 - timeToDownload);
        }
        System.out.println("slot downloaded");
        return count;
    }
}
