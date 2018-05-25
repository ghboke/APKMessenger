package ToolUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PermissionsUtil {
    private List<String> List_PermissionsKey = new ArrayList();
    private List<String> List_PermissionsName = new ArrayList();
    private List<String> List_PermissionsNotes = new ArrayList();

    public List<String> getList_PermissionsKey() {
        return List_PermissionsKey;
    }

    public List<String> getList_PermissionsName() {
        return List_PermissionsName;
    }

    public List<String> getList_PermissionsNotes() {
        return List_PermissionsNotes;
    }

    public PermissionsUtil() {
        try {
            File f = new File("src/res/Permissionsinfo.dat");
            if (f.isFile() && f.exists()) {
                InputStreamReader read = new InputStreamReader(new FileInputStream(f), "utf-8");
                BufferedReader reader = new BufferedReader(read);
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] str = line.split("/");
                    for (int i = 0; i < str.length; i++) {
                        List_PermissionsKey.add(str[0]);
                        List_PermissionsName.add(str[1]);
                        List_PermissionsNotes.add(str[2]);
                    }
                }
                read.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
