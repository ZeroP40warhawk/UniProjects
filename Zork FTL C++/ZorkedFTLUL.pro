#-------------------------------------------------
#
# Project created by QtCreator 2016-11-09T21:02:33
#
#-------------------------------------------------

QT       += core gui

greaterThan(QT_MAJOR_VERSION, 4): QT += widgets

TARGET = ZorkedFTLUL
TEMPLATE = app


SOURCES += main.cpp\
        game.cpp \
    command.cpp \
    commandwords.cpp \
    parser.cpp \
    enemyship.cpp \
    playership.cpp \
    ship.cpp \
    item.cpp \
    planet.cpp \
    spacestation.cpp

HEADERS  += game.h \
    command.h \
    commandwords.h \
    parser.h \
    enemyship.h \
    playership.h \
    ship.h \
    item.h \
    spacestation.h \
    planet.h

FORMS    += game.ui

RESOURCES += \
    map.qrc
