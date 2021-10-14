package theme17spring;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class DownloadFileImpl implements DownloadFile {
    private int count;
    private static byte[] buffer;
    private URL url;
    private BufferedInputStream bis;
    private FileOutputStream fos;
    private int n;

    @Override
    public String createDestinationFile(String path, String urlStr) {
        int lastSlashIndex = 0;
        for (int i = urlStr.length() - 1; i >= 0; i--) {
            char c = urlStr.charAt(i);
            if (c == '/') {
                lastSlashIndex = i;
                break;
            }
        }
        String fileName = urlStr.substring(lastSlashIndex + 1);
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
    public void download(String urlStr, String fullPathToFile, int rateLimit){
        int slotCount = 0;
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
                slotCount++;
                System.out.println(slotCount + " slot downloaded (" + rateLimit + "Kb)");
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

        return count;
    }
}
