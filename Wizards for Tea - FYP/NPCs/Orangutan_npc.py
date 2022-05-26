
from tale.base import Living, ParseResult, Item
from tale.util import call_periodically, Context

class Orangutan(Living):

    def notify_action(self, parsed: ParseResult, actor: 'Living') -> None:
        #requirements scroll given to the actor
        scroll = self.search_item("orangutans requirement scroll", include_location=False)
        #if statement stops actor reacting to themselves
        if actor is self or parsed.verb in self.verbs:
            return
        #responses to the players questions
        if "hello" in parsed.unparsed:
            self.tell_others("{Actor} says: \"Ah you have arrived to get your scroll. "
                             "You've already visited and interviewed me so I have the requirement written down for you. "
                             "My requirement is that the staff measures the magic in the surrounding area and tells the user.\"")
            self.give_req_scroll(actor, scroll)
        elif "how" in parsed.unparsed:
            if "already" or "before" or "previously" in parsed.unparsed:
                self.tell_others("{Actor} says: \"This library is in L-Space. "
                                 "It is in all times and spaces at once. "
                                 "So you've already visited me at some point and already asked me the questions about the new staff.\"")
            else:
                return
        elif "who" in parsed.unparsed:
            if "are" and "you" in parsed.unparsed:
                self.tell_others("{Actor} says: \"I'm the Librarian for the library, I know I look like an orangutan but it's actually quite useful for getting around the bookshelves.\"")
            else:
                return
        elif "why" in parsed.unparsed:
            if "books" and "chained" in parsed.unparsed:
                self.tell_others("{Actor} says: \"The books are chained to the shelves to protect the students as they have been known to make students mysteriously disappear.\"")
            elif "monkey" in parsed.unparsed:
                self.tell_others("{Actor} says: \"I'm not a Monkey! I'm an Orangutan there's quite the difference.\"")
            elif "orangutan" in parsed.unparsed:
                self.tell_others("{Actor} says: \"We tried a spell and well it ended up turning me into an Orangutan. But on the bright side its quite useful for navigating the library so I choose to stay this way.\"")
            else:
                return
        elif "what" in parsed.unparsed:
            if "L-space" in parsed.unparsed:
                self.tell_others("{Actor} says: \"L-Space is an area where magic has brought all times and numerous locations into one place. So you can enter here and leave at a different point in time or leave entering a different university.\"")
            else:
                return
        else:
            return
    #method to give player the scroll
    def give_req_scroll(self, actor: Living, scroll: Item) -> None:
            scroll.move(actor, self)
            self.tell_others("{Actor} says: Here's the requirement written on a scroll.")
    #action called to periocically display text
    @call_periodically(5, 40)
    def swing_from_shelves(self, ctx: Context) -> None:
        self.tell_others("The orangutan swings from one shelf to another with ease. He examines the books and ensures they are chained down properly.")