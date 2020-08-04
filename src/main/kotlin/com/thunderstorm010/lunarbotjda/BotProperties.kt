package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity

object BotProperties {
    /**
     * Bot owner's ID. Used to serve specific commands.
     */
    @JvmStatic
    var BOT_OWNER_ID = "671444887769579551"

    /**
     * Bots activity type.
     */
    @JvmStatic
    var BOT_DEFAULT_ACTIVITY_TYPE = Activity.playing("185.193.165.2'de")

    /**
     * Bots status.
     */
    @JvmStatic
    var BOT_DEFAULT_STATUS = OnlineStatus.ONLINE

    @JvmStatic
    var DMDUYURU_EMBED_TITLE = "Lunar Jailbreak'ten"

    @JvmStatic
    var KAYIT_EDEBILIR_ROLE_ID: Long = 740313302613360744

    @JvmStatic
    var KAYIT_CHANNEL_ID = 738553650611224590L





}
