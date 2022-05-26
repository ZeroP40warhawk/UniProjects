
from tale.base import Location, Exit
from zones.Library import library
from NPCs.Mustrum_R_npc import mustrumRidcully

#defining the locations
#----Great Hall
greatHall = Location("The Great Hall",
                     "The Great Hall where all the wizards meet, well when they aren't eating or sleeping. Many great meetings have been held in this hall about all things wizarding.")

#----Main Octangle

mainOctangle = Location("The Main Octangle",
                        "The Main Octangle is the small garden courtyard in front of the the clock tower housing Old Tom. "
                        "The flowers contain octiron so they take on forms that relate to the number eight.")

#----Clock Tower

clockTower = Location("The Clock Tower",
                      "The clock tower is where Old Tom resides. "
                      "The universities bell which is made from octiron chimes heavy silences every hour. "
                      "It also chimes in during magical emergencies making communication challenging in already difficult situations.")

#----Faculty Building

facultyBuilding = Location("The Faculty Building",
                           "The faculty building is where most of the professors reside when they aren't lecturing. "
                           "They mostly try to hide here to remove themselves from the students and the unfortunate business of having to lecture.")

#----Mustrum Ridcully's Office

mustrumsOffice = Location("Mustrum Ridcully's Office",
                          "The office of the Archchancellor Mustrum Ridcully. He is the longest serving head in the history of the university. "
                          "This is mostly due to his ability of being indestructible and by bashing would be assassin's with the door.")

#defining the exits to the locations
#----Great Hall to Main Octangle

Exit.connect(greatHall,
             ["courtyard", "octangle", "main octangle"],
             "The <bright>Main Octangle</> outside contains many strange and wonderful plants.",
             None,
             mainOctangle,
             ["Hall","Great Hall"],
             "You can hear the chatter from within the <bright>Great Hall</> as the wizards discuss their theories and eat their meals.",
             None)

#----Great Hall to Clock Tower

Exit.connect(greatHall,
             ["clock", "clock tower", "tower"],
             "The <bright>Clock Tower</> is eerily quite in comparison to the Great Hall.",
             None,
             clockTower,
             ["hall","great hall"],
             "You can hear the chatter from within the <bright>Great Hall</>, a stark contrast to the silence in the clock tower.",
             None)

#----Clock Tower to Faculty Building

Exit.connect(clockTower,
             ["faculty building", "faculty", "building"],
             "The <bright>Faculty Building</> is where many of the professors hide from the arduous tasks of teaching students.",
             None,
             facultyBuilding,
             ["clock", "clock tower", "tower"],
             "The <bright>Clock Tower</> holds the bell Old Tom which chimes heavy silence every hour.",
             None)

#----Clock Tower to Library

Exit.connect(clockTower,
             ["library"],
             "The universities <bright>Library</> is infinitely large and always changing. "
             "Students must be careful not to wander to far otherwise they can become trapped in L-Space. ",
             None,
             library,
             ["clock", "clock tower", "tower"],
             "You watch the door behind you to the <bright>Clock Tower</> to ensure it doesn't disappear and leave you trapped in L-Space.",
             None)

#----Faculty to Mustrums Office

Exit.connect(facultyBuilding,
             ["mustrums office", "office", "mustrum ridcullys office"],
             "<bright>Mustrum Ridcullys Office</> is at the end of the hall. The longest serving archchancellor of the unseen university.",
             None,
             mustrumsOffice,
             ["faculty building", "faculty", "building"],
             "You can hear the hustle and bustle of the other professors outside outside in the <bright>Faculty Building</> hallway.",
             None)

#----NPCs
#adding the npcs to their locations
#----Mustrum Ridcully
mustrumR = mustrumRidcully("Mustrum Ridcully",
                         "m",
                         title = "Mustrum Ridcully",
                         descr = "Mustrum Ridcully is the archchancellor of the university.")

mustrumR.aliases = {"Mustrum", "Archcancellor Mustrum Ridcully", "Mustrum Ridcully"}

mustrumsOffice.init_inventory([mustrumR])

