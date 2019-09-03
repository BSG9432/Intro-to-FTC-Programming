package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous (name = "mecanumAuto")

public class mecanumAuto extends LinearOpMode {

    public DcMotor frontRight;
    public DcMotor backRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;

    @Override
    public void runOpMode() throws InterruptedException {

        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE); //Makes left side rotate forward by default
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        drive(1,1000);
        drive(-1, 1000);
        pivotTurnLeft(1,1000);
        pivotTurnRight(1,1000);
        strafeLeft(1,1000);
        strafeRight(1,1000);

    }

    //METHODS BE HERE!
    public void drive (double power,int time) //Forward / Backwards movement (Can be + or -)
    {
        frontLeft.setPower(power);
        backLeft.setPower(power);
        frontRight.setPower(power);
        backRight.setPower(power);
        sleep(time);
    }

    public void pivotTurnRight (double power,int time) //Forward / Backwards movement
    {
        frontLeft.setPower(power);
        backLeft.setPower(power);
        frontRight.setPower(-power);
        backRight.setPower(-power);
        sleep(time);
    }

    public void pivotTurnLeft (double power,int time) //Forward / Backwards movement
    {
        frontLeft.setPower(-power);
        backLeft.setPower(-power);
        frontRight.setPower(power);
        backRight.setPower(power);
        sleep(time);
    }

    public void strafeLeft (double power,int time) //Forward / Backwards movement
    {
        frontLeft.setPower(-power);
        backLeft.setPower(power);
        frontRight.setPower(power);
        backRight.setPower(-power);
        sleep(time);
    }

    public void strafeRight (double power,int time) //Forward / Backwards movement
    {
        frontLeft.setPower(power);
        backLeft.setPower(-power);
        frontRight.setPower(-power);
        backRight.setPower(power);
        sleep(time);
    }

}
