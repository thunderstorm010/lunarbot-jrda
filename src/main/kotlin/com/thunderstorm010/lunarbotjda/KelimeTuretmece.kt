package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.RestAction
import kotlin.properties.Delegates

class KelimeTuretmece: ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.author.isBot) return
        if (event.channel.idLong != 738851044724965439) return
        event.channel.canTalk()
        //var latest_message: Unit = event.channel.history.retrievePast(2)
        var last_content by Delegates.notNull<Char>()
        //latest_message.map { last_content = it[1].contentRaw.last() }



        println(event.message.contentRaw.first())
        println(last_content)
        if (event.message.contentRaw.first() != last_content) {
            event.message.delete().queue()
        }
    }

    }
