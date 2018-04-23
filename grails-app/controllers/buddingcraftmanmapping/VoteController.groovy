package buddingcraftmanmapping

import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.CREATED

class VoteController extends RestfulController<Vote> {
    static allowedMethods = [saveVote: 'POST']

    VoteController() {
        super(Vote)
    }

    def saveVote(VoteCommand command) {

        if (!command) {
            render status: notFound()

        } else if (command.hasErrors()) {
            respond command.errors, view: 'error'
        } else {
            render status: CREATED
        }
    }
}

class VoteCommand {
    String name
}
