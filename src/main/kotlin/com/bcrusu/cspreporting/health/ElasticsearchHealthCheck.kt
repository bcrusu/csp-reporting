package com.bcrusu.cspreporting.health

import com.codahale.metrics.health.HealthCheck
import org.elasticsearch.client.transport.TransportClient
import javax.inject.Inject

class ElasticsearchHealthCheck @Inject constructor(val transportClient: TransportClient) : HealthCheck() {
    override fun check(): HealthCheck.Result {
        val connectedNodes = transportClient.connectedNodes()

        if (connectedNodes.count() > 0)
            return HealthCheck.Result.healthy()

        return HealthCheck.Result.unhealthy("No active node connections.")
    }
}
