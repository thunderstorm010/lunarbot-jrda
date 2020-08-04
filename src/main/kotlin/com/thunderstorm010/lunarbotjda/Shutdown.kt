package com.thunderstorm010.lunarbotjda

import com.thunderstorm010.lunarbotjda.BotProperties
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class Shutdown : ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.author.id != BotProperties.BOT_OWNER_ID) return
        if (event.message.contentRaw != "!shutdown") return
        event.message.channel.sendMessage("Bot durduruluyor... ").queue()
        event.jda.presence.setPresence(OnlineStatus.INVISIBLE, false)
        event.jda.shutdown()
    }


}