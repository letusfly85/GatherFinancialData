package tool.dbagent

import tool.property.PropertyUtils

import java.sql.Connection
import java.sql.DriverManager

class MySQLAccessor {

    public static Connection getConnect()  {
        InputStream inputStream = getClass().getResourceAsStream("/properties/.properties")

        String user = ""
        String pass = ""
        String host = ""
        String name = ""

        try {
            PropertyUtils utils = new PropertyUtils()
            Properties properties = utils.getProperties(inputStream)

            user = properties.getProperty("DB_USER")
            pass = properties.getProperty("DB_PASS")
            host = properties.getProperty("DB_HOST")
            name = properties.getProperty("DB_NAME")

        } catch (IOException e) {
            e.printStackTrace()
        }
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        return DriverManager.getConnection("jdbc:mysql://" + host  + "/" + name + "?characterEncoding=utf8",user,pass)
    }

}
