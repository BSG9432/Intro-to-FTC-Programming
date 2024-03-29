package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//code for robot with 2 wheels built for the programming workshop
@Autonomous (name = "cringe_code")//this is the name of the code that shows up on the phone
                                //for competitions, you need a different name for each program
public class WowNewIntro extends LinearOpMode {
    public DcMotor left;
    public DcMotor right;
    public Servo servoBoi;

    @Override//
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.dcMotor.get("left");//   (>._____.)> function
        right = hardwareMap.dcMotor.get("right");
        servoBoi = hardwareMap.servo.get("servoMann");

        waitForStart();

        //start writing your code here wow very code

        goForward(.5,.5,5000);//go forward for 5sec
        goBackwards(1,1,5000);//go backwards for 5 seconds
        pivotTurnRight(.5,.5,10000);
        pointTurnLeft(1,10000);
        goBackwards(.75,.75,3500);


    }

    //use these "functions" below to write the code
    public void goForward(double leftPower, double rightPower,
                          int milliseconds){
        left.setPower(-leftPower);
        right.setPower(rightPower);
        sleep(milliseconds);
    }

    public void goBackwards(double leftPower, double rightPower,
                            int milliseconds) {
        left.setPower(leftPower);
        right.setPower(-rightPower);// from 0-1
        sleep(milliseconds);
    }

    public void pointTurnLeft(double rightPower,
                            int milliseconds) {
        left.setPower(0);
        right.setPower(rightPower);
        sleep(milliseconds);
    }

    public void pointTurnRight(double leftPower,
                            int milliseconds) {
        left.setPower(-leftPower);
        right.setPower(0);
        sleep(milliseconds);
    }
    
    public void pivotTurnLeft(double leftPower,double rightPower,
                              int milliseconds) {
        left.setPower(leftPower);
        right.setPower(rightPower);
        sleep(milliseconds);
    }

    public void pivotTurnRight (double leftPower,double rightPower,int milliseconds){
        left.setPower(-leftPower);
        right.setPower(-rightPower);
        sleep(milliseconds);

    }
}
