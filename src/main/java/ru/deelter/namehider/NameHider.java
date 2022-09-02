package ru.deelter.namehider;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public final class NameHider extends JavaPlugin {

    private static final String TEAM_NAME = "nameHide";
    private static Team team;

    public static Team getTeam() {
        return team;
    }

    @Override
    public void onEnable() {
        this.setupScoreboard();
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new NameHideListener(), this);
    }

    private void setupScoreboard() {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        team = scoreboard.getTeam(TEAM_NAME);
        if (team == null) team = scoreboard.registerNewTeam(TEAM_NAME);

        team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.NEVER);;
        team.setCanSeeFriendlyInvisibles(false);
        team.setAllowFriendlyFire(true);
    }

    @Override
    public void onDisable() {
        team.unregister();
    }
}
