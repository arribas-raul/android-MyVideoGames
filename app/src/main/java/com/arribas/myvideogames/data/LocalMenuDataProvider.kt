package com.arribas.myvideogames.data

object LocalMenuDataProvider {
    fun getMenuData(): List<NavigationItemContent>{
        return listOf(
            NavigationItemContent(
                type = VideoConsole.PS5,
                text = VideoConsole.PS5.name
            ),
            NavigationItemContent(
                type = VideoConsole.PS4,
                text = VideoConsole.PS4.name
            ),

            NavigationItemContent(
                type = VideoConsole.PS3,
                text = VideoConsole.PS3.name
            ),
            NavigationItemContent(
                type = VideoConsole.PS2,
                text = VideoConsole.PS2.name
            )
        )
    }
}