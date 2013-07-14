package tool.dbagent

import java.sql.Connection
import java.sql.DriverManager

class MySQLAccessor {

    public static Connection getConnect()  {
        Properties prop = new Properties()

        String user = ""
        String pass = ""
        String host = ""
        String name = ""

        try {
            InputStream is = new FileInputStream(new File(".properties"))
            prop.load(is)

            user = prop.getProperty("DB_USER")
            pass = prop.getProperty("DB_PASS")
            host = prop.getProperty("DB_HOST")
            name = prop.getProperty("DB_NAME")

        } catch (IOException e) {
            e.printStackTrace()
        }
        Class.forName("com.mysql.jdbc.Driver").newInstance()
        return DriverManager.getConnection("jdbc:mysql://" + host  + "/" + name + "?characterEncoding=utf8",user,pass)
    }

}
