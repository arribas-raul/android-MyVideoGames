package com.arribas.myvideogames.data

import com.arribas.myvideogames.R


object LocalGameDataProvider {

    val defaultGame = getGameData(VideoConsole.PS5)[0]

    fun getGameData(type: VideoConsole): List<Videogame>{
        return listOf(
            Videogame(
                id = 1,
                name = R.string.game_title_ps2_gw2,
                type = VideoConsole.PS2.name,
                description = R.string.game_description_ps2_gw2,
                score = R.string.game_score_ps2_gw2,
                img = R.drawable.ps2_gow2
            ),
            Videogame(
                id = 2,
                name = R.string.game_title_ps2_dq,
                type = VideoConsole.PS2.name,
                description = R.string.game_description_ps2_dq,
                score = R.string.game_score_ps2_dq,
                img = R.drawable.ps2_dq
            ),
            Videogame(
                id = 3,
                name = R.string.game_title_ps2_dmc,
                type = VideoConsole.PS2.name,
                description = R.string.game_description_ps2_dmc,
                score = R.string.game_score_ps2_dmc,
                img = R.drawable.ps2_dmc
            ),
            Videogame(
                id = 4,
                name = R.string.game_title_ps2_kh,
                type = VideoConsole.PS2.name,
                description = R.string.game_description_ps2_kh,
                score = R.string.game_score_ps2_kh,
                img = R.drawable.ps2_kh
            ),
            Videogame(
                id = 5,
                name = R.string.game_title_ps2_tr,
                type = VideoConsole.PS2.name,
                description = R.string.game_description_ps2_tr,
                score = R.string.game_score_ps2_tr,
                img = R.drawable.ps2_tr
            ),
            Videogame(
                id = 6,
                name = R.string.game_title_ps2_bt,
                type = VideoConsole.PS2.name,
                description = R.string.game_description_ps2_bt,
                score = R.string.game_score_ps2_bt,
                img = R.drawable.ps2_bt
            ),

            Videogame(
                id = 7,
                name = R.string.game_title_ps3_mgs,
                type = VideoConsole.PS3.name,
                description = R.string.game_description_ps3_mgs,
                score = R.string.game_score_ps3_mgs,
                img = R.drawable.ps3_mgs
            ),
            Videogame(
                id = 8,
                name = R.string.game_title_ps3_tlou,
                type = VideoConsole.PS3.name,
                description = R.string.game_description_ps3_tlou,
                score = R.string.game_score_ps3_tlou,
                img = R.drawable.ps3_tlou
            ),
            Videogame(
                id = 9,
                name = R.string.game_title_ps3_gta5,
                type = VideoConsole.PS3.name,
                description = R.string.game_description_ps3_gta5,
                score = R.string.game_score_ps3_gta5,
                img = R.drawable.ps3_gta5
            ),
            Videogame(
                id = 10,
                name = R.string.game_title_ps3_u2,
                type = VideoConsole.PS3.name,
                description = R.string.game_description_ps3_u2,
                score = R.string.game_score_ps3_u2,
                img = R.drawable.ps3_u2
            ),
            Videogame(
                id = 11,
                name = R.string.game_title_ps3_rdr,
                type = VideoConsole.PS3.name,
                description = R.string.game_description_ps3_rdr,
                score = R.string.game_score_ps3_rdr,
                img = R.drawable.ps3_rdr
            ),
            Videogame(
                id = 12,
                name = R.string.game_title_ps3_bac,
                type = VideoConsole.PS3.name,
                description = R.string.game_description_ps3_bac,
                score = R.string.game_score_ps3_bac,
                img = R.drawable.ps3_bac
            ),

            Videogame(
                id = 13,
                name = R.string.game_title_ps4_rdr2,
                type = VideoConsole.PS4.name,
                description = R.string.game_description_ps4_rdr2,
                score = R.string.game_score_ps4_rdr2,
                img = R.drawable.ps4_rdr2
            ),
            Videogame(
                id = 14,
                name = R.string.game_title_ps4_gow,
                type = VideoConsole.PS4.name,
                description = R.string.game_description_ps4_gow,
                score = R.string.game_score_ps4_gow,
                img = R.drawable.ps4_gow
            ),
            Videogame(
                id = 15,
                name = R.string.game_title_ps4_u4,
                type = VideoConsole.PS4.name,
                description = R.string.game_description_ps4_u4,
                score = R.string.game_score_ps4_u4,
                img = R.drawable.ps4_u4
            ),
            Videogame(
                id = 16,
                name = R.string.game_title_ps4_tlou2,
                type = VideoConsole.PS4.name,
                description = R.string.game_description_ps4_tlou2,
                score = R.string.game_score_ps4_tlou2,
                img = R.drawable.ps4_tlou2
            ),
            Videogame(
                id = 17,
                name = R.string.game_title_ps4_tw3,
                type = VideoConsole.PS4.name,
                description = R.string.game_description_ps4_tw3,
                score = R.string.game_score_ps4_tw3,
                img = R.drawable.ps4_tw3
            ),
            Videogame(
                id = 18,
                name = R.string.game_title_ps4_re2,
                type = VideoConsole.PS4.name,
                description = R.string.game_description_ps4_re2,
                score = R.string.game_score_ps4_re2,
                img = R.drawable.ps4_re2
            ),

            Videogame(
                id = 19,
                name = R.string.game_title_ps5_gowr,
                type = VideoConsole.PS5.name,
                description = R.string.game_description_ps5_gowr,
                score = R.string.game_score_ps5_gowr,
                img = R.drawable.ps5_gowr
            ),
            Videogame(
                id = 20,
                name = R.string.game_title_ps5_re4,
                type = VideoConsole.PS5.name,
                description = R.string.game_description_ps5_re4,
                score = R.string.game_score_ps5_re4,
                img = R.drawable.ps5_re4
            ),
            Videogame(
                id = 21,
                name = R.string.game_title_ps5_hfw,
                type = VideoConsole.PS5.name,
                description = R.string.game_description_ps5_hfw,
                score = R.string.game_score_ps5_hfw,
                img = R.drawable.ps5_hfw
            ),
            Videogame(
                id = 22,
                name = R.string.game_title_ps5_ds,
                type = VideoConsole.PS5.name,
                description = R.string.game_description_ps5_ds,
                score = R.string.game_score_ps5_ds,
                img = R.drawable.ps5_ds
            ),
            Videogame(
                id = 23,
                name = R.string.game_title_ps5_r,
                type = VideoConsole.PS5.name,
                description = R.string.game_description_ps5_r,
                score = R.string.game_score_ps5_r,
                img = R.drawable.ps5_r
            ),
            Videogame(
                id = 24,
                name = R.string.game_title_ps5_re8,
                type = VideoConsole.PS5.name,
                description = R.string.game_description_ps5_re8,
                score = R.string.game_score_ps5_re8,
                img = R.drawable.ps5_re8
            ),
        ).filter { it.type == type.name }
    }
}