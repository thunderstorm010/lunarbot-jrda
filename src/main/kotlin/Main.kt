import com.thunderstorm010.lunarbotjda.*
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent


object Main {


    @JvmStatic
    val footer_icon_url =
        "https://cdn.discordapp.com/avatars/510498560391774208/d490f07655fcdb0cd43fd4d587ed29e4.png?size=4096"

    @JvmStatic
    val footer_text = "Made by Thunderstorm#0200"

    @JvmStatic
    fun main(args: Array<String>) {
        val token = System.getenv("BOT_TOKEN")
        val jda = JDABuilder.createDefault(token)
            .enableIntents(listOf(GatewayIntent.GUILD_MEMBERS, GatewayIntent.DIRECT_MESSAGES))
        jda
            .addEventListeners(
                Deleter(),
                Avatar(),
                Espri(),
                Welcome(),
                Ready(),
                Shutdown(),
                Dmduyuru(),
                komutttahuojrwekdrs(),
                Yardim(),
                Kayit(),
                Otorun(),
                Islem()
            )
            .build()
            .awaitReady()
    }
}