package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class Ozelkomut: ListenerAdapter() {
    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.author.isBot) {
            println("Event author is bot! returning! Message content is: " + event.message.contentRaw)
            return
        }
        if (event.message.contentRaw != "!ip" || event.message.contentRaw != "!kayıt") {
            println("Message ctntn. isnt any of ip or kayıt! returning! Message content is: " + event.message.contentRaw)
            return
        }
        if (event.message.contentRaw == "!ip") {
            println("Message content is !ip")
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
        }
        else {
            println("Message content is !kayıt")
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
        }
    }
}