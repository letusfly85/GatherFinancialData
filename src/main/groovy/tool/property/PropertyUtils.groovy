package tool.property

import org.apache.commons.io.FileUtils

/**
 * .propertiesにアクセスして値を返却する
 *
 */
class PropertyUtils {

    public Properties getProperties(InputStream inputStream) {
        Properties properties = new Properties()

        try {
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
