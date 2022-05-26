#ifndef PARSER_H
#define PARSER_H

#include <string>
#include <QString>
#include "command.h"
#include "commandwords.h"

class Parser
{
public:
    Parser();
    Command* getCommand(QString temp);
    QString showCommands();
private:
    commandWords *commands;
};

#endif // PARSER_H
