package in.poojapatel.server.repository;
import in.poojapatel.server.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByEmail(String email);
    User findUsersByEmailAndPassword(String email, String password);
}
