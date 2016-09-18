package com.bcrusu.cspreporting.core.writers.elasticsearch

import com.bcrusu.cspreporting.config.ElasticsearchConfiguration
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import java.net.InetAddress
import javax.inject.Inject
import javax.inject.Provider

class TransportClientProvider @Inject constructor(val config: ElasticsearchConfiguration) : Provider<TransportClient> {
    private val DEFAULT_ADDRESS = "localhost"
    private val DEFAULT_PORT = 9300

    override fun get(): TransportClient {
        val settingsBuilder = Settings.settingsBuilder()
                .put("client.transport.sniff", true)

        if (config.clusterName != null)
            settingsBuilder.put("cluster.name", config.clusterName)

        val settings = settingsBuilder.build()
        val address = config.address ?: DEFAULT_ADDRESS
        val port = config.port ?: DEFAULT_PORT

        return TransportClient.builder()
                .settings(settings)
                .build()
                .addTransportAddress(InetSocketTransportAddress(InetAddress.getByName(address), port))
    }
}
