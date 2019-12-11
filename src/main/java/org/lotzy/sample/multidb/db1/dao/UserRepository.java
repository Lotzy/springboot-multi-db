package org.lotzy.sample.multidb.db1.dao;

import org.lotzy.sample.multidb.db1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <pre>
 * Title: UserRepository interface
 * Description: JPA Repository interface declaration
 * </pre>
 *
 * @author Lotzy
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, String> {

}
