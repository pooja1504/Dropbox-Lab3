package in.poojapatel.server.entity.response;
import in.poojapatel.server.entity.Content;
import java.util.List;
public class ContentLoadResponse {

    Response response;
    List<Content> contents;
    int parentfolderid;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public int getParentfolderid() {
        return parentfolderid;
    }

    public void setParentfolderid(int parentfolderid) {
        this.parentfolderid = parentfolderid;
    }
}
