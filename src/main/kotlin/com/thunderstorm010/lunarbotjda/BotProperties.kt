package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity

object BotProperties {
    /**
     * Bot owner's ID. Used to serve specific commands.
     */
    @JvmStatic
    var BOT_OWNER_ID = "510498560391774208"

    /**
     * Bots activity type.
     */
    @JvmStatic
    var BOT_DEFAULT_ACTIVITY_TYPE = Activity.playing("185.193.165.2' de")

    /**
     * Bots status.
     */
    @JvmStatic
    var BOT_DEFAULT_STATUS = OnlineStatus.ONLINE

    @JvmStatic
    var DMDUYURU_EMBED_TITLE = "Lunar Jailbreak'ten"






}