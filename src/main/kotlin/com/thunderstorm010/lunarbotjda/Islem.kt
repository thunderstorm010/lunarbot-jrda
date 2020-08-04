package com.thunderstorm010.lunarbotjda

import Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.mariuszgromada.math.mxparser.Expression

class Islem: ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.author.isBot) return
        if (!event.message.contentRaw.startsWith("!işlem")) return
        if (event.message.contentRaw.split(Regex(" "),2).getOrNull(1) == null) {
            EmbedBuilder()
                    .setAuthor(
                            event.author.name + "#" + event.author.discriminator + ", ",
                            null,
                            event.author.effectiveAvatarUrl
                    )
                    .setTitle("!işlem")
                    .setDescription("Yapılacak işlem belirtilmemiş.")
                    .setFooter(Main.footer_text, Main.footer_icon_url)
                    .build()
                    .let {
                        event.channel.sendMessage(it).queue()
                    }
            return
        }
        val expression = event.message.contentRaw.split(Regex(" "),2)[1]
        if (Expression(expression).calculate().toString() == "NaN") {
            EmbedBuilder()
                    .setAuthor(
                            event.author.name + "#" + event.author.discriminator + ", ",
                            null,
                            event.author.effectiveAvatarUrl
                    )
                    .setTitle("!işlem")
                    .setDescription("İşlem geçersiz.")
                    .setFooter(Main.footer_text, Main.footer_icon_url)
                    .build()
                    .let {
                        event.channel.sendMessage(it).queue()
                    }
            return
        }
        EmbedBuilder()
                .setAuthor(
                        event.author.name + "#" + event.author.discriminator + ", ",
                        null,
                        event.author.effectiveAvatarUrl
                )
                .setTitle("!işlem")
                .setDescription("Sonuç: " + Expression(expression).calculate().toString())
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
                .let {
                    event.channel.sendMessage(it).queue()
                }

    }
}