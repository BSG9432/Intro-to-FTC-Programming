package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Challenge4")
public class Challenge4 extends LinearOpMode {
    public DcMotor left;
    public DcMotor right;

    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

        waitForStart();

        //point turn clockwise 2.75 seconds
        left.setPower(-.5);
        right.setPower(0);
        sleep(2750);

        //stop for 1 second
        left.setPower(0);
        right.setPower(0);
        sleep(1000);

        //go backwards for 2 seconds
        left.setPower(.5);
        right.setPower(-.5);
        sleep(2000);

        //pivot turn ccw for 2 seconds
        left.setPower(.5);
        right.setPower(.5);
        sleep(4000);
    }
}