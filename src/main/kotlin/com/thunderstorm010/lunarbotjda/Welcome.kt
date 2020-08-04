package com.thunderstorm010.lunarbotjda

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class Welcome : ListenerAdapter() {
    override fun onGuildMemberJoin(event: GuildMemberJoinEvent) {
        try {
            EmbedBuilder()
                .setTitle("Lunar Jailbreak Discord sunucumuza hoşgeldin!")
                .setImage("https://cdn.discordapp.com/attachments/690564626236047410/739026247635697694/deneme.png")
                .build()
                .let { q ->
                    event.user.openPrivateChannel().map { it.sendMessage(q).queue() }.queue()
                }

        } catch (e: Exception) {
            return
        }
    }
}