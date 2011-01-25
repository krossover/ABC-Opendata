grails {
    mongo {
        host = "localhost"
        port = 27017
        databaseName = "loststone-dev"
    }
}

// environment specific settings
environments {
    development {
        grails {
            mongo {
                // username = ""
                // password = ""
            }
        }
    }
    test {
        grails {
            mongo {
                // username = ""
                // password = ""
                databaseName = "loststone-test"
            }
        }
    }   
    production {
        grails {
            mongo {
                // username = "loststone"
                // password = "live-pass"
                // databaseName = "loststone"
            }
        }
    }
}
