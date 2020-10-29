package nz.ac.eit;

import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Before
    public void setup() {
        App app = new App();

        //Mock the user Input for numberValue 1 for player
        //Mockito.when(app.numberValue(1, "player")).thenReturn(1);

    }

    @Test
    public void getNumberValue_valueOf0_return10(){
        App app = new App();
        int numberRolled = 0;
        String whosTurn = "player"; //This variable doesn't change the value
        int result = App.numberValue(numberRolled, whosTurn);

        //Test if output matches expected result
        assertEquals(10, result);
    }

    @Test
    public void getNumberValue_valueOf1ForDealer_return11() {
        App app = new App();
        int numberRolled = 1;
        String whosTurn = "dealer";
        int result = App.numberValue(numberRolled, whosTurn);

        //Test if output matches expected result
        assertEquals(11, result);
    }

    /**@Test
    public void getNumberValue_valueOf1ForPlayer_returnChosenValueOf1() {
        App app = new App();
        int numberRolled = 1;
        String whosTurn = "player";

        int result = App.numberValue(numberRolled, whosTurn);

        //Test if output matches expected result
        assertEquals(1, result);
    }

    @Test
    public void getNumberValue_of1ForPlayer_returnChosenValueOf11() {
    }**/

    @Test
    public void getNumberValue_ofNumber2_returnValue2() {
        App app = new App();
        int numberRolled = 2;
        String whosTurn = "player";//This value doesn't change outcome

        int result = App.numberValue(numberRolled, whosTurn);

        //Test if output matches expected result
        assertEquals(2, result);
    }

    @Test
    public void getNumberValue_ofNumber9_returnValue9() {
        App app = new App();
        int numberRolled = 9;
        String whosTurn = "player";//This value doesn't change outcome

        int result = App.numberValue(numberRolled, whosTurn);

        //Test if output matches expected result
        assertEquals(9, result);
    }

    @Test
    public void getBlackjackOrBust_isHandBlackjack_returnBlackjack() {
        App app = new App();
        String whosTurn = "player"; //This value only changes the message printed to screen not the value returned.
        ArrayList<Integer> valueOfHand = new ArrayList<Integer>();
        valueOfHand.add(10);
        valueOfHand.add(11);

        String result = App.blackjackOrBust(valueOfHand, whosTurn);

        //Test if output matches expected result.
        assertEquals("blackjack", result);
    }

    @Test
    public void getBlackjackOrBust_isHandBust_returnBust() {
        App app = new App();
        String whosTurn = "player"; //This value only changes the message printed to screen not the value returned.
        ArrayList<Integer> valueOfHand = new ArrayList<Integer>();
        valueOfHand.add(5);
        valueOfHand.add(9);
        valueOfHand.add(7);

        String result = App.blackjackOrBust(valueOfHand, whosTurn);

        //Test if output matches expected result.
        assertEquals("bust", result);
    }

    @Test
    public void getBlackjackOrBust_canContinue_returnPlayOn() {
        App app = new App();
        String whosTurn = "player"; //This value only changes the message printed to screen not the value returned.
        ArrayList<Integer> valueOfHand = new ArrayList<Integer>();
        valueOfHand.add(5);
        valueOfHand.add(9);
        valueOfHand.add(3);

        String result = App.blackjackOrBust(valueOfHand, whosTurn);

        //Test if output matches expected result.
        assertEquals("play on", result);
    }

    @Test
    public void getDealerMove_dealerHandTotalOver17_returnHold() {
        App app = new App();
        ArrayList<Integer> dealersHand = new ArrayList<Integer>();
        dealersHand.add(2);
        dealersHand.add(8);
        dealersHand.add(8);

        String result = App.dealersMove(dealersHand);

        //Test if output matches expected result.
        assertEquals("hold", result);
    }

    @Test
    public void getDealerMove_dealerHandTotalUnder17_returnRoll() {
        App app = new App();
        ArrayList<Integer> dealersHand = new ArrayList<Integer>();
        dealersHand.add(4);
        dealersHand.add(6);
        dealersHand.add(6);

        String result = App.dealersMove(dealersHand);

        //Test if output matches expected result.
        assertEquals("roll", result);
    }

    @Test
    public void getDealerMove_dealerHandTotalEqual17_returnHold() {
        App app = new App();
        ArrayList<Integer> dealersHand = new ArrayList<Integer>();
        dealersHand.add(4);
        dealersHand.add(6);
        dealersHand.add(7);

        String result = App.dealersMove(dealersHand);

        //Test if output matches expected result.
        assertEquals("hold", result);
    }
}
