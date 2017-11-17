package br.ufal.ic.atividades.teste;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class BooleanArrayAsListTest {

    private BooleanArrayAsList emptyList;
    private BooleanArrayAsList smallList;
    private BooleanArrayAsList booleanList;
    private BooleanArrayAsList booleanAllTrueList;

    private boolean[] givenArray() {
        return new boolean[]{true, false, true, false, false};
    }
    private boolean[] givenTrueFilledArray() {
        return new boolean[]{true, true, true, true, true};
    }

    @Before
    public void init(){
        emptyList = new BooleanArrayAsList(new boolean[]{});
        smallList = new BooleanArrayAsList(new boolean[]{true, false});
        booleanList = new BooleanArrayAsList(givenArray());
        booleanAllTrueList = new BooleanArrayAsList(givenTrueFilledArray());
    }

    //-- size
    @Test
    public void shouldReturnBooleanListSize() {
        assertThat(booleanList.size(), is(equalTo(5)));
    }

    @Test
    public void shouldReturnEmptyListSize() {
        assertThat(emptyList.size(), is(equalTo(0)));
    }

    //-- isEmpty
    @Test
    public void shouldCheckBooleanListIsEmpty() {
        assertThat(booleanList.isEmpty(), is(equalTo(false)));
    }

    @Test
    public void shouldCheckEmptyListIsEmpty() {
        assertThat(emptyList.isEmpty(), is(equalTo(true)));
    }

    //-- get
    @Test
    public void shouldReturnElementByIndex() {
        Boolean firstElem = booleanList.get(0);
        assertThat(firstElem, is(equalTo(true)));

        Boolean secondElem = booleanList.get(1);
        assertThat(secondElem, is(equalTo(false)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBoundsException() {
        booleanList.get(10);
    }

    //-- contains
    @Test
    public void shouldCheckIfListContainsBoolean() {
        boolean contains = booleanList.contains(true);
        assertThat(contains, is(equalTo(true)));
    }

    @Test
    public void shouldCheckIfListDoesNotContainsBoolean() {
        boolean contains = booleanAllTrueList.contains(false);
        assertThat(contains, is(equalTo(false)));
    }

    @Test
    public void shouldCheckIfEmptyListContainsBoolean() {
        boolean contains = emptyList.contains(true);
        assertThat(contains, is(equalTo(false)));
    }

    //-- indexOf
    @Test
    public void shouldReturnIndexOfElemOnList() {
        int i = booleanList.indexOf(true);
        assertThat(i, is(equalTo(0)));
    }

    @Test
    public void shouldReturnIndexOfElemOnAllTrueList() {
        int i = booleanAllTrueList.indexOf(false);
        assertThat(i, is(equalTo(-1)));
    }

    @Test
    public void shouldReturnIndexOfElemOnEmptyList() {
        int i = emptyList.indexOf(true);
        assertThat(i, is(equalTo(-1)));
    }

    //-- lastIndexOf
    @Test
    public void shouldFindLastIndexOf() {
        int i = booleanList.lastIndexOf(true);
        assertThat(i, is(equalTo(2)));
    }

    @Test
    public void shouldNotFindLastIndexOf() {
        int i = booleanAllTrueList.lastIndexOf(false);
        assertThat(i, is(equalTo(-1)));
    }

    @Test
    public void shouldFindLastIndexOfEmptyList() {
        int i = emptyList.lastIndexOf(true);
        assertThat(i, is(equalTo(-1)));
    }

    //-- set
    @Test
    public void shouldSetNewValueOnIndexToFalse() {
        booleanList.set(0, false);
        assertThat(booleanList.get(0), is(equalTo(false)));
    }

    @Test
    public void shouldSetNewValueOnIndexToTrue() {
        booleanList.set(0, true);
        assertThat(booleanList.get(0), is(equalTo(true)));
    }

    @Test
    public void shouldReturnOldValueOnSet() {
        Boolean oldValue = booleanList.set(0, false);
        assertThat(oldValue, is(equalTo(true)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldNotSetValueOnEmptyList() {
        emptyList.set(3, false);
    }

    //-- subList
    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowUnsupportedOperationException() {
        booleanList.subList(0, 2);
    }

    //-- equals
    @Test
    public void shouldCheckIfListItselfIsEqual() {
        boolean isEqual = booleanList.equals(booleanList);
        assertThat(isEqual, is(equalTo(true)));
    }

    @Test
    public void shouldCheckIfListsAreEqual() {
        boolean isEqual = booleanList.equals(new BooleanArrayAsList(givenArray()));
        assertThat(isEqual, is(equalTo(true)));

        boolean isNotEqual = booleanList.equals(booleanAllTrueList);
        assertThat(isNotEqual, is(equalTo(false)));
    }

    @Test
    public void shouldCompareListWithEmptyList() {
        boolean isNotEqualEmptyList = booleanList.equals(emptyList);
        assertThat(isNotEqualEmptyList, is(equalTo(false)));
    }

    //-- hashCode
    /* true = 1231 & false = 1237
     * result = 31 * result + {true, false}
     */
    @Test
    public void shouldReturnListHashCode() {
        int listHashCode = smallList.hashCode();
        assertThat(listHashCode, is(equalTo(40359)));
    }

    @Test
    public void shouldReturnEmptyListHashCode() {
        int listHashCode = emptyList.hashCode();
        assertThat(listHashCode, is(equalTo(1)));
    }

    //-- toString
    @Test
    public void shouldConvertToString() {
        String stringObj = booleanList.toString();
        assertThat(stringObj.equals("[true, false, true, false, false]"), is(equalTo(true)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldConvertEmptyListToString() {
        String stringObj = emptyList.toString();
    }

    //-- toBooleanArray
    @Test
    public void shouldConvertToBooleanArray() {
        boolean[] booleans = booleanList.toBooleanArray();
        boolean isArrayOfPrimitives = (booleans instanceof boolean[]);
        assertThat(isArrayOfPrimitives, is(equalTo(true)));
    }

    @Test
    public void shouldConvertEmptyListToBooleanArray() {
        boolean[] booleans = emptyList.toBooleanArray();
        boolean isArrayOfPrimitives = (booleans instanceof boolean[]);
        assertThat(isArrayOfPrimitives, is(equalTo(true)));
    }

}
