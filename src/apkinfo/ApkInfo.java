package apkinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApkInfo {

    public static final String APPLICATION_ICON_120 = "application-icon-120";
    public static final String APPLICATION_ICON_160 = "application-icon-160";
    public static final String APPLICATION_ICON_240 = "application-icon-240";
    public static final String APPLICATION_ICON_320 = "application-icon-320";

    // 所需设备属性
    private List<String> features;
    // 图标
    private String icon;
    // 各分辨率下图标路径
    private Map<String, String> icons;
    // 应用程序名
    private String label;
    private Map<String, String> AppName;
    private List<String> AppNameKey;
    // 入口Activity
    private String launchableActivity;
    // 支持的Android平台最低版本号
    private String minSdkVersion;
    // 主包名
    private String packageName;
    // 支持的SDK版本
    private String sdkVersion;
    // Apk文件大小（字节）
    private long size;
    // 目标SDK版本
    private String targetSdkVersion;
    // 所需权限
    private List<String> usesPermissions;
    // 内部版本号

    public List<String> getAppNameKey() {
        return AppNameKey;
    }

    private String versionCode;
    // 外部版本号
    private String versionName;

    public void addAppNameKey(String key) {
        this.AppNameKey.add(key);
    }

    public ApkInfo() {
        this.features = new ArrayList<>();
        this.icons = new HashMap<>();
        this.AppName = new HashMap<>();
        this.AppNameKey=new ArrayList<>();
        this.usesPermissions = new ArrayList<>();
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public void addToFeatures(String feature) {
        this.features.add(feature);
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Map<String, String> getIcons() {
        return icons;
    }

    public void setIcons(Map<String, String> icons) {
        this.icons = icons;
    }

    public void addToIcons(String key, String value) {
        this.icons.put(key, value);
    }

    public Map<String, String> getAppName() {
        return AppName;
    }

    public void setAppName(Map<String, String> appName) {
        AppName = appName;
    }

    public void addAppName(String key, String value) {
        this.AppName.put(key, value);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLaunchableActivity() {
        return launchableActivity;
    }

    public void setLaunchableActivity(String launchableActivity) {
        this.launchableActivity = launchableActivity;
    }

    public String getMinSdkVersion() {
        return minSdkVersion;
    }

    public void setMinSdkVersion(String minSdkVersion) {
        this.minSdkVersion = minSdkVersion;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getTargetSdkVersion() {
        return targetSdkVersion;
    }

    public void setTargetSdkVersion(String targetSdkVersion) {
        this.targetSdkVersion = targetSdkVersion;
    }

    public List<String> getUsesPermissions() {
        return usesPermissions;
    }

    public void setUsesPermissions(List<String> usesPermissions) {
        this.usesPermissions = usesPermissions;
    }

    public void addToUsesPermissions(String usesPermission) {
        this.usesPermissions.add(usesPermission);
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    @Override
    public String toString() {
        return "ApkInfo [features=" + features + ", icon=" + icon + ", icons=" + icons + ", label=" + label
                + ", launchableActivity=" + launchableActivity + ", minSdkVersion=" + minSdkVersion + ", packageName="
                + packageName + ", sdkVersion=" + sdkVersion + ", size=" + size + ", targetSdkVersion="
                + targetSdkVersion + ", usesPermissions=" + usesPermissions + ", versionCode=" + versionCode
                + ", versionName=" + versionName + "]";
    }

}