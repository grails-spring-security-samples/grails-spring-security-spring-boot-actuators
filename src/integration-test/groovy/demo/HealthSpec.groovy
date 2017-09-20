package demo

import geb.spock.GebSpec
import grails.gorm.transactions.Rollback
import grails.testing.mixin.integration.Integration

/**
 * See http://www.gebish.org/manual/current/ for more instructions
 */
@Integration
@Rollback
class HealthSpec extends GebSpec {

    void "test /health endpoint is available after login"() {
        when:"The health endpoint is visited"
        go '/health'

        then:"The authentication page is displayed"
        title == "Login"

        when:
        $('#username', 0) << 'admin'
        $('#password', 0) << 'admin'
        $('#submit', 0).click()

        then:"The health info is displayed"
        browser.driver.pageSource.contains('{"status":"UP"}')
    }
}
