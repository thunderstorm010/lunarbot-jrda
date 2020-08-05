package com.thunderstorm010.lunarbotjda

import Main
import com.thunderstorm010.lunarbotjda.BotProperties.ip_allowed_channel
import com.thunderstorm010.lunarbotjda.BotProperties.kayit_allowed_channel
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.Duration

class komutttahuojrwekdrs : ListenerAdapter() {

    override fun onGuildMessageReceived(event: GuildMessageReceivedEvent) {
        if (event.message.contentRaw == "!ip" && event.channel.idLong != ip_allowed_channel) {
            EmbedBuilder()
                .setTitle("Özel Komut")
                .setDescription(
                    "Bu komut bu kanalda izin verilmemektedir. Lütfen " + event.jda.getGuildChannelById(
                        ip_allowed_channel
                    )!!.name + " kanalına gidiniz."
                )
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
                .let { f ->
                    event.message.channel.sendMessage(f)
                        .delay(Duration.ofSeconds(5))
                        .flatMap { it.delete() }
                        .queue()
                }
            return

        }
        if (event.message.contentRaw == "!kayıt" && event.channel.idLong != kayit_allowed_channel) {
            EmbedBuilder()
                .setTitle("Özel Komut")
                .setDescription(
                    "Bu komut bu kanalda izin verilmemektedir. Lütfen " + event.jda.getTextChannelById(
                        kayit_allowed_channel
                    )!!.name + " kanalına gidiniz."
                )
                .setAuthor(
                    event.author.name + "#" + event.author.discriminator + ", ",
                    null,
                    event.author.effectiveAvatarUrl
                )
                .setFooter(Main.footer_text, Main.footer_icon_url)
                .build()
                .let {
                    event.message.channel.sendMessage(it)
                        .delay(Duration.ofSeconds(5))
                        .flatMap { it.delete() }
                        .queue()
                }
            return
        }
        when (event.message.contentRaw) {
            "!ip" -> {
                EmbedBuilder()
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
                    .let {
                        event.channel.sendMessage(it).queue()
                    }
                return
            }
            "!kayıt" -> {
                EmbedBuilder()
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
                    .let {
                        event.channel.sendMessage(it).queue()
                    }
                return
            }
            else -> {
                return
            }
        }


    }
}