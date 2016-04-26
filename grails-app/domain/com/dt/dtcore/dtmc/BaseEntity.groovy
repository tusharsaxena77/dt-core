package com.dt.dtcore.dtmc

class BaseEntity {

    Date dateCreated
    Date lastUpdated
    String lastUpdatedBy
    Boolean isDeleted =false

    static constraints = {
        dateCreated(nullable: true)
        lastUpdated(nullable: true)
        lastUpdatedBy(nullable: true)
        isDeleted(nullable: true)
    }
}
