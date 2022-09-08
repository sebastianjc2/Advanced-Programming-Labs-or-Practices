import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BiologicalSequencesTest {

	BiologicalSequences.DNASequence seq1;
	BiologicalSequences.DNASequence seq2;
	BiologicalSequences.DNASequence seqX;
	BiologicalSequences.DNASequence seqY;
	BiologicalSequences.DNASequence seqA;
	BiologicalSequences.DNASequence seqB;
	BiologicalSequences.DNASequence seqe;
	BiologicalSequences.DNASequence sub12;
	BiologicalSequences.DNASequence subXY;
	BiologicalSequences.DNASequence subAB;
	BiologicalSequences.DNASequence subAA;
	@Before
	public void setUp() {
		seq1 = new BiologicalSequences.DNASequence("abcabcc");
		seq2 = new BiologicalSequences.DNASequence("abcacbc");
		seqX = new BiologicalSequences.DNASequence("ACRaCAgAgRa");
		seqY = new BiologicalSequences.DNASequence("taCBAGagGadoO");
		seqA = new BiologicalSequences.DNASequence("TCAGTTGTTACTGCAATTT");
		seqB = new BiologicalSequences.DNASequence("AGATCAGTTGGTACTGCAATAA");
		seqe = new BiologicalSequences.DNASequence("");
		
		sub12 = new BiologicalSequences.DNASequence("ABCABC");
		subXY = new BiologicalSequences.DNASequence("ACAAGGA");
		subAB = new BiologicalSequences.DNASequence("TCAGTTGTACTGCAAT");
		subAA = new BiologicalSequences.DNASequence("TCAGTTGTTACTGCAATTT");
	}
	@Test
	public void testLongestCommonSubsequence() {
		assertEquals("It is not the correct result", sub12, BiologicalSequences.longestCommonSubsequence(seq1, seq2));
		assertEquals("It is not the correct result", subXY, BiologicalSequences.longestCommonSubsequence(seqX, seqY));
		assertEquals("It is not the correct result", subAB, BiologicalSequences.longestCommonSubsequence(seqA, seqB));
		assertEquals("It is not the correct result", subAA, BiologicalSequences.longestCommonSubsequence(seqA, seqA));
		assertEquals("It is not the correct result", seqe, BiologicalSequences.longestCommonSubsequence(seqA, seqe));
	}

}
