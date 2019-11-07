package com.patrol.repository;

import com.patrol.domain.User;
import com.patrol.repository.plus.UserRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

/***
 * 用户Repository
 *
 * @author WangSheng/2019-10-23
 */
public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {

    User findByMobile(String mobile);

    User findByNick(String nick);
}
