package com.gr.java14;

public class NormalSwitchCase {

    public static void main(String[] args) {

        NormalSwitchCase normalSwitchCase = new NormalSwitchCase();
        int budget = 2000000;
        int numberOfBedRoomsUsingStatement = normalSwitchCase.getNumberOfRoomsUsingStatement(budget);
        int numberOfBedRoomsUsingExpression = normalSwitchCase.getNumberOfRoomsUsingExpression(budget);

        int numberOfBedRoomsUsingStatementDiscount = normalSwitchCase.getNumberOfRoomsUsingStatementWithDiscount(budget);
        int numberOfBedRoomsUsingYieldDiscount = normalSwitchCase.getNumberOfRoomsUsingYieldWithDiscount(budget);

        System.out.println("You can get a house with " + numberOfBedRoomsUsingStatement + " room(s) in this budget");

        System.out.println("You can get a house with " + numberOfBedRoomsUsingExpression + " room(s) in this budget");

        System.out.println("You can get a house with " + numberOfBedRoomsUsingStatementDiscount + " room(s) in this budget");

        System.out.println("You can get a house with " + numberOfBedRoomsUsingYieldDiscount + " room(s) in this budget");

        int numberOfBedRoomsUsingMixedStyle = normalSwitchCase.getNumberOfRoomsUsingStatementWithArrowLabel(budget);
        System.out.println("You can get a house with " + numberOfBedRoomsUsingMixedStyle + " room(s) in this budget");

        int numberOfBedRoomsUsingMixedStyleAgain = normalSwitchCase.getNumberOfRoomsUsingExpressionColonLabel(budget);
        System.out.println("You can get a house with " + numberOfBedRoomsUsingMixedStyleAgain + " room(s) in this budget");


    }


    public int getNumberOfRoomsUsingStatement(int budget) {
        int numberOfRooms = 0;
        switch (budget) {
            case 1000000: numberOfRooms = 1;
                          break;
            case 2000000:
            case 3000000: numberOfRooms = 2;
                          break;
            case 4000000:
            case 5000000: numberOfRooms = 3;
                          break;
            default:
                System.out.println("Hello");
        }
        return numberOfRooms;
    }

    public int getNumberOfRoomsUsingExpression(int budget) {

        int numberOfRooms = switch (budget) {
            case 1000000 -> 1;
            case 2000000, 3000000 -> 2;
            case 4000000, 5000000 -> 3;
            default -> throw new IllegalStateException("No rooms available for this budget");
        };
        return numberOfRooms;
    }

    public int getNumberOfRoomsUsingStatementWithDiscount(int budget) {
        int numberOfRooms;
        switch (budget) {
            case 1000000: numberOfRooms = 1;
                          break;
            case 2000000:
            case 3000000: int finalPrice = (budget == 3000000) ? budget - 100000 : budget;
                          System.out.println("Final price after discount " + finalPrice);
                          numberOfRooms = 2;
                          break;
            case 4000000:
            case 5000000: int finalPriceThreeRooms = (budget == 5000000) ? budget - 100000 : budget;
                          System.out.println("Final price after discount " + finalPriceThreeRooms);
                          numberOfRooms = 3;
                          break;
            default: throw new IllegalStateException("No rooms available for this budget");
        }
        return numberOfRooms;
    }


    public int getNumberOfRoomsUsingYieldWithDiscount(int budget) {
        int numberOfRooms = switch (budget) {
            case 1000000 ->  1;
            case 2000000, 3000000 -> {
                int finalPrice = (budget == 3000000) ? budget - 100000 : budget;
                System.out.println("Final price after discount " + finalPrice);

                yield 2;
            }
            case 4000000, 5000000 -> {
                int finalPrice = (budget == 5000000) ? budget - 100000 : budget;
                System.out.println("Final price after discount " + finalPrice);

                yield 3;
            }
            default -> throw new IllegalStateException("Unexpected value: " + budget);
        };
        return numberOfRooms;
    }

    public int getNumberOfRoomsUsingStatementWithArrowLabel(int budget) {
        int numberOfRooms;
        switch (budget) {
            case 1000000 -> numberOfRooms = 1;
            case 2000000, 3000000 -> {
                int finalPrice = (budget == 3000000) ? budget - 100000 : budget;
                System.out.println("Final price after discount " + finalPrice);
                numberOfRooms = 2;
            }
            case 4000000, 5000000 -> {
                int finalPrice = (budget == 5000000) ? budget - 100000 : budget;
                System.out.println("Final price after discount " + finalPrice);
                numberOfRooms = 3;
            }
            default -> throw new IllegalStateException("Unexpected value: " + budget);
        }
        return numberOfRooms;
    }

    public int getNumberOfRoomsUsingExpressionColonLabel(int budget) {
        return   switch (budget) {
            case 1000000: {
                yield 1;
            }
            case 2000000, 3000000: {
                int finalPrice = (budget == 3000000) ? budget - 100000 : budget;
                System.out.println("Final price after discount " + finalPrice);
                yield 2;
            }
            case 4000000, 5000000: {
                int finalPrice = (budget == 5000000) ? budget - 100000 : budget;
                System.out.println("Final price after discount " + finalPrice);
                yield 3;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + budget);
        };

    }
}
