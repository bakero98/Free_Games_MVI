package com.balsa.free_games.utils

import androidx.annotation.StringRes
import com.balsa.free_games.R

enum class GENRE(@StringRes val labelRes: Int, val value: String? = null) {
    MMORPG(R.string.mmorpg),
    SHOOTER(R.string.shooter),
    STRATEGY(R.string.strategy),
    MOBA(R.string.moba),
    RACING(R.string.racing),
    SPORTS(R.string.sports),
    SOCIAL(R.string.social),
    SANDBOX(R.string.sandbox),
    OPEN_WORLD(R.string.open_world),
    SURVIVAL(R.string.survival),
    PVP(R.string.pvp),
    PVE(R.string.pve),
    PIXEL(R.string.pixel),
    VOXEL(R.string.voxel),
    ZOMBIE(R.string.zombie),
    TURN_BASED(R.string.turn_based),
    FIRST_PERSON(R.string.first_person),
    THIRD_PERSON(R.string.third_person),
    TOP_DOWN(R.string.top_down),
    TANK(R.string.tank),
    SPACE(R.string.space),
    SAILING(R.string.sailing),
    SIDE_SCROLLER(R.string.side_scroller),
    SUPERHERO(R.string.superhero),
    PERMADEATH(R.string.permadeath),
    CAR(R.string.card),
    BATTLE_ROYALE(R.string.battle_royale),
    MMO(R.string.mmo),
    MMOFPS(R.string.mmofps),
    MMOTPS(R.string.mmotps),
    THREE_D(R.string.three_d, "3D"),
    TWO_D(R.string.two_d, "2D"),
    ANIME(R.string.anime),
    FANTASY(R.string.fantasy),
    SCI_FI(R.string.sci_fi),
    FIGHTING(R.string.fighting),
    ACTION_RPG(R.string.action_rpg),
    ACTION(R.string.action),
    MILITARY(R.string.military),
    MARTIAL_ARTS(R.string.martial_arts),
    FLIGHT(R.string.flight),
    LOW_SPEC(R.string.low_spec),
    TOWER_DEFENSE(R.string.tower_defense),
    HORROR(R.string.horror),
    MMORTS(R.string.mmorts),
    UNKNOWN(R.string.unknown);

    companion object {
        fun getGenreFromString(genre: String?) = values().firstOrNull {
            it.name.equals(genre, true)
        } ?: UNKNOWN
    }
}