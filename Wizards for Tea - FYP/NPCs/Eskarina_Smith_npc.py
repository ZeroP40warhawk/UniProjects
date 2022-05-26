import random

from tale.base import Living, ParseResult, Item
from tale.util import call_periodically, Context
from tale.errors import ActionRefused
from tale import lang


#--- Eskarina will test the staff once the requirements have been found.

class eskarinaSmith(Living):
        def notify_action(self, parsed: ParseResult, actor: Living) -> None:
            #sets up scroll and staff object for the actor
            scroll = self.search_item("eskarinas requirement scroll", include_location=False)
            staff = self.search_item("New Staff", include_location=False)
            #stops the actor reacting to themselves
            if actor is self or parsed.verb in self.verbs:
                return
            #responses to the players questions
            if "hello" in parsed.unparsed:
                self.tell_others("{Actor} says: \"Oh hello, I'm Eskarina if you need anything tested come to me and I'll make short work of it! "
                                 "I can also teach spell casting so if you have any questions let me know.\"")
            elif "test" in parsed.unparsed:
                if "staff" in parsed.unparsed:
                    if self.__contains__(staff):
                        self.tell_others("{Actor} takes out the staff, looking it over and inspecting it. She gives it a swing and unleashes a massive lightning bolt on the target in front of her."
                                         "{Actor} says: \"I think that will do for the moment but it still needs improvement. So you may need to interview some more people and see what they think of this prototype.\"")
                    else:
                        self.tell_others("{Actor} says: \"I can't test the staff if I don't have one.\"")
                else:
                    return
            elif "what" in parsed.unparsed:
                if "issues" or "faults" and "staff" in parsed.unparsed:
                    self.tell_others("{Actor} says: \"The main issues I have with the staffs is that new wizards seem to forget the spells after casting them the first time. "
                                     "If a new staff could be made to stop the user from forgetting the spells after they cast them that would solve a major problem for me\".")
                elif "role" or "teach" and "here" or "university" in parsed.unparsed:
                    self.tell_others("{Actor} says: \"I teach casting skills and how to perform spells in the university. "
                                     "Its a tricky job trying to teach a new wizard and not have them blow themselves up or vanish themselves from this plane of existence.\"")
                else:
                    return
            elif "require" in parsed.unparsed:
                if "remember" and "spell" and "cast" in parsed.unparsed:
                    self.tell_others("{Actor} says: \"Yes I want the staff to allow new users to remember the spells they cast.\"")
                    self.give_req_scroll(actor, scroll)
                else:
                    return
            else:
                return
        #call to give player item
        def give_req_scroll(self, actor: Living, scroll: Item) -> None:
            scroll.move(actor, self)
            self.tell_others("{Actor} says: \"Here's the requirement written on a scroll.\"")

        #periodically called action the actor carries out
        @call_periodically(5, 40)
        def cast_spell(self, ctx: Context) -> None:
            if random.random() < 0.5:
                self.tell_others("Eskarina flourishes her hands and casts a spell. The box sitting in front of her begins to levitate.")
            else:
                self.tell_others("Eskarina flourishes her hands and casts a spell. The box explodes into a ball of flames.")
        #setting the items the player and the game can give the actor
        def allow_give_item(self, item: Item, actor: 'Living'):
            if item.name == "new staff":
                self.tell_others("{Actor} says: \"Thank you for the new staff. Let me know if you want me to test it.\"")
            elif item.name == "eskarinas requirement scroll":
                return True
            else:
                raise ActionRefused("%s doesn't want %s." % (lang.capital(self.title), item.title))
