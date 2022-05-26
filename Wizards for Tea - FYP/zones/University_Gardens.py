from tale.base import Location, Exit

from zones.Tower_of_Art import artTower
from zones.GreenHouse import greenHouse
from zones.High_Energy_Magic_Building import highEnergyBuilding
from zones.Great_Hall import greatHall

#defining the location
#----Univeristy Gardens

university_gardens = Location("University Gardens", "The university gardens are vast and contain various plants. "
                                                    "Paths lead from the various buildings to keep the students on the safer paths as some of the plants are known to have insatiable appetites.")

#adding the exits to the locations
#----Door to Tower of Art

Exit.connect(university_gardens,
             ["tower", "tower of art", "art tower"],
             "A small wooden door leads into the base of the <bright>Tower of Art</>. Only 8,888 steps to the top.",
             None,
             artTower,
             ["university gardens", "garden", "gardens", "outside", "grounds"],
             "8,888 steps more to reach the bottom or you can take a tea tray and slide to the bottom to reach the <bright>Univeristy Gardens</>.",
             None)

#----Door to High Energy Magic Building

Exit.connect(university_gardens,
             ["high energy magic building", "magic building"],
             "The <bright>High Energy Magic Building</> is the main hub for all magical experiments. The testing hall contains the mishaps and unfortunate side-effects of the students experiments.",
             None,
             highEnergyBuilding,
             ["university gardens", "garden", "gardens", "outside", "grounds"],
             "Outside is the <bright>University Gardens</> with their assortment of weird and mostly dangerous plants.",
             None)

#----Door to Green House

Exit.connect(university_gardens,
             ["green house", "glass house"],
             "The large <bright>Green House</> sits at the far end of the gardens. The pains of glass glinting in the sunlight",
             None,
             greenHouse,
             ["university gardens", "garden", "gardens", "outside", "grounds"],
             "You can see the <bright>University Gardens</> outside through the panes of the green house.",
             None)

#----Door to Great Hall

Exit.connect(university_gardens,
             ["hall", "great hall"],
             "Large wooden doors embelished with octiron lead into the <bright>Great Hall</> where many great feasts take place on a daily basis. "
             "Some wizards choose to stay in the <bright>Great Hall</> eating eight meals a day while other more fortunate have grown incapable of moving from the <bright>Great Hall</>.",
             None,
             greatHall,
             ["university gardens", "garden", "gardens", "outside", "grounds"],
             "Outside is the <bright>Universities Gardens</> filled with plants from many exotic locations.",
             None)
