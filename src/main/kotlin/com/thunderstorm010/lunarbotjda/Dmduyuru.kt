package com.thunderstorm010.lunarbotjda

import Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.Duration


class Dmduyuru : ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (!event.message.contentRaw.startsWith("!dmduyuru")) return
        try {
            event.message.contentRaw.split(" ")[1]
        } catch (e: IndexOutOfBoundsException) {
            EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("!dmduyuru")
                .setDescription("Duyuru mesajı belirtilmemiş.")
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
                .let {
                    event.channel.sendMessage(it).queue()
                }
            return
        }
        if (event.member != event.guild.owner) {
            event.message.channel.sendMessage(
                EmbedBuilder()
                    .setAuthor(
                        event.author.name + "#" + event.author.discriminator + ", ",
                        null,
                        event.author.effectiveAvatarUrl
                    )
                    .setTitle("!dmduyuru")
                    .setDescription("Bunu yapmaya yetkin yok.")
                    .setFooter(Main.footer_text, Main.footer_icon_url)
                    .build()
            )
                .delay(Duration.ofSeconds(5))
                .flatMap { it.delete() }
                .queue()
            return
        }
        val embed2 = EmbedBuilder()
            .setAuthor(
                event.author.name + "#" + event.author.discriminator + ",",
                null,
                event.author.effectiveAvatarUrl
            )
            .setTitle("!dmduyuru")
            .setDescription("İşlem başlandı. İşlem bitince bu mesaj otomatik olarak silinecek.")
            .setFooter(Main.footer_text, Main.footer_icon_url)
            .build()
        event.message.channel.sendMessage(embed2).queue {
            val message = event.message.contentRaw.split(" ")[1]
            val embed = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("${BotProperties.DMDUYURU_EMBED_TITLE} yeni bir duyuru var!")
                .setDescription(message)
                .setFooter(
                    "Duyuruyu yapan: " + event.author.name + "#" + event.author.discriminator,
                    event.author.effectiveAvatarUrl
                )
                .build()
            event.guild.members.forEach { f ->
                if (f.user != f.jda.selfUser || !f.user.isBot) {
                    f.user.openPrivateChannel()
                        .queue {
                            it.sendMessage(embed).queue()
                        }
                }

            }
            it.delete().queue()
        }


    }
}