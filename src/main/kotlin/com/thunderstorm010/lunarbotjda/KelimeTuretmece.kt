package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class KelimeTuretmece: ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.author.isBot) return
        if (event.channel != event.jda.getTextChannelById(738553651655737376)) return
        if (event.channel.history.getMessageById(event.channel.latestMessageIdLong)!!.contentRaw.last() != event.message.contentRaw.first() ) {
            event.message.delete().queue()
        }

    }
}