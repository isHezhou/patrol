package com.patrol.repository.plus;


import com.patrol.common.Pageable;

import java.util.Map;

/***
 * 自定义用户Repository
 *
 * @author WangSheng/2019-10-23
 */
public interface UserRepositoryCustom {

    Pageable findByParams(Map<String, String> param);

}
