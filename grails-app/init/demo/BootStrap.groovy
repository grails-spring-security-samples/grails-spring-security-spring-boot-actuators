package demo

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    def init = { servletContext ->
        User user = new User(username: 'admin', password: 'admin')
        user.save(failOnError: true)
        Role role  = new Role(authority: 'ROLE_USER')
        role.save(failOnError: true)
        new UserRole(user: user, role: role).save()
    }
    def destroy = {
    }
}
