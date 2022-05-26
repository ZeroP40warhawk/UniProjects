#ifndef COMMANDWORDS_H
#define COMMANDWORDS_H

#include <iostream>
#include <QString>
#include <vector>
using namespace std;

class commandWords
{
public:
    commandWords();
    bool isCommand(QString aString);
    QString showAll();

private:
    static vector<QString> validCommands;
};

#endif // COMMANDWORDS_H
