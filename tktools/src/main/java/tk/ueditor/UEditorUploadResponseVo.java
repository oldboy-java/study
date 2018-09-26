package tk.ueditor;

/**
 * Created by Administrator on 2018-9-11.
 */
public class UEditorUploadResponseVo {
    private String original;//原始名称
    private String state;//状态，成功上传必须设置为SUCCESS
    private String title;//文件名称
    private String type;//文件扩展名（含.）
    private String url; //文件地址
    private String size; //文件长度

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
