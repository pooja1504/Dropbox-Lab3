package in.poojapatel.server.entity.request;

public class Folder {
    int userid;
    int contentid;
    String  foldername;
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getFoldername() {
        return foldername;
    }
    public void setFoldername(String foldername) {
        this.foldername = foldername;
    }
    public int getContentid() {
        return contentid;
    }
    public void setContentid(int contentid) {
        this.contentid = contentid;
    }
}
