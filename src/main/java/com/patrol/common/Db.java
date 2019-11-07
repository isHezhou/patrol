package com.patrol.common;

import org.hibernate.transform.Transformers;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Db {

    private EntityManager entityManager;

    private Db(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public static Db use(EntityManager entityManager) {
        return new Db(entityManager);
    }


    public List<Map<String,Object>> query(String sql){
        return execute(sql,0,0, null);
    }

    public List<Map<String,Object>> query(String sql,Object... params){
        return execute(sql,0,0,params);
    }

    public List<Map<String,Object>> query(String sql,int page, int size,Object... params){
        if(page>0 && size>0){
            sql = sql+" limit "+ (page-1)*size+" ," + size;
        }
        return execute(sql,params);
    }

    public Map<String,Object> queryFirst(String sql){
        List<Map<String,Object>> result = execute(sql,0,0, null);
        return result  == null ? null : result.get(0);
    }

    public Pageable query(String sql, int page, Object... params){
        String _temp_sql_ = "";
        if(page>0){
            _temp_sql_ = sql+" limit "+ (page-1)* Constants.DEFAULT_PAGE_SIZE +" ," + Constants.DEFAULT_PAGE_SIZE;
        }
        List<Map<String,Object>> objList = execute(_temp_sql_,params);
        int objCount = count(sql,params);
        return Pageable.success(objList,objCount,page,Constants.DEFAULT_PAGE_SIZE);
    }

    public void update (String sql, Object... params){
        Query query = entityManager.createNativeQuery(sql.toLowerCase());
        if(params!=null && params.length>0){
            for (int i = 0; i < params.length; i++) {
                query.setParameter((i+1),params[i]);
            }
        }
        query.executeUpdate();
    }

    private List<Map<String,Object>> execute (String sql, Object... params){
        String _sql_ = sql.toLowerCase();
        Query query = entityManager.createNativeQuery(_sql_);
        if(params!=null && params.length>0){
            for (int i = 0; i < params.length; i++) {
                query.setParameter((i+1),params[i]);
            }
        }
        query.unwrap(org.hibernate.SQLQuery.class)
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

    private int count (String sql, Object... params){
        String _sql_count_ = getCountSql(sql.toLowerCase());
        Query query = entityManager.createNativeQuery(_sql_count_);
        if(params!=null && params.length>0){
            for (int i = 0; i < 1; i++) {
                query.setParameter((i+1),params[i]);
            }
        }
        List result = query.getResultList();
        int count = 0;
        if(result!=null && result.size()>0){
            count = ((BigInteger)result.get(0)).intValue();
        }
        return count;
    }


    private static String getCountSql(String sql){
        String reg = "select\\s+((.*))\\s+from";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher= pattern.matcher(sql.toLowerCase());
        if (matcher.find( )) {
            return sql.replaceAll(matcher.group(1)," count(*) count ");
        }
        return null;
    }

    public static void main(String[] args) {
        String sql = "select id,nick,mobile,email,ip,modify_date,create_date from sys_user where id=1";
        System.err.println(getCountSql(sql));
    }
}
