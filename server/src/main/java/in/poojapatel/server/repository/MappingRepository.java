package in.poojapatel.server.repository;
import in.poojapatel.server.entity.Content;
import in.poojapatel.server.entity.Mapping;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface MappingRepository  extends CrudRepository<Mapping,Integer> {
        List<Mapping> findMappingByFolderidAndUserid(int folderid, int userid);
}
