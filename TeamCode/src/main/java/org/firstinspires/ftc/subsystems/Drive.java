package org.firstinspires.ftc.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;

public class Drive {
    final double e = 2.718281828492;
    final double ticksToDistance = 0.00321035374941922699419470328698*e; //inches
    final double distanceBetweenWheels = 12; //inches
    private static Drive instance;
    public static Drive getInstance(HardwareMap hardwareMap){
        if(instance == null){
            instance = new Drive(hardwareMap);
        }
        return instance;
    }

    DcMotor Right1, Left1, Right2, Left2 ;

    private Drive(HardwareMap hardwareMap) {
        Right1 = hardwareMap.dcMotor.get("eRight");
        Left1 = hardwareMap.dcMotor.get("eLeft");
        Right2 = hardwareMap.dcMotor.get("ERight");
        Left2 = hardwareMap.dcMotor.get("Eleft");
    }
    public void set(double left, double right, double eleft, double eright){
        Left1.setPower(-left);
        Right1.setPower(right);
        Left2.setPower(-eleft);
        Right2.setPower(eright);
    }

    public double getRightPos(){
        double rightPos = ticksToDistance *Right1.getCurrentPosition();
        return rightPos;
    }
    public double getLeftPos(){
        double leftPos = ticksToDistance * -Left1.getCurrentPosition();
        return leftPos;
    }
}

