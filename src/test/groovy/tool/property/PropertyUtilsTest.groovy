package tool.property

import groovy.util.GroovyTestCase

class PropertyUtilsTest extends GroovyTestCase {

    void testSetGetProperties() {
        PropertyUtils utils = new PropertyUtils()

        Properties properties =  utils.getProperties()
        def host = properties.getProperty("DB_HOST")
        println(host)

        assert host == "dummy"
    }
}
