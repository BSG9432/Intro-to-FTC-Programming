package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "Challenge1")
public class Challenge1 extends LinearOpMode {
    public DcMotor left;
    public DcMotor right;
    public Servo servoBoi;

    @Override
    public void runOpMode() throws InterruptedException {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        servoBoi = hardwareMap.dcMotor.get("servoBoi");

        waitForStart();

        left.setPower(-1);
        right.setPower(1);
        sleep(3000);

        left.setPower(0);
        right.setPower(0);
        sleep(2000);

        left.setPower(.5);
        right.setPower(-.5);
        
        servo.setPosition(.75);



    }
}
