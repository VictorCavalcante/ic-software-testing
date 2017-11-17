package br.ufal.ic.atividades.teste;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class BoolsTest {

    private boolean[] givenArray() {
        return new boolean[]{false, false, true, false, false};
    }
    private boolean[] givenSmallArray() {
        return new boolean[]{true, false};
    }
    private boolean[] givenTrueFilledArray() {
        return new boolean[]{true, true, true, true, true};
    }
    private boolean[] givenFalseFilledArray() {
        return new boolean[]{false, false, false, false, false};
    }
    private ArrayList<Boolean> givenArrayList() {
        ArrayList<Boolean> boolsList = new ArrayList<Boolean>();
        boolsList.add(true);
        boolsList.add(false);
        return boolsList;
    }

    //-- compare
    @Test
    public void shouldCompareTwoBooleanValues() {
        assertThat(Bools.compare(true, true), is(equalTo(0)));
        assertThat(Bools.compare(true, false), is(equalTo(1)));
        assertThat(Bools.compare(false, true), is(equalTo(-1)));
    }

    //-- contains
    @Test
    public void shouldReturnTrueIfBooleanIsPresent() {
        boolean result = Bools.contains(givenArray(), true);
        assertThat(result, is(equalTo(true)));
    }

    @Test
    public void shouldReturnFalseIfBooleanIsNotPresent() {
        boolean result = Bools.contains(givenFalseFilledArray(), true);
        assertThat(result, is(equalTo(false)));
    }

    //-- indexOf
    @Test
    public void shouldFindIndexOf() {
        int lastIndexOf = Bools.indexOf(givenArray(), true);
        assertThat(lastIndexOf, is(equalTo(2)));
    }

    @Test
    public void shouldNotFindIndexOf() {
        int lastIndexOf = Bools.indexOf(givenFalseFilledArray(), true);
        assertThat(lastIndexOf, is(equalTo(-1)));
    }

    @Test
    public void shouldFindIndexOfSubList() {
        int lastIndexOf = Bools.indexOf(givenArray(), givenSmallArray());
        assertThat(lastIndexOf, is(equalTo(2)));
    }

    @Test
    public void shouldReturnZeroIfSubListIsEmpty() {
        int lastIndexOf = Bools.indexOf(givenArray(), new boolean[]{});
        assertThat(lastIndexOf, is(equalTo(0)));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerWhenSearchingForNullIndex() {
        int lastIndexOf = Bools.indexOf(givenArray(), null);
        assertThat(lastIndexOf, is(equalTo(-1)));
    }


    //-- lastIndexOf
    @Test
    public void shouldFindLastIndexOf() {
        int lastIndexOf = Bools.lastIndexOf(givenArray(), true);
        assertThat(lastIndexOf, is(equalTo(2)));
    }

    @Test
    public void shouldNotFindLastIndexOf() {
        int lastIndexOf = Bools.lastIndexOf(givenFalseFilledArray(), true);
        assertThat(lastIndexOf, is(equalTo(-1)));
    }

    //-- concat
    @Test
    public void shouldConcatBooleanArrays() {
        boolean[] concatResult = Bools.concat(
                new boolean[]{true, true},
                new boolean[]{false, false});
        boolean equalsResult = Arrays.equals(concatResult, (new boolean[]{true, true, false, false}));
        assertThat(equalsResult, is(equalTo(true)));
    }

    //-- toArray
    @Test
    public void shouldCopyBooleanListIntoNewArray() {
        boolean[] booleans = Bools.toArray(givenArrayList());
        boolean isArrayOfPrimitives = (booleans instanceof boolean[]);
        assertThat(isArrayOfPrimitives, is(equalTo(true)));
    }

    //-- asList
    @Test
    public void shouldReturnNewBooleanArrayAsList() {
        List<Boolean> newBooleanList = Bools.asList(givenArray());

        boolean isBooleanArrayAsList = newBooleanList instanceof BooleanArrayAsList;
        assertThat(isBooleanArrayAsList, is(equalTo(true)));
    }

    //-- countTrue
    @Test
    public void shouldReturnNumberOfValuesThatAreTrue() {
        int trueCount = Bools.countTrue(givenArray());
        assertThat(trueCount, is(equalTo(1)));

        int allTrueCount = Bools.countTrue(givenTrueFilledArray());
        assertThat(allTrueCount, is(equalTo(5)));

        int allfalseCount = Bools.countTrue(givenFalseFilledArray());
        assertThat(allfalseCount, is(equalTo(0)));
    }

    //-- checkNotNull
    @Test
    public void shouldCheckIfNotNull() {
        Boolean aBoolean = Bools.checkNotNull(true);
        assertThat(aBoolean, is(equalTo(true)));
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException() {
        Bools.checkNotNull(null);
    }

    //-- checkElementIndex
    @Test
    public void shouldReturnElementIndex() {
        int i = Bools.checkElementIndex(2, 6, "");
        assertThat(i, is(equalTo(2)));
    }
    
    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowIndexOutOfBoundsException() {
        Bools.checkElementIndex(2, 1, "");
    }

}
