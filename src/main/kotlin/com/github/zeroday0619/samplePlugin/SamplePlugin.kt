package com.github.zeroday0619.samplePlugin
import org.bukkit.plugin.java.JavaPlugin


class SamplePlugin: JavaPlugin() {
    override fun onEnable() {
        logger.info("Sample plugin enabled")
    }

    override fun onDisable() {
        logger.info("Sample plugin disabled")
    }
}