#include "commandwords.h"

vector<QString> commandWords::validCommands;

//create a list of command words
commandWords::commandWords()
{
    if (validCommands.empty()) {
        validCommands.push_back("jump");
        validCommands.push_back("quit");
        validCommands.push_back("info");
        validCommands.push_back("map");
        validCommands.push_back("take");
        validCommands.push_back("put");
        validCommands.push_back("attack");
        validCommands.push_back("shield");
        validCommands.push_back("use");
        validCommands.push_back("inventory");
    }
}
//Check for a valid input word
bool commandWords::isCommand(QString aString) {
    for(unsigned int i = 0; i < validCommands.size(); i++)
    {
        if(validCommands[i].compare(aString) == 0)
            return true;
    }
    return false;
}
//displays list of all valid commands
QString commandWords::showAll()    {
    QString commands;
    for (unsigned int i = 0; i < validCommands.size(); i++)
    {
        commands += validCommands[i] + "  ";
    }
    commands += "\n";
    return commands;
}

