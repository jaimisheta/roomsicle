package controller;

import commandline.IRoomsicleCLI;

public class Navigator {

    public void navigator(){

        IRoomsicleCLI roomsicleCLI;
        int userInput;

        roomsicleCLI = ClassInitializer.initializer().getRoomsicleCLI();

        roomsicleCLI.printMessage("navigation.option");
        userInput = roomsicleCLI.getNumberResponse();

        if(userInput==1){

        }

    }
}
