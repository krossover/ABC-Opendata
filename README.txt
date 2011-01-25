Grails, Spring Security, and MongoDB
====================================

Notes:
All this documentation is based on the mongoDB plugin (http://www.grails.org/plugin/mongodb & http://grails.github.com/inconsequential/mongo), and not the gorm-mongoDB plugin (http://www.grails.org/plugin/gorm-mongodb) that has different configuration, location of groovy files and other non-compatible changes. The benefits of using the mongoDB plugin are, apart from the SpringSource company support, that all groovy files and configuration are located in the default places (like domain folder and DataSource.groovy file).

1. Prerequisites:
    - Grails 1.3.6 is setup

2. Create the app:
        grails create-app

3. Setup the plugins:
        grails uninstall-plugin hibernate
        grails install-plugin spring-security-core
        grails install-plugin mongodb

4. Modify the DataSource.groovy config file to have Mongodb specific configuration.  Remove all the hibernate specific configuration.

5. Setup Mongodb:
    - Make sure Mongodb is running (<MONGODB_HOME>/bin/mongod)
    - Startup the Mongodb shell (<MONGODB_HOME>/bin/mongo)
    - Switch to the database specified in the grails config: > use xxx
    - Create the user specified in the grails config: > db.addUser("test","test");

6. Run the application.
    - Using the built-in Grails CRUD pages, create a role named 'ROLE_USER'
    - Create a user (with the enabled property checked)
    - Create a UserRole that specifies the user and role just created
    - browse to the SecureController and voila!

7. Next Steps:
    - refactor UserRole so HQL isn't used because it isn't supported in the Mongodb GORM implementation
    - probably not a bad idea to secure the User, Role, and UserRole controllers :)
    - setup tests for all the objects created

8. References:
    - Grails Doc: <http://www.mongodb.org/display/DOCS/Tutorial>
    - Grails Mongodb plugin Doc: <http://grails.github.com/inconsequential/mongo/manual/index.html>
    - Mongodb: <http://www.mongodb.org/display/DOCS/Tutorial>
    - Spring Security Core Grails plugin: <http://www.mongodb.org/display/DOCS/Tutorial>
    - Chris Smith (evilangelist) Grails example: <https://github.com/evilangelist/grails-spring-security-mongodb>
