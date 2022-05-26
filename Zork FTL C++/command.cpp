#include "command.h"

Command::Command(QString firstWord, QString secondWord)
{
    this->commandWord = firstWord;
    this->secondWord = secondWord;
}
//return command word
QString Command::getCommandWord() {
    return this->commandWord;
}
//return second word
QString Command::getSecondWord() {
    return this->secondWord;
}
//return true is this command was not understood
bool Command::isUnknown()   {
    return (commandWord.isEmpty());
}
//return true if the command has a second word
bool Command::hasSecondWord()   {
    return (!secondWord.isEmpty());
}
