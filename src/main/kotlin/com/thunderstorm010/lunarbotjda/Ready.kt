package com.thunderstorm010.lunarbotjda

import com.thunderstorm010.lunarbotjda.BotProperties
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class Ready: ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        event.jda.presence.setPresence(BotProperties.BOT_DEFAULT_STATUS, BotProperties.BOT_DEFAULT_ACTIVITY_TYPE)
    }
}