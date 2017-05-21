package BasicJava;

/**
 * Created by Wei on 2017/5/22.
 */
public class EnumTest {
    Day day;

    public EnumTest(Day day){
        this.day = day;
    }

    public void tell(){
        switch (day){
            case MONDAY:
                System.out.println("Monday is great!");
                break;
        }
    }

    public static void main(String[] args){
        EnumTest firstday = new EnumTest(Day.MONDAY);
        firstday.tell();
    }
}
