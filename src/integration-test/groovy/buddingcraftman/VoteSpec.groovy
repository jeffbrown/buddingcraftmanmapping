package buddingcraftman

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.http.HttpStatus.CREATED

@Integration
class VoteSpec extends Specification {

    @Shared
    def rest = new RestBuilder()

    void 'test saveVote'() {
        when:
        def resp = rest.post("http://localhost:${serverPort}/api/votes") {
            json {
                name = 'Some Name'
            }
        }

        then:
        resp.status == CREATED.value()
    }
}