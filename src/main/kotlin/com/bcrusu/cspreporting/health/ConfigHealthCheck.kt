package com.bcrusu.cspreporting.health

import com.codahale.metrics.health.HealthCheck

class ConfigHealthCheck() : HealthCheck() {
    override fun check(): HealthCheck.Result {
        // TODO

        return HealthCheck.Result.healthy()
    }
}
