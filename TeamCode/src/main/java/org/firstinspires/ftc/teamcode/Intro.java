package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Intro")
public class Intro extends LinearOpMode {
    public DcMotor left;
    public DcMotor right;

    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

        waitForStart();

        //go forward at half speed for 5 seconds
        left.setPower(-.5);
        right.setPower(.5);
        sleep(5000);

        //go backwards at half speed for 5 seconds
        left.setPower(.5);
        right.setPower(-.5);
        sleep(5000);
    }
}