package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Challenge3")
public class Challenge3 extends LinearOpMode {
    public DcMotor left;
    public DcMotor right;

    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

        waitForStart();

        //point turn clockwise 2.5 seconds
        left.setPower(-.5);
        right.setPower(0);
        sleep(2500);

        //stop for 1 second
        left.setPower(0);
        right.setPower(0);
        sleep(1000);

        //point turn ccw for 4 seconds
        left.setPower(0);
        right.setPower(.5);
        sleep(4000);
    }
}
