package tool.property

import org.apache.commons.io.FileUtils
import spock.lang.*

class PropertyUtilsTest extends Specification {

    def "assert-host-name" (){

        PropertyUtils utils = new PropertyUtils()

        InputStream inputStream = getClass().getResourceAsStream("/properties/.properties")
        Properties properties =  utils.getProperties(inputStream)

        def host = properties.getProperty("DB_HOST")
        println(host)

        expect:
        assert host == "dummy"
    }

    def "throw file not found exception" (){
        setup:
        InputStream inputStream = getClass().getResourceAsStream("/properties/.properties.bk")
        PropertyUtils utils = new PropertyUtils()

        when:
        Properties properties = utils.getProperties(inputStream)

        then:
        thrown(NullPointerException.class)
    }
}
