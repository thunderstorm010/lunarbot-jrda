package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class KelimeTuretmece: ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.author.isBot) return
        if (event.channel != event.jda.getTextChannelById(738553651655737376)) return
        event.channel.retrieveMessageById(event.channel.latestMessageIdLong).queue {
            if (event.message.contentRaw.first() != it.contentRaw.last()) {
                event.message.delete().queue()
            }
        }

    }
}