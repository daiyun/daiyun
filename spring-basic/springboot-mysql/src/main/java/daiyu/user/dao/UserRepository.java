package daiyu.user.dao;

import daiyu.user.vo.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>, JpaSpecificationExecutor {
}
