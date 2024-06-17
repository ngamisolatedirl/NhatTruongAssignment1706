package assignment1706.nhattruong.jpaRepository.consts;

public class SqlQueryConstants {
    public static final String SQL_SELECT_ALL = "select * from %table_name% limit 100 offset 1";
    public static final String SQL_INSERT = "insert into %table_name% (id,fullname,birthday,address,position,department ) values (?,?,?,?,?,?)";

}
