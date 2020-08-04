package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.Duration


class Otorun: ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        Thread {
            while (true) {
                event.jda.getTextChannelById(BotProperties.KAYIT_CHANNEL_ID)!!.sendMessage("!kayıt").delay(Duration.ofSeconds(1)).flatMap { it.delete() }.queue()
                Thread.sleep(1800000)
            }
        }

    }
}