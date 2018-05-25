package ToolUtil;

public class PermissionsObj {
    private String Permissionskey;
    private String PermissionsName;
    private String PermissionsExplan;

    public PermissionsObj(String a, String b, String c) {
    Permissionskey=a;
    PermissionsName=b;
    PermissionsExplan=c;

    }

    public String getPermissionskey() {
        return Permissionskey;
    }

    public void setPermissionskey(String permissionskey) {
        Permissionskey = permissionskey;
    }

    public String getPermissionsName() {
        return PermissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        PermissionsName = permissionsName;
    }

    public String getPermissionsExplan() {
        return PermissionsExplan;
    }

    public void setPermissionsExplan(String permissionsExplan) {
        PermissionsExplan = permissionsExplan;
    }

}
