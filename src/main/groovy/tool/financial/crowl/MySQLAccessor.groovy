package tool.financial.crowl

import groovy.sql.Sql

class MySQLAccessor {

    def connect = Sql.newInstance(
    "jdbc:mysql://myhost/mydb?characterEncoding=utf8",
    "myuser",
    "mypass",
    "com.mysql.jdbc.Driver")

}
