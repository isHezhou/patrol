package com.patrol.repository.plus.impl;


import com.patrol.common.Db;
import com.patrol.common.Pageable;
import com.patrol.common.utils.StringKit;
import com.patrol.repository.plus.UserRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * 自定义用户Repository实现类
 *
 * @author WangSheng/2019-10-23
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pageable findByParams(Map<String, String> param) {
        StringBuffer sql = new StringBuffer("select id,nick,mobile,email,ip,modify_date,create_date from sys_user where 1=1");

        String nick = param.get("nick");
        String mobile = param.get("mobile");
        String email = param.get("email");
        int page = StringKit.isEmpty(param.get("page")) ? 1 : Integer.parseInt(param.get("page"));

        List<Object> paramList = new ArrayList<>();

        if(!StringKit.isEmpty(nick)){
            sql.append(" and nick = ?");
            paramList.add(nick);
        }

        if(!StringKit.isEmpty(mobile)){
            sql.append(" and mobile = ?");
            paramList.add(mobile);
        }

        if(!StringKit.isEmpty(email)){
            sql.append(" and email = ?");
            paramList.add(email);
        }

        return Db.use(entityManager).query(sql.toString(),page,paramList.toArray());
    }
}
