package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "tylencoders", group = "pushbot")

public class tylencoders extends LinearOpMode {


    private ElapsedTime runtime = new ElapsedTime();


    public DcMotor frontRight;
    public DcMotor backRight;
    public DcMotor frontLeft;
    public DcMotor backLeft;

    static final double countsPerRevo = 1120; //neverest 40
    static final double driveGearReduction = 1.0;
    static final double wheelDiameter = 4.0;
    static final double countsPerInch = (countsPerRevo * driveGearReduction) / (wheelDiameter * 3.1415);
    static final double motorSpeed = .5;
    static final double turnSpeed = .5;

    @Override
    public void runOpMode()  {

        frontRight = hardwareMap.dcMotor.get("frontRight");
        backRight = hardwareMap.dcMotor.get("backRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backLeft = hardwareMap.dcMotor.get("backLeft");

        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();

        encoderDrive( motorSpeed,-5.0,5.0,2.0);


    }

    public void encoderDrive(double speed, double leftinch, double rightinch, double timeout)
    {
        int newLeftTarget;
        int newRightTarget;

        if(opModeIsActive())
        {
            newLeftTarget = frontLeft.getCurrentPosition() + (int) (leftinch * countsPerInch);
            newLeftTarget = backLeft.getCurrentPosition() + (int) (leftinch * countsPerInch);
            newRightTarget = frontRight.getCurrentPosition() + (int) (rightinch * countsPerInch);
            newRightTarget = backRight.getCurrentPosition() + (int) (rightinch * countsPerInch);

            frontLeft.setTargetPosition(newLeftTarget);
            frontRight.setTargetPosition(newRightTarget);
            backLeft.setTargetPosition(newLeftTarget);
            backRight.setTargetPosition(newRightTarget);

            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            runtime.reset();
            frontLeft.setPower(Math.abs(speed));
            frontRight.setPower(Math.abs(speed));
            backLeft.setPower(Math.abs(speed));
            backRight.setPower(Math.abs(speed));

            while (opModeIsActive() &&
                    (runtime.seconds() < timeout) &&
                    (frontRight.isBusy() && frontLeft.isBusy() && backRight.isBusy() && backLeft.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        frontRight.getCurrentPosition(),
                        frontLeft.getCurrentPosition(),
                        backRight.getCurrentPosition(),
                        backLeft.getCurrentPosition());

                telemetry.update();
            }

            frontRight.setPower(0);
            frontLeft.setPower(0);
            backRight.setPower(0);
            backLeft.setPower(0);

            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //sleep(100);

        }
    }
}
