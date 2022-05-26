#ifndef COMMAND_H
#define COMMAND_H

#include <QString>
using namespace std;

class Command
{
public:
    Command(QString firstWord, QString secondWord);
    QString getCommandWord();
    QString getSecondWord();
    bool isUnknown();
    bool hasSecondWord();
private:
    QString commandWord;
    QString secondWord;
};

#endif // COMMAND_H
