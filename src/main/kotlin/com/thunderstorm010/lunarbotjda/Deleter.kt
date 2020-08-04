package com.thunderstorm010.lunarbotjda

import Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.Permission
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.Duration

class Deleter : ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.member!!.user.isBot) return
        if (!event.message.contentRaw.startsWith("!sil")) return
        if (!event.member!!.hasPermission(Permission.MESSAGE_MANAGE)) {
            val embed = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("!dmduyuru")
                .setDescription("Bunu yapmaya yetkin yok.")
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
            event.message.channel.sendMessage(embed)
                .delay(Duration.ofSeconds(3))
                .flatMap { it.delete() }
                .queue()
            return
        }
        if (!event.guild.selfMember.hasPermission(Permission.MESSAGE_MANAGE)) {
            if (event.guild.selfMember.hasPermission(Permission.MESSAGE_WRITE)) {
                val embed = EmbedBuilder()
                    .setAuthor(
                        event.author.name + "#" + event.author.discriminator + ", ",
                        null,
                        event.author.effectiveAvatarUrl
                    )
                    .setTitle("!dmduyuru")
                    .setDescription("Bu sunucuda \"Mesajları Yönet\" yetkim yok. Bu işlem gerçekleştirilemeyecek.")
                    .setFooter(Main.footer_text, Main.footer_icon_url)
                    .build()
                event.message.channel.sendMessage("Bu sunucuda \"Mesajları Yönet\" yetkim yok. Bu işlem gerçekleştirilemeyecek.")
                    .delay(Duration.ofSeconds(3))
                    .flatMap { it.delete() }
                    .queue()
                return
            }
        }
        if (event.message.contentRaw.split(" ").getOrNull(1) == null) {
            println("it null doe")
            event.message.channel.sendMessage("Silinecek mesajların sayısı belirtilmemiş.")
                .delay(Duration.ofSeconds(3))
                .flatMap { it.delete() }
                .queue()
            return
        }
        if (event.message.contentRaw.split(" ")[1].toLongOrNull() == null) {
            event.message.channel.sendMessage("Silinecek mesajların sayısı geçersiz.")
                .delay(Duration.ofSeconds(3))
                .flatMap { it.delete() }
                .queue()
            return
        }

        if (event.message.contentRaw.split(" ")[1].toLong() > 100 || event.message.contentRaw.split(" ")[1].toLong() < 1) {
            event.message.channel.sendMessage("Silinecek mesajların sayısı 1 ile 100 arasında olmalıdır.")
                .delay(Duration.ofSeconds(3))
                .flatMap { it.delete() }
                .queue()
            return
        }

        val messageCountLong = event.message.contentRaw.split(" ")[1].toIntOrNull()!!
        event.message.channel.history.retrievePast(messageCountLong)
            .queue { messages ->
                event.message.channel.purgeMessages(messages!!)
            }
        return
    }
}

