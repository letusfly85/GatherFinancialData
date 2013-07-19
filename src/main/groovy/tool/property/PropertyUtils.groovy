package tool.property

import org.apache.commons.io.FileUtils

/**
 * .propertiesにアクセスして値を返却する
 *
 */
class PropertyUtils {

    public Properties getProperties() {
        Properties properties = new Properties()

        try {
            InputStream inputStream = getClass().getResourceAsStream("/properties/.properties")
            properties.load(inputStream)

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException()

        } catch(IOException e) {
            e.printStackTrace()
            throw new IOException("error")
        }

        return properties
    }

}
