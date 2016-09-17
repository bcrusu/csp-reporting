package com.bcrusu.cspreporting

import com.bcrusu.cspreporting.dwext.CspJacksonMessageBodyProvider
import com.bcrusu.cspreporting.health.ConfigHealthCheck
import com.bcrusu.cspreporting.resources.ReportResource
import com.google.inject.Guice
import com.google.inject.Injector
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
        val injector = GuiceConfig.createInjector(config)

        // register the CSP report MIME type
        env.jersey().register(CspJacksonMessageBodyProvider(env.objectMapper))

        registerHealthChecks(env, injector)
        registerResources(env, injector)
    }

    private fun registerResources(env: Environment, injector: Injector) {
        env.jersey().register(injector.getInstance(ReportResource::class.java))
    }

    private fun registerHealthChecks(env: Environment, injector: Injector) {
        env.healthChecks().register("config", injector.getInstance(ConfigHealthCheck::class.java))
    }
}
