
from tale.base import Living, ParseResult, Item
from tale.util import call_periodically, Context

class mustrumRidcully(Living):

    def notify_action(self, parsed: ParseResult, actor: Living) -> None:
        #stops actor reacting to themselves
        if actor is self or parsed.verb in self.verbs:
            return
        #responses to the players questions
        if "hello" in parsed.unparsed:
            self.tell_others("Mustrum Ridcully looks up from his book. {Actor} says: \"Ah you must be the new student %s? If you want to get started with your studies look for Professor Pondor Stibbons. He should be in the High Energy Magic Building.\"" % actor.title)
            actor.hints.checkpoint("talkStibbon","Find professor Stibbon.")
        elif "who" in parsed.unparsed:
            if "are" and "you" in parsed.unparsed:
                self.tell_others("{Actor} says: \"I'm Mustrum Ridcully the Archchancellor of the university.\"")
            else:
                return
        elif "what" in parsed.unparsed:
            if "do" and "you" or "role" in parsed.unparsed:
                self.tell_others("{Actor} says: \"I lead the university and represent it at the meetings in Ankh Morpork.\"")
            else:
                return
        elif "how" in parsed.unparsed:
            if "become" and "head" or "become" and "archchancellor" in parsed.unparsed:
                self.tell_others("{Actor} says: \"I became the Archchancellor through the universities long tradition of killing the current head and taking his place. No one has managed to take my place mostly because of my indestructibility.\"")
            else:
                return
        elif "where" in parsed.unparsed:
            if "high energy magic building" or "magic" and "building" in parsed.unparsed:
                self.tell_others("{Actor} says: \"If you return to the Universities Gardens and look north you will see the High Energy Magic Building.\"")
            else:
                return
        else:
            return
    #call to give player item
    def give_req_scroll(self, actor: Living, scroll: Item) -> None:
        scroll.move(actor, self)
        self.tell_others("{Actor} says: \"Here's the requirement written on a scroll.\"")
    #periodically called action by the actor
    @call_periodically(5, 20)
    def flick_pages(self, ctx: Context) -> None:
        self.tell_others("Mustrum Ridcully flicks through the pages of the large tome on his desk.")