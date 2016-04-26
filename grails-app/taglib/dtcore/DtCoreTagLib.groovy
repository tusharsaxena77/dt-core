package dtcore

import org.grails.exceptions.ExceptionUtils

class DtCoreTagLib {

    static namespace = "dtcore"
    static defaultEncodeAs = [taglib:'html']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def errorsViewStackTracePrinter

    def logAllExceptions = { Map attrs ->
        println("LogAllExceptions called of dtcore >>>> ")
        if (!(attrs?.exception instanceof Throwable)) {
            return
        }
        Throwable exception = (Throwable)attrs.exception
        def root = ExceptionUtils.getRootCause(exception)
        if (root) {
            root?.getClass()?.name ?: exception.getClass().name
            log.error("Exception CLASS >>> " + root?.getClass()?.name ?: exception.getClass().name)
            log.error("Exception MESSAGE >>> " + root.message)
        }
        def trace = errorsViewStackTracePrinter.prettyPrint(exception.cause ?: exception)
        log.error("Full stack trace :: " + trace)
    }


    def loggedInUserFirstName = {
        String userName = "Vaibhav"
        out << "${userName}"
    }
}
