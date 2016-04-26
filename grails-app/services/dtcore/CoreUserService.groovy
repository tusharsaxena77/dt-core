package dtcore

import grails.transaction.Transactional

@Transactional
class CoreUserService {

    def serviceMethod() {

    }

    String testMethod(){
//        int i=5/0
        "A testing string from testMethod() of CoreUserService ..."

    }
}
