
import sys
import datetime

from typing import Optional, Generator

from tale.driver import Driver
from tale.hints import Hint
from tale.player import Player, PlayerConnection
from tale.story import *
from zones.Boat_House import boathouse

#setup for the entire game and player character
class Story(StoryBase):
    # create story configuration and customize:
    config = StoryConfig()
    config.name = "Wizards for Tea"
    config.author = "Alan Joyce"
    config.author_address = "14153289@studentmail.ul.ie"
    config.version = "1.11"
    config.requires_tale = "4.0"
    config.supported_modes = {GameMode.IF, GameMode.MUD}
    config.money_type = MoneyType.MODERN
    config.server_tick_method = TickMethod.TIMER
    config.server_tick_time = 1.0
    config.display_gametime = True
    config.epoch = datetime.datetime(2018, 4, 19, 14, 0, 0)
    config.startlocation_player = "Boat_House.boathouse"
    config.startlocation_wizard = "Boat_House.boathouse"
    config.zones = ["Boat_House", "Dormitories", "Great_Hall", "GreenHouse", "High_Energy_Magic_Building", "Library", "Tower_of_Art", "University_Gardens"]
    # story-specific fields follow:
    driver = None     # will be set by init()

    def init(self, driver: Driver) -> None:
        """Called by the game driver when it is done with its initial initialization."""
        self.driver = driver

    def init_player(self, player: Player) -> None:
        """
        Called by the game driver when it has created the player object (after successful login).
        You can set the hint texts on the player object, or change the state object, etc.
        """
        player.hints.init([
            Hint(None, None, "Probably best to find the Head of the University."),
            Hint("talkStibbon", None, "Best to find the person the Head of University mentioned Professor Stibbon."),
            Hint("findUsers", None, "Find the 7 stakeholders for the new staff."),
            Hint("fixHex", None , "Find cheese to power up hex."),
            Hint("talkUsers", None , "Interview the wizards and discover their requirements."),
            Hint("createList", None, "Combine the requirement scrolls from the wizards and Hex will create a new staff."),
            Hint("testStaff", None, "Give the staff to Eskarina to test.")
        ])

    def welcome(self, player: Player) -> Optional[str]:
        """
        Welcome text when player enters a new game
        If you return a string, it is used as an input prompt before continuing (a pause).
        """
        player.tell_text_file(self.driver.resources["messages/welcome.txt"])
        player.tell("\n")
        return "<bright>Press enter to continue.</>"

    def welcome_savegame(self, player: Player) -> Optional[str]:
        """
        Welcome text when player enters the game after loading a saved game
        If you return a string, it is used as an input prompt before continuing (a pause).
        """
        player.tell_text_file(self.driver.resources["messages/into.txt"])
        player.tell("\n")
        return "<bright>Press enter to continue where you were before.</>"

    def goodbye(self, player: Player) -> None:
        """goodbye text when player quits the game"""
        player.tell("Goodbye, %s. Please come back again soon." % player.title)
        player.tell("\n")

if __name__ == "__main__":
    # story is invoked as a script, start it.
    from tale.main import run_from_cmdline
    run_from_cmdline(["--game", sys.path[0]])
