import com.beust.ah.A;

import java.awt.*;
import java.util.Scanner;

public class Main {

    static Scanner Keybord = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Enter Your Instagram Username :");
        String UserName = Keybord.nextLine();
        System.out.println("Enter Your Instagram Password :");
        String Password = Keybord.nextLine();
        System.out.println("Enter Username To Like Instagram Posts :");
        String TargetProfile = Keybord.nextLine();

        App App = new App();
        App.LoginWith(UserName,Password);
        App.NavigationToProfile(TargetProfile);
        App.ClickFirstPost();
        App.LikeAllPost();
    }
}
