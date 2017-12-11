package in.poojapatel.server.repository;
import in.poojapatel.server.entity.Content;
import in.poojapatel.server.entity.Mapping;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface ContentRepository extends CrudRepository<Content,Integer> {
  Content findAllByUseridAndOriginalname(int userid, String root);
  List<Content> findAllByContentidIn( List<Integer> contentid);
  List<Content> findAllByUserid(int userid);
}
