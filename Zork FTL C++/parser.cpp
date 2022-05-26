#include "parser.h"

Parser::Parser()
{
    commands = new commandWords();
}
Command* Parser::getCommand(QString temp)   {
    string input;
    string word1;
    string word2;
    vector<string> words;

    input = temp.toStdString();
    string::size_type pos = 0, last_pos = 0;
    bool finished = false;
    while (!finished) {
        pos = input.find_first_of(' ', last_pos);	// find and remember first space.
        if (pos == string::npos ) {			// if we found the last word,
            words.push_back(input.substr(last_pos));	// add it to vector "words"
            finished = true;				// and finish searching.
        } else {					// otherwise add to vector and move on to next word.
            words.push_back(input.substr(last_pos, pos - last_pos));
            last_pos = pos + 1;
        }
    }

    if (words.size() == 1) //was only 1 word entered?
        word1 = words[0]; //get first word
    else if (words.size() >= 2) { //were at least 2 words entered?
        word1 = words[0]; //get first word
        word2 = words[1]; //get second word
    }

    // note: we just ignore the rest of the input line.
    // Now check whether this word is known. If so, create a command with it.
    // If not, create a "nil" command (empty string for unknown command).

    if (commands->isCommand(QString::fromUtf8(word1.data(), word1.size())))
        return new Command(QString::fromUtf8(word1.data(), word1.size()), QString::fromUtf8(word2.data(), word2.size()));
    else
        return new Command("", QString::fromUtf8(word2.data(), word2.size()));

}
QString Parser::showCommands(){
    return commands->showAll();
}

