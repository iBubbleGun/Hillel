package edu.hillel.homework.lesson5;

import edu.hillel.homework.lesson5.geomety.GeometricFigure;
import edu.hillel.homework.lesson5.geomety.figures.Circle;
import edu.hillel.homework.lesson5.geomety.figures.Square;
import edu.hillel.homework.lesson5.geomety.figures.Triangle;
import edu.hillel.homework.lesson5.obstacles.Let;
import edu.hillel.homework.lesson5.obstacles.ObstacleController;
import edu.hillel.homework.lesson5.obstacles.Participant;
import edu.hillel.homework.lesson5.obstacles.lets.Treadmill;
import edu.hillel.homework.lesson5.obstacles.lets.Wall;
import edu.hillel.homework.lesson5.obstacles.participants.Cat;
import edu.hillel.homework.lesson5.obstacles.participants.Human;
import edu.hillel.homework.lesson5.obstacles.participants.Robot;

public class Main {

    public static void main(String[] args) {

        //////////////////////////////////////////
        // Geometric Figures calculations start //
        //////////////////////////////////////////
        System.out.println("Homework part 1\n==== Geometric Figures Calculations ====");

        GeometricFigure[] figures = {
                new Square(12.1),
                new Circle(7.6),
                new Triangle(5.4, 11.3)
        };

        double totalArea = 0;
        for (GeometricFigure gf : figures) {
            double figureArea = gf.calculateFigureArea();
            System.out.println("The area of a " + gf.getClass().getSimpleName() + " is " + figureArea + " square units.");
            totalArea += figureArea;
        }
        System.out.println("The total area of all geometric shapes is " + totalArea + " square units.\n\n");
        ////////////////////////////////////////
        // Geometric Figures calculations end //
        ////////////////////////////////////////

        ////////////////////////
        // Competitions start //
        ////////////////////////
        System.out.println("Homework part 2\n==== Competitions start ====");

        ObstacleController controller = new ObstacleController();

        Let[] letArray = {
                new Treadmill(),
                new Wall()
        };

        Participant[] participantArray = {
                new Human("Bob"),
                new Cat("Fluffy"),
                new Robot("Android")
        };

        for (int i = 0; i < participantArray.length; i++) {
            for (Let let : letArray) {
                int distance = 0;

                let.obstacle(); // print message about current obstacle

                if (let instanceof Treadmill) {
                    distance = ((Treadmill) let).getDistance();
                } else if (let instanceof Wall) {
                    distance = ((Wall) let).getDistance();
                }

                participantArray[i].participateInCompetition(let, distance, controller);

                if (i == 0 && !controller.isHumanOvercome()) {
                    break;
                } else if (i == 1 && !controller.isCatOvercome()) {
                    break;
                } else if (i == 2 && !controller.isRobotOvercome()) {
                    break;
                }
            }
        }

        System.out.println("\n=== Competition results ===");
        for (Participant p : participantArray) {
            if (p instanceof Human) {
                if (controller.isHumanOvercome()) {
                    System.out.println("Participant human " + ((Human) p).getName() + " successfully passed all obstacles.");
                } else {
                    System.out.println("Competitor human " + ((Human) p).getName() + " dropped out of the competition.");
                }
            } else if (p instanceof Cat) {
                if (controller.isCatOvercome()) {
                    System.out.println("Participant cat " + ((Cat) p).getName() + " successfully passed all obstacles.");
                } else {
                    System.out.println("Competitor cat " + ((Cat) p).getName() + " dropped out of the competition.");
                }
            } else if (p instanceof Robot) {
                if (controller.isRobotOvercome()) {
                    System.out.println("Participant robot " + ((Robot) p).getName() + " successfully passed all obstacles.");
                } else {
                    System.out.println("Competitor robot " + ((Robot) p).getName() + " dropped out of the competition.");
                }
            }
        }

        //////////////////////
        // Competitions end //
        //////////////////////
    }
}
