package com.fernando.controleremoto.viewmodel

import okhttp3.OkHttpClient
import okhttp3.Request

object Tv{
    // Estabelece a conexão com a TV
    private val client = OkHttpClient()
    private val tvIpAddress = "192.168.1.101" // Substitua pelo endereço IP da sua TV

    fun sendCommandToTV(command: String) {
        val url = "http://$tvIpAddress/$command"
        val request = Request.Builder()
            .url(url)
            .build()
        client.newCall(request).execute().close()
    }
}
