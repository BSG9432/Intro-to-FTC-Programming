package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name = "LeTeleCode")
public class BasicTele extends OpMode {
    //name your variables
    public DcMotor frontRight;
    public DcMotor frontLeft;
    public DcMotor backRight;
    public DcMotor backLeft;

    @Override
    public void init() {
        //set a name to configure on the phone for each motor
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        /* makes left motors naturally turn clockwise when power is a positive number
        As such, to go "forward", all four motors will be positive */
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        //to make the left side go forward
        if (Math.abs(gamepad1.left_stick_y) > .1) {
            frontLeft.setPower(-gamepad1.left_stick_y);
            backLeft.setPower(-gamepad1.left_stick_y);
        }
        else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
        }

        //to make the right side go forward
        if (Math.abs(gamepad1.right_stick_y) > .1) {
            frontRight.setPower(-gamepad1.right_stick_y);
            backRight.setPower(-gamepad1.right_stick_y);
        }
        else {
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        //strafe to right
        if(gamepad1.left_stick_x > .1) {
            frontLeft.setPower(gamepad1.left_stick_x);
            backLeft.setPower(-gamepad1.left_stick_x);
            frontRight.setPower(-gamepad1.left_stick_x);
            backRight.setPower(gamepad1.left_stick_x);
        }
        //strafe left
        else if (gamepad1.left_stick_x < -.1) {
            frontLeft.setPower(-gamepad1.left_stick_x);
            backLeft.setPower( gamepad1.left_stick_x);
            frontRight.setPower( gamepad1.left_stick_x);
            backRight.setPower(-gamepad1.left_stick_x);
        }
        else {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }




















    }
}
