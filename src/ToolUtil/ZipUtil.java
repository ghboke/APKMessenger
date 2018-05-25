package ToolUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipUtil {
    public static List readZipFile(String file, String soDir) throws Exception {

        List<String> Sofilelist = new ArrayList<>();//加固文件列表
        ZipFile zf = new ZipFile(file);
        InputStream in = new BufferedInputStream(new FileInputStream(file));
        ZipInputStream zin = new ZipInputStream(in);
        ZipEntry ze;
        while ((ze = zin.getNextEntry()) != null) {
            if (ze.isDirectory()) {

            } else {
                String str = ze.getName();
                if (str.substring(0, 4).equals(soDir)) {
                    //System.out.println(str);
                    Sofilelist.add(str);

                }


            }
        }
        zin.closeEntry();
    return Sofilelist;
    }

}
