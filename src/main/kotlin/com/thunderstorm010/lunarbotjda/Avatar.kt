package com.thunderstorm010.lunarbotjda

import Main
import com.jagrosh.jdautilities.commons.waiter.EventWaiter
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.awt.Color

class Avatar : ListenerAdapter() {
    private val logger: Logger = LoggerFactory.getLogger(Avatar::class.java)
    override fun onMessageReceived(event: MessageReceivedEvent) {
        System.setProperty(
            "http.agent",
            "HTC Mozilla/5.0 (Linux; Android 7.0; HTC 10 Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.83 Mobile Safari/537.36"
        )
        if (event.author.isBot) return
        if (!event.message.contentRaw.startsWith("!avatar")) return
        if (event.message.mentionedUsers.size > 1) {
            val embed1 = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setDescription("Etiketlediğiniz kişi sayısı 1'den fazla olmamalıdır.")
                .setTitle("!dmduyuru")
                .setFooter(Main.footer_text, Main.footer_icon_url)
            event.message.channel.sendMessage("Etiketlediğiniz kişi sayısı 1 den fazla olmamalıdır.").queue()
        }
        if (event.message.mentionedUsers.size == 0) {
            EmbedBuilder()
                .setTitle("İşte avatarın: ")
                .setImage(event.author.effectiveAvatarUrl + "?size=4096")
                .setColor(Color.BLACK)
                .build().let {
                    event.channel.sendMessage(it).queue()
                }
            logger.info(event.author.name + " doğru bir şekilde (kendi üzerine) avatar çağrısı yaptı.")
        } else if (event.message.mentionedUsers.size in 1 downTo 0) {
            EmbedBuilder()
                .setTitle("İşte ${event.message.mentionedUsers[0].name} kullanıcısının avatarı: ")
                .setImage(event.message.mentionedUsers[0].effectiveAvatarUrl + "?size=4096")
                .setColor(Color.BLACK)
                .build().let {
                    event.channel.sendMessage(it).queue()
                }
            logger.info(event.author.name + ", " + event.message.mentionedUsers[0].name + " üzerine doğru bir şekilde avatar çağrısı yaptı.")
        }

    }
}