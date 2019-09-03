package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "MecanumTele")

public class mecanumTele extends OpMode {

    public DcMotor frontRight;
    public DcMotor backRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;

    @Override
    public void init() {

        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        backLeft.setDirection(DcMotorSimple.Direction.REVERSE); //Makes left side rotate forward by default
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    @Override
    public void loop() {

        if(Math.abs(gamepad1.left_stick_y) > .1) //Left Side
        {
            frontLeft.setPower(gamepad1.left_stick_y);
            backLeft.setPower(gamepad1.left_stick_y);
        }
        else
        {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }

        if(Math.abs(gamepad1.right_stick_y) > .1) //Right Side
        {
            frontRight.setPower(gamepad1.right_stick_y);
            backRight.setPower(gamepad1.right_stick_y);
        }
        else
        {
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        if (gamepad1.left_stick_x > .1) // strafe RIGHT
        {
            frontRight.setPower(-1);
            backRight.setPower(1);
            frontLeft.setPower(1);
            backLeft.setPower(-1);

        }
        else
        {
            frontRight.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }

        if (gamepad1.left_stick_x < -.1) // strafe LEFT
        {
            frontRight.setPower(1);
            backRight.setPower(-1);
            frontLeft.setPower(-1);
            backLeft.setPower(1);

        }
        else
        {
            frontRight.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }

        /*
        if (gamepad1.right_bumper) // strafe RIGHT (rightBUMPER)
        {
            frontRight.setPower(-1);
            backRight.setPower(1);
            frontLeft.setPower(1);
            backLeft.setPower(-1);

        }
        else
        {
            frontRight.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }

        if (gamepad1.left_bumper) // strafe LEFT (leftBUMPER)
        {
            frontRight.setPower(1);
            backRight.setPower(-1);
            frontLeft.setPower(-1);
            backLeft.setPower(1);

        }
        else
        {
            frontRight.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }
        */

    }
}
