
from tale.base import Living, ParseResult, Item
from tale.util import call_periodically, Context
from tale.errors import ActionRefused
from tale import lang

#----Hex will verify the stakeholders you find and create the staff for you

class hex(Living):
    def notify_action(self, parsed: ParseResult, actor: 'Living') -> None:

        #setting up the objects that Hex will have or acquire
        staff = self.search_item("New Staff", include_location=False)
        scroll1 = self.search_item("scroll1", include_location=False)
        scroll2 = self.search_item("scroll2", include_location=False)
        scroll3 = self.search_item("orangutans reuquirement scroll", include_location=False)
        scroll4 = self.search_item("Pondors Requirement Scroll", include_location=False)
        scroll5 = self.search_item("scroll5", include_location=False)
        scroll6 = self.search_item("scroll6", include_location=False)
        scroll7 = self.search_item("Eskarinas Requirement Scroll", include_location=False)

        #stops actor reacting to themselves
        if actor is self or parsed.verb in self.verbs:
            return
        #responses to the players questions
        if "hello" in parsed.unparsed:
            self.tell_others("{Actor} says: Hello, how can I help you with your calculations?")
        elif "stakeholder" in parsed.unparsed:
            if "Mustrum" or "Ridcully" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Yes Mustrum Ridcully is one of the stakeholders for the staff.\"")
            elif "orangutan" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Yes Orangutan is one of the stakeholders for the staff.\"")
            elif "Eskarina" or "Smith" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Yes Eskarina Smith is a stakeholder for the staff.\"")
            elif "Pondor" or "Stibbons" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Yes my creator Pondor is a stakeholder for the staff.\"")
            elif "Pennysmart" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Yes Pennysmart is a stakeholder for the staff, keep him away from me his plants scare me.\"")
            elif "Rincewind" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Yes Rincewind is a stakeholder for the staff, has Death not taken him away yet?\"")
            elif "Dr.Hix" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Yes Dr.Hix is a stakeholder for the staff, his studies are very strange trying to communicate with the dead.\"")
            else:
                self.tell_others("{Actor} says: \"No that is not one of the stakeholders for the system.\"")
        elif "verify" in parsed.unparsed:
            if "stakeholders" or "users" in parsed.unparsed:
                self.tell_others("{Actor} says: Yes I can verify the stakeholders for your system. "
                                 "Please tell me them as you find them and I will verify them for you.")
            else:
                return
        elif "create" or "devise" in parsed.unparsed:
            if "staff" in parsed.unparsed:
                if self.__contains__(scroll4) and self.__contains__(scroll7) and self.__contains__(scroll3):
                    self.give_new_staff(actor, staff)
                else:
                    self.tell_others("{Actor} says: I don't have all the requirements to create the new staff.")
            else:
                return
        else:
            return
    #call to give player new staff
    def give_new_staff(self, actor: Living, staff: Item) -> None:
        staff.move(actor, self)
        self.tell_others("{Actor} says: Here's the newly devised staff.")
    #call to allow player to give hex items
    def allow_give_item(self, item: Item, actor: 'Living'):
        if item.name == "pondors requirement scroll":
            self.tell_others("{Actor} says: Thank you for giving me Pondors requirements.")
        elif item.name == "eskarinas requirement scroll":
            self.tell_others("{Actor} says: Thank you for giving me Eskarinas requirements.")
        elif item.name == "orangutans requirement scroll":
            self.tell_others("{Actor} says: Thank you for giving me the monkeys requirement.")
        elif item.name == "new staff":
            return True
        else:
            raise ActionRefused("%s doesn't want %s." % (lang.capital(self.title), item.title))

    #action that is periodically called by the actor
    @call_periodically(5, 40)
    def beep_noise(self, ctx: Context) -> None:
        self.tell_others("You can hear the sounds of millions of tiny legs walking through the glass tubes. "
                         "In the next room you hear a low buzzing sound.")