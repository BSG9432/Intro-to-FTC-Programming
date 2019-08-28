package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class WowNewIntro extends LinearOpMode {
    @Override
    public DcMotor left;
    public DcMotor right;
    public Servo servoBoi;

    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        servoBoi = hardwareMap.servo.get("servoBoi");

        waitForStart();

        //start writing your code here

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
        right.setPower(-rightPower);
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
}
