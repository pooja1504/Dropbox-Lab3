package in.poojapatel.server.controller;
import in.poojapatel.server.entity.Content;
import in.poojapatel.server.entity.User;
import in.poojapatel.server.entity.request.Folder;
import in.poojapatel.server.entity.response.ContentLoadResponse;
import in.poojapatel.server.entity.response.Response;
import in.poojapatel.server.entity.response.RootResponse;
import in.poojapatel.server.service.ContentService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/folder")
public class ContentController  {

    @Autowired
    private ContentService contentService;

    private static String UPLOADED_FOLDER = System.getProperty("user.dir")+ "/src/main/resources/static/";

    @RequestMapping(path="/upload",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ContentLoadResponse fileupload(@RequestParam("file") MultipartFile multipartFile,
                                          @RequestParam("filep") String fileparent,
                                          @RequestParam("email") String userid){

        Content content = new Content();
        Date date = new Date();
        String virtualname= date+"_"+ multipartFile.getOriginalFilename();
        String filepath = UPLOADED_FOLDER + virtualname;
        Response response = new Response();
        ContentLoadResponse contentLoadResponse = new ContentLoadResponse();
        try {
            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get(filepath);
            Files.write(path, bytes);
            contentLoadResponse = contentService.UploadFile(multipartFile.getOriginalFilename(),
                    virtualname,Integer.parseInt(fileparent),Integer.parseInt(userid));
        } catch (IOException e) {
            response.setStatus("error");
            response.setMsg("Error in uploading, Please Try Again.");
            contentLoadResponse.setContents(null);
            contentLoadResponse.setResponse(response);
        }
        return contentLoadResponse;
    }
    @RequestMapping(path="/getroot",method = RequestMethod.POST)
    public RootResponse getRoot(@RequestBody User user) {
        // This returns a JSON with the users
        return contentService.getRoot(user);
    }
    @RequestMapping(path="/createfolder",method = RequestMethod.POST)
    public ContentLoadResponse CreateFolder(@RequestBody Folder folder) {
        return contentService.CreateFolder(folder);
    }
    @RequestMapping(path="/getfolderdata",method = RequestMethod.POST)
    public ContentLoadResponse getFolderData(@RequestBody Folder folder) {
        // This returns a JSON with the users
        return contentService.getFolderData(folder);
    }
}
