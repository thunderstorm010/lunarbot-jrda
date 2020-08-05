package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.lang.IndexOutOfBoundsException
import java.time.Duration

class Kayit : ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.isWebhookMessage) return
        if (event.author.isBot) return
        if (!event.message.contentRaw.startsWith("!kayıtet")) return
        if (!event.member!!.roles.contains(event.jda.getRoleById(BotProperties.KAYIT_EDEBILIR_ROLE_ID))) return
        try {
            event.message.contentRaw.split(" ")[1]
        } catch (e: IndexOutOfBoundsException) {
            val embed = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("!kayıtet")
                .setDescription("Lütfen kayıt edilecek kişinin nickname'ini belirtin.")
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
            event.channel.sendMessage(embed).queue()
        }
        try {
            event.message.contentRaw.split(" ")[2]
        } catch (e: IndexOutOfBoundsException) {
            val embed = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("!kayıtet")
                .setDescription("Lütfen kayıt edilecek kişinin gerçek ad'ını belirtin.")
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
            event.channel.sendMessage(embed).queue()
        }
        try {
            event.message.contentRaw.split(" ")[3]
        } catch (e: IndexOutOfBoundsException) {
            val embed = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("!kayıtet")
                .setDescription("Lütfen kayıt edilecek kişinin yaş'ını belirtin.")
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
            event.channel.sendMessage(embed).queue()
        }
        if(event.message.mentionedMembers.size == 0) {
            val embed = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("!kayıtet")
                .setDescription("Lütfen kayıt edilecek kişiyi etiketleyin.")
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
            event.channel.sendMessage(embed).queue()
        }
        val nick = event.message.contentRaw.split(" ")[1]
        val realName = event.message.contentRaw.split(" ")[2]
        val yas = event.message.contentRaw.split(" ")[3]
        val mentionedMember = event.message.mentionedMembers[0]

        mentionedMember.modifyNickname("${nick}/${realName}-[${yas}]").queue()
        event.guild.addRoleToMember(mentionedMember,event.jda.getRoleById(738553650531795049)!!).queue()
        EmbedBuilder()
            .setAuthor(
                event.author.name + "#" + event.author.discriminator + ", ",
                null,
                event.author.effectiveAvatarUrl
            )
            .setTitle("!kayıtet")
            .setFooter(Main.footer_text,Main.footer_icon_url)
            .setDescription("İşlem başarıyla tamamlandı.")
            .build().let {
                event.channel.sendMessage(it)
                        .delay(Duration.ofSeconds(5))
                    .flatMap { it.delete() }
                        .queue()
            }


    }
}