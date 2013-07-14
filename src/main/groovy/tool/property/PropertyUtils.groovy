package tool.property

/**
 * .propertiesにアクセスして値を返却する
 *
 */
class PropertyUtils {

    public Properties getProperties() {
        Properties properties = new Properties()

        try {
            properties.load(getClass().getResourceAsStream("/properties/.properties"))

        } catch(FileNotFoundException e) {
           e.printStackTrace()
            throw new RuntimeException("error")

        } catch(IOException e) {
            e.printStackTrace()
            throw new RuntimeException("error")

        } catch(Exception e) {
            e.printStackTrace()
            throw new RuntimeException("other error")
        }

        return properties
    }

}
