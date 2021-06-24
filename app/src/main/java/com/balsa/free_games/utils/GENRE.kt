package com.balsa.free_games.utils

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.balsa.free_games.R

enum class GENRE(
    @DrawableRes val drawableRes: Int,
    @StringRes val labelRes: Int,
    val value: String? = null,
    val isSelected: Boolean? = false
) {
    ALL(R.drawable.ic_all, R.string.all, isSelected = true),
    MMORPG(R.drawable.ic_swords, R.string.mmorpg),
    SHOOTER(R.drawable.ic_rifle, R.string.shooter),
    STRATEGY(R.drawable.ic_chess, R.string.strategy),
    MOBA(R.drawable.ic_map, R.string.moba),
    RACING(R.drawable.ic_sports_car, R.string.racing),
    SPORTS(R.drawable.ic_soccer_ball, R.string.sports),
    SOCIAL(R.drawable.ic_network, R.string.social),
    SANDBOX(R.drawable.ic_sandbox, R.string.sandbox),
    OPEN_WORLD(R.drawable.ic_earth, R.string.open_world),
    SURVIVAL(R.drawable.ic_fire, R.string.survival),
    PVP(R.drawable.ic_pvp, R.string.pvp),
    PVE(R.drawable.ic_pvp, R.string.pve),
    PIXEL(R.drawable.ic_alien_pixelized, R.string.pixel),
    VOXEL(R.drawable.ic_alien_pixelized, R.string.voxel),
    ZOMBIE(R.drawable.ic_zombie, R.string.zombie),
    TURN_BASED(R.drawable.ic_console, R.string.turn_based),
    FIRST_PERSON(R.drawable.ic_rifle, R.string.first_person),
    THIRD_PERSON(R.drawable.ic_map, R.string.third_person),
    TOP_DOWN(R.drawable.ic_map, R.string.top_down),
    TANK(R.drawable.ic_tank, R.string.tank),
    SPACE(R.drawable.ic_rocket, R.string.space),
    SAILING(R.drawable.ic_sailling_ship, R.string.sailing),
    SIDE_SCROLLER(R.drawable.ic_console, R.string.side_scroller),
    SUPERHERO(R.drawable.ic_spiderman, R.string.superhero),
    PERMADEATH(R.drawable.ic_console, R.string.permadeath),
    CAR(R.drawable.ic_sports_car, R.string.card),
    BATTLE_ROYALE(R.drawable.ic_pvp, R.string.battle_royale),
    MMO(R.drawable.ic_console, R.string.mmo),
    MMOFPS(R.drawable.ic_rifle, R.string.mmofps),
    MMOTPS(R.drawable.ic_rifle, R.string.mmotps),
    THREE_D(R.drawable.ic__three_d, R.string.three_d, "3D"),
    TWO_D(R.drawable.ic_two_d, R.string.two_d, "2D"),
    ANIME(R.drawable.ic_cosplayer, R.string.anime),
    FANTASY(R.drawable.ic_dragon, R.string.fantasy),
    SCI_FI(R.drawable.ic_dragon, R.string.sci_fi),
    FIGHTING(R.drawable.ic_boxing_gloves, R.string.fighting),
    ACTION_RPG(R.drawable.ic_rifle, R.string.action_rpg),
    ACTION(R.drawable.ic_rifle, R.string.action),
    MILITARY(R.drawable.ic_military, R.string.military),
    MARTIAL_ARTS(R.drawable.ic_boxing_gloves, R.string.martial_arts),
    FLIGHT(R.drawable.ic_airplane, R.string.flight),
    LOW_SPEC(R.drawable.ic_console, R.string.low_spec),
    TOWER_DEFENSE(R.drawable.ic_tower, R.string.tower_defense),
    HORROR(R.drawable.ic_zombie, R.string.horror),
    MMORTS(R.drawable.ic_console, R.string.mmorts),
    UNKNOWN(R.drawable.ic_console, R.string.unknown);

    companion object {
        fun getGenreFromString(genre: String?) = values().firstOrNull {
            it.name.equals(genre, true)
        } ?: UNKNOWN

        fun getGenres() = values()
    }
}