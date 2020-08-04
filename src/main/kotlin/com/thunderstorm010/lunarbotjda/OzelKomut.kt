package com.thunderstorm010.lunarbotjda

import Main
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class OzelKomut : ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        if (event.isWebhookMessage) return
        if (event.author.isBot) return
        if (event.message.contentRaw != "!ip") return
        if (event.message.contentRaw != "!kayıt") return
        if (event.message.contentRaw == "!ip") {
            val embed = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("!ip")
                .setDescription(
                    "**:star2: Sunucu IP Adresi : 185.193.165.2**\n" +
                            "**:star2: Discord Adresimiz :  https://discord.gg/UcJayRk**"
                )
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
            event.channel.sendMessage(embed).queue()
            return
        }
        else if (event.message.contentRaw == "!kayıt") {
            val embed = EmbedBuilder()
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setTitle("!kayıt")
                .setDescription(
                    "``\uD83C\uDF1FSunucumuza kayıt olmak için aşağıdaki formu doldurmalısınız \uD83C\uDF1F``\n" +
                            "\n" +
                            "```Nicknameniz : \n" +
                            "İsminiz : \n" +
                            "Yaşınız : \n" +
                            "Steam Profil Linkiniz : ```\n" +
                            "``\uD83C\uDF0CNotlar\uD83C\uDF0C``\n" +
                            "\n" +
                            "**:sparkles:Eğer günler geçmesine rağmen kayıt edilmediyseniz kayıt gereksinimlerini karşılamıyorsunuzdur.\n" +
                            ":sparkles:Bilgileri doğru vermediğiniz sürece kayıt edilmezsiniz.\n" +
                            ":sparkles:Bilgileri verdikten sonra acele etmeyin en geç gün içinde kayıt edilirsiniz.**"
                )
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
            event.message.channel.sendMessage(embed).queue()
            return
        }


    }
}