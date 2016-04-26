package com.dt.dtcore.dtmc

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='emailId')
@ToString(includes='emailId', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final long serialVersionUID = 1

    transient springSecurityService

    String emailId
    String password
    String firstName
    String lastName
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    User(String emailId, String password) {
        this()
        this.emailId = emailId
        this.password = password
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this)*.role
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }

    static transients = ['springSecurityService']

    static constraints = {
        password blank: false, password: true
        emailId blank: false, unique: true
    }

    static mapping = {
        password column: '`password`'
    }
}
