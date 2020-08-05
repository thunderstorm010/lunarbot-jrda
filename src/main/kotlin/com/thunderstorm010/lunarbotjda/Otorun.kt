package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import java.time.Duration


class Otorun: ListenerAdapter() {
    val kayitEmbed = EmbedBuilder()
        .setTitle("Kayıt Ol")
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

    val katilEmbed = EmbedBuilder()
        .setTitle(":heart_exclamation: Sunucuya Bekleniyorsun :heart_exclamation:")
        .setDescription(
                "`Tıkla Bağlan ->`\n" +
                "steam://connect/185.193.165.2")
        .setFooter(Main.footer_text,Main.footer_icon_url)
        .build()
    override fun onReady(event: ReadyEvent) {
        Thread {
            while (true) {

                event.jda.getTextChannelById(BotProperties.KAYIT_CHANNEL_ID)!!.sendMessage(kayitEmbed).queue()
                event.jda.getTextChannelById(BotProperties.GENEL_CHANNEL_ID)!!.sendMessage(katilEmbed).queue()
                Thread.sleep(1800000)
            }
        }.start()

    }
}