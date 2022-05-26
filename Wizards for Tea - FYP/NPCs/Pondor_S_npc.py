
from tale.base import Living, ParseResult, Item
from tale.util import call_periodically, Context

class pondorStibbons(Living):

    def notify_action(self, parsed: ParseResult, actor: Living):
        #the actors requirements scroll
        scroll = self.search_item("Pondors Requirement Scroll", include_location=False)
        #if statement stops the actor reacting to themselves
        if actor is self or parsed.verb in self.verbs:
            return
        #responses to the players questions
        if "hello" in parsed.unparsed:
            self.tell_others("{Actor} says: \"Ah you must be %s. Welcome to the Unseen University. "
                             "You must be excited to start your studies with us."
                             "Well if you want to get started I have a challenge for you. "
                             "Some students use staffs to cast their spells but we're having issues with them."
                             "I was hoping you would be willing to help design a new staff.\"" % actor.title)
        elif "what" in parsed.unparsed:
            if "wrong" or "fault" and "staff" in parsed.unparsed:
                self.tell_others("{Actor} says: \"We have a few issues with the current staffs. "
                                 "I want you to pick a group of people to interview and find out what they would need a staff to do."
                                 "The Hex mainframe next door will also help you. "
                                 "Find the group of people and verify them with Hex. Then start looking into the requirements for staff. "
                                 "Once you think you think you have discovered the correct requirements, give Hex the scrolls with the requirements and it will create the staff."
                                 "Then its a case of testing it. Simple right?\"")
            elif "hex" or "mainframe" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Hex is the mainframe that I manage. "
                                 "It comprises of a colony of ants that will carry out calculations."
                                 "It mostly develops itself so its quite advanced.\"")
            else:
                return
        elif "how" in parsed.unparsed:
            if "design" or "create" and "staff" in parsed.unparsed:
                self.tell_others("{Actor} says: \"I want you to pick a group of people to interview and find out what they would need a staff to do."
                                 "The Hex mainframe next door will also help you. "
                                 "Find the group of people and verify them with Hex. "
                                 "Then start looking into the requirements for staff. "
                                 "Once you think you think you have discovered the correct requirements, give Hex a scroll with the requirements and it will create the staff."
                                 "Then its a case of testing it. Simple right?\"")
            elif "function" or "work" or "operate" and "staff" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Well the basic function of a staff is to allow a wizard to channel their magic through it to cast their spell."
                                 "A wizard has only got so much magic stored so once they run out magic they can't cast anything until they have recuperate their magic store.\"")
            else:
                return
        elif "will" in parsed.unparsed:
            if "group" in parsed.unparsed:
                self.tell_others("{Actor} says: \"I can be one of the people in the group. The group of people will be your stakeholders for the staff."
                                 "So you need to discover their requirements and more than likely come to a compromise as wizards will never all agree.\"")
            else:
                return
        elif "are" in parsed.unparsed:
            if "stakeholder" in parsed.unparsed:
                self.tell_others("{Actor} says: \"I can be one of the stakeholders but you should verify it with the Hex mainframe. "
                                 "It will tell you if you have found the correct stakeholders for this project.\"")
            else:
                return
        elif "require" in parsed.unparsed:
            if "staff" and "show" or "display" or "tells" and "level" or "amount" and "magic" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Yes that's my main requirement for the staff that it tells you the amount of magic you have left."
                                 " I'll write it on this scroll so you don't forget it.\"")
                self.give_req_scroll(actor, scroll)
                #Stibbons gives player scroll with requirement written on it.
            else:
                return
        elif "give" and "item" in parsed.unparsed:
            self.give_req_scroll(actor, scroll)
            self.tell_others("Here's the 4th requirement.")
        else:
            return

    #method to give player scroll
    def give_req_scroll(self, actor: Living, scroll: Item) -> None:
            scroll.move(actor, self)
            self.tell_others("{Actor} says: \"Here's the requirement written on a scroll.\"")
    #action called by the actor periodically
    @call_periodically(5, 40)
    def pondor_existence(self, ctx: Context) -> None:
        self.tell_others("Pondor sits staring into space pondoring his existence. Must be where he got his name.")