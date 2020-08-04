package com.thunderstorm010.lunarbotjda

import Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.awt.Color

class Yardim : ListenerAdapter() {

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.isWebhookMessage) return
        if (event.author.isBot) return
        if (!event.message.contentRaw.startsWith("!yardım")) return
        val description =
            "!yardım :: Bu mesajı gösterir." +
                    "\n!avatar :: Kişinin avatarını gösterir." +
                    "\n!avatar [kullanıcı etiketi] :: Belirtilen kişinin avatarını gösterir." +
                    "\n!dmduyuru [duyuru mesajı] :: Belirtilen mesajı DM üzerinden herkese duyurur." +
                    "\n!espri :: Rastgele bir espri yazdırır." +
                    "\n!ip :: Sunucu ipsini ve discord adresini yazdırır." +
                    "\n!kayıt :: Kayıt mesajını yazdırır." +
                    "\n!shutdown :: Botu güvenli bir şekilde kapatır." +
                    "\n!sil [sayı] :: Belirtilen sayıdaki mesajları siler."
        val helpEmbed = EmbedBuilder()
            .setAuthor(
                event.author.name + "#" + event.author.discriminator + ", ",
                null,
                event.author.effectiveAvatarUrl
            )
            .setColor(Color.BLUE)
            .setTitle("Komutlar")
            .setDescription(description)
            .setFooter(Main.footer_text, Main.footer_icon_url)
            .build()
        event.message.channel.sendMessage(helpEmbed).queue()
    }
}