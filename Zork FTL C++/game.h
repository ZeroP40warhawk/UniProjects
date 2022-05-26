#ifndef GAME_H
#define GAME_H

#include <QMainWindow>
#include <QString>
#include <string>

#include <planet.h>
#include <command.h>
#include <parser.h>
#include <item.h>
#include <playership.h>

namespace Ui {
class Game;
}

class Game : public QMainWindow
{
    Q_OBJECT

public:
    explicit Game(QWidget *parent = 0);
    ~Game();

private slots:
    void on_lineEdit_returnPressed();

    void on_sheepPlanet_released();

    void on_LorrainesPlanet_released();

    void on_rascallyRabbits_released();

    void on_notGavinsPlanet_released();

    void on_Xavier_released();

    void on_frozenPlanet_released();

    void on_leprachauns_released();

    void on_freedomBringer_released();

    void on_landmines_released();

    void on_ghastlyPlanet_released();

    void on_planetPokeMans_released();

    void on_moltenPlanet_released();

    void on_overWorkedStudents_released();

    void on_realRiders_released();

    void on_catsMeow_released();

    void on_memeLord_released();

    void on_jumpNorthBtn_released();

    void on_jumpWestBtn_released();

    void on_jumpEastBtn_released();

    void on_jumpSouthBtn_released();

    void on_atkBtn_released();

    void on_shieldBtn_released();

    void on_pushButton_released();

    void on_pushButton_2_released();

    void on_invenBtn_released();

private:
    Ui::Game *ui;
    void startGame();
    void printWelcome();
    void createPlanets();
    bool processCommand(Command command);
    void printHelp();
    void goRoom(Command command);
    void setupPlayer();
    void displayPlayer();

    QString temp;
    QString map;
    Command *command;
    Command *jump;
    planet *currentPlanet;
    Parser parser;
    playerShip *player;
    QString jumpD;
    QString north;
    QString east;
    QString south;
    QString west;
};

#endif // GAME_H
