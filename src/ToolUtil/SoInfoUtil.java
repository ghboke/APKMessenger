package ToolUtil;
//查壳工具
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoInfoUtil {
   private List<Map> Infolist = new ArrayList<>();

    public  SoInfoUtil() {
        //拆分本地文件
        try {
            File f = new File("src/res/soinfo.dat");
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(f), "utf-8");
                BufferedReader reader = new BufferedReader(read);
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] str = line.split("/");
                    String key = str[str.length - 1];
                    for (int i = 0; i < str.length - 1; i++) {
                        Map<String, String> Soinfo = new HashMap<>();
                        Soinfo.put(str[i], key);
                        Infolist.add(Soinfo);
                    }
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public String IsThisSo(String soname){
        for (Object o :Infolist){
            Map<String,String> map=(Map)o;
            for (Map.Entry<String, String> entry : map.entrySet()) {
               // System.out.println(entry.getKey() + ":" + entry.getValue());
                if (soname.equals(entry.getKey())){
                    return entry.getValue();
                }
            }
        }
        return "";
    }

}
