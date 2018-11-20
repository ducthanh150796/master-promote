package e.com.lib;

public class Promote {
    private boolean isShow;
    private String mImage;
    private String banner;
    private String packageName;
    private String description;
    private String title;

    public Promote(boolean isShow, String mImage, String banner, String packageName, String description, String title) {
        this.isShow = isShow;
        this.mImage = mImage;
        this.banner = banner;
        this.packageName = packageName;
        this.description = description;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
