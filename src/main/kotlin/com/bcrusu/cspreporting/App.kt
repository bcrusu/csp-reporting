package com.bcrusu.cspreporting

import com.bcrusu.cspreporting.resources.ReportResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class App : Application<AppConfiguration>() {
    override fun getName(): String {
        return "hello-world"
    }

    override fun initialize(bootstrap: Bootstrap<AppConfiguration>) {

    }

    override fun run(config: AppConfiguration, env: Environment) {
        val resource =  ReportResource()
        env.jersey().register(resource)
    }
}
