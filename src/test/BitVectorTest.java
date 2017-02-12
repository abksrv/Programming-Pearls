import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import bitvector.BitVector;

public class BitVectorTest {

	private BitVector bv;

	@Rule
	public ExpectedException e = ExpectedException.none();

	@Before
	public void setUp() {
		bv = new BitVector();
	}

	@Test
	public void set_0thBit_isSet0isTrue() {
		bv.set(0);
		boolean isSet = bv.isSet(0);
		assertTrue(isSet);
	}

	@Test
	public void set_100thBit_isSet1000isTrue() {
		bv.set(0);
		boolean isSet = bv.isSet(0);
		assertTrue(isSet);
	}

	@Test
	public void isSet_nothingSet() {
		e.expect(IllegalArgumentException.class);
		bv.isSet(1);
	}

	@Test
	public void set_set63checkOn62_isReset() {
		bv.set(63);
		assertFalse(bv.isSet(62));
	}

	@Test
	public void set_set63checkOn63_isSet() {
		bv.set(63);
		assertTrue(bv.isSet(63));
	}

	@Test
	public void set_set3387898878checkOn3387898878_isSet() {
		bv.set(3387898878l);
		assertTrue(bv.isSet(3387898878l));
	}
	
	@Ignore
	@Test
	public void set_setRangecheckOnBelowThatRange() {
		for (int i = 9000000; i < 10000000; i++) {
			bv.set(i);
		}
		for (int i = 9000000 - 1; i >= 0; i--) {
			assertFalse(bv.isSet(i));
		}
	}

	@Test
	public void isSet_size64checkOn64_throwEx() {
		bv.set(63);
		e.expect(IllegalArgumentException.class);
		bv.isSet(64);
	}
	
	@Test
	public void reset_set3387898878resetCheckOn3387898878_isReSet() {
		bv.set(3387898878l);
		bv.reset(3387898878l);
		assertFalse(bv.isSet(3387898878l));
	}
	 
	@Test
	public void reset_set1resetCheckOn1_isReSet() {
		bv.set(1);
		bv.reset(1);
		assertFalse(bv.isSet(1));
	}
	
	@Test
	public void reset_set1resetCheckOn1_throwEx() {
		bv.set(1);
		e.expect(IllegalArgumentException.class);
		bv.reset(2);
	}
	
	@Test
	public void length_initial0(){
		Assert.assertEquals(0, bv.length());
	}
	
	@Test
	public void length_length10(){
		bv.set(0);
		bv.set(9);
		Assert.assertEquals(10, bv.length());
	}
	
	@Test
	public void length_length3387898878(){
		bv.set(0);
		bv.set(3387898878l);
		Assert.assertEquals(3387898879l, bv.length());
	}
}
