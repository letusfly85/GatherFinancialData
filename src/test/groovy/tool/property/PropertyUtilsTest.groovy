package tool.property


//import groovy.util.GroovyTestCase
import spock.lang.*

class PropertyUtilsTest extends Specification {

    /*
    void testSetGetProperties() {
        PropertyUtils utils = new PropertyUtils()

        Properties properties =  utils.getProperties()
        def host = properties.getProperty("DB_HOST")
        println(host)

        assert host == "dummy"
    } */

    def "generate-utils-instance" () {

        PropertyUtils utils = new PropertyUtils()

        Properties properties =  utils.getProperties()
        def host = properties.getProperty("DB_HOST")
        println(host)

        expect:
        assert host == "dummy"

        /*
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
        */

    }
}
