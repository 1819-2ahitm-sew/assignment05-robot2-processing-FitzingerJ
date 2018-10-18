package at.htl.robot.gui;

import at.htl.robot.model.Direction;
import at.htl.robot.model.Mode;
import at.htl.robot.model.Robot;
import processing.core.PApplet;


public class Main extends PApplet {

    int leftMargin = 20;
    int upperMargin = 20;
    int boxLength = 50;
    Robot robot;
    private Mode mode = Mode.Teleport;
    int count = 1;
    char modeText = 'T';
    int textX = 6;
    int textY = 9;
    // Hier die Member-Attribute eintragen

    public static void main(String[] args) {
        PApplet.main("at.htl.robot.gui.Main", args);
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        background(209); //https://processing.org/tutorials/color/

        robot = new Robot();
        robot.setX(1);
        robot.setY(1);
    }

    /**
     * Diese Methode wird iterativ durchlaufen (wie loop() beim Arduino)
     */
    public void draw() {
        strokeWeight(3);
        textSize(20);

        for (int i = 0; i < 11; i++) {
            line(
                    leftMargin,
                    upperMargin + i * boxLength,
                    leftMargin + 10 * boxLength,
                    upperMargin + i * boxLength
            );
            line(
                    leftMargin + i * boxLength,
                    upperMargin,
                    leftMargin + i * boxLength,
                    upperMargin + 10 * boxLength
            );
            /*ellipse(
                    leftMargin + boxLength / 2,
                    upperMargin + boxLength / 2,
                    (int) (boxLength * 0.8),
                    (int) (boxLength * 0.8)
            );
            ellipse(
                    leftMargin + boxLength / 2 + 1 * boxLength,
                    upperMargin + boxLength / 2,
                    (int) (boxLength * 0.8),
                    (int) (boxLength * 0.8)
            );
            ellipse(
                    leftMargin + boxLength / 2,
                    upperMargin + boxLength / 2 + 1 * boxLength,
                    (int) (boxLength * 0.8),
                    (int) (boxLength * 0.8)
            );*/
            fill(255, 255, 255);
            ellipse(
                    leftMargin - boxLength / 2 + robot.getX() * boxLength,
                    upperMargin - boxLength / 2 + robot.getY() * boxLength,
                    (int) (boxLength * 0.8),
                    (int) (boxLength * 0.8)
            );
            if (robot.getDirection() == Direction.SOUTH) {
                fill(255, 0, 0);
                text(
                        modeText,
                        leftMargin - boxLength / 2 + robot.getX() * boxLength - textX,
                        upperMargin - boxLength / 2 + robot.getY() * boxLength + textY + 5
                );
            } else if (robot.getDirection() == Direction.EAST) {
                fill(255, 0, 0);
                text(
                        modeText,
                        leftMargin - boxLength / 2 + robot.getX() * boxLength - textX + 5,
                        upperMargin - boxLength / 2 + robot.getY() * boxLength + textY
                );
            } else if (robot.getDirection() == Direction.NORTH) {
                fill(255, 0, 0);
                text(
                        modeText,
                        leftMargin - boxLength / 2 + robot.getX() * boxLength - textX,
                        upperMargin - boxLength / 2 + robot.getY() * boxLength + textY - 5
                );
            } else if (robot.getDirection() == Direction.WEST) {
                fill(255, 0, 0);
                text(
                        modeText,
                        leftMargin - boxLength / 2 + robot.getX() * boxLength - textX - 5,
                        upperMargin - boxLength / 2 + robot.getY() * boxLength + textY
                );
            }
        }
    }

    /**
     * Erstellen Sie eine eigene Methode, mittels der der Roboter am Bildschirm gezeichnet wird
     * Die Angabe zu Position des Roboters am Spielfeld erhalten Sie aus dem Roboter-Objekt, welches
     * als Parameter übergeben wird.
     *
     * @param robot Objekt des zu zeichnenden Roboters
     */
    public void drawRobot(Robot robot) {


    }

    /**
     * Erstellen Sie eine eigene Methode zum Löschen des Bildschirms
     */
    public void deleteAll() {
        background(209);
    }

    /**
     * In dieser Methode reagieren Sie auf die Tasten
     */
    public void keyPressed() {
        println("pressed " + key + " " + keyCode);

        if(key == 'm' || key == 'M'){
            if (count % 2 == 0){
                mode = Mode.Teleport;
                modeText = 'T';
            } else {
                mode = Mode.Restrict;
                modeText = 'R';
            }
            count++;
        }
        if (key == 'f' || key == 'F') {
            deleteAll();
            robot.stepForward();
            if (mode == Mode.Teleport) {
                if (robot.getX() > 10) {
                    robot.setX(1);
                } else if (robot.getY() > 10) {
                    robot.setY(1);
                } else if (robot.getX() < 1) {
                    robot.setX(10);
                } else if (robot.getY() < 1) {
                    robot.setY(10);
                }
            } else if (mode == Mode.Restrict){
                if (robot.getX() > 10) {
                    robot.setX(10);
                } else if (robot.getY() > 10) {
                    robot.setY(10);
                } else if (robot.getX() < 1) {
                    robot.setX(1);
                } else if (robot.getY() < 1) {
                    robot.setY(1);
                }
            }
        } else if (key == 'l' || key == 'L') {
            robot.rotateLeft();
        }


    }

//    public void keyTyped() {
//        println("typed " + key + " " + keyCode);
//    }
//
//    public void keyReleased() {
//        println("released " + key + " " + keyCode);
//    }

}
