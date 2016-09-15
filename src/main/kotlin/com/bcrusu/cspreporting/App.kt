package com.bcrusu.cspreporting

import com.bcrusu.cspreporting.dwext.CspJacksonMessageBodyProvider
import com.bcrusu.cspreporting.health.ConfigHealthCheck
import com.bcrusu.cspreporting.resources.ReportResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class App : Application<AppConfiguration>() {
    override fun getName(): String {
        return "csp-reporting"
    }

    override fun initialize(bootstrap: Bootstrap<AppConfiguration>) {

    }

    override fun run(config: AppConfiguration, env: Environment) {
        // register the CSP report MIME type
        env.jersey().register(CspJacksonMessageBodyProvider(env.objectMapper))

        registerHealthChecks(env)
        registerResources(env)
    }

    private fun registerResources(env: Environment) {
        env.jersey().register(ReportResource())
    }

    private fun registerHealthChecks(env: Environment) {
        env.healthChecks().register("config", ConfigHealthCheck())
    }
}
