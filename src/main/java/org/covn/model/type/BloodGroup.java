package org.covn.model.type;

public enum BloodGroup implements BaseEnum{
	bldgrpBPos("bldgrp_b_pos"),
	bldgrpA1bPos("bldgrp_a1b_pos"),
	bldgrpA2bNeg("bldgrp_a2b_neg"),
	bldgrpA2Pos("bldgrp_a2_pos"),
	bldgrpAbNeg("bldgrp_ab_neg"),
	pos("bldgrp_o_pos"),
	bldgrpANeg("bldgrp_a_neg"),
	bldgrpA2Neg("bldgrp_a2_neg"),
	bldgrpAbPos("bldgrp_ab_pos"),
	bldgrpOtherRare("bldgrp_other_rare"),
	neg("bldgrp_o_neg"),
	bldgrpA1Pos("bldgrp_a1_pos"),
	bldgrpAPos("bldgrp_a_pos"),
	bldgrpA1bNeg("bldgrp_a1b_neg"),
	bldgrpA2bPos("bldgrp_a2b_pos"),
	bldgrpA1Neg("bldgrp_a1_neg"),
	bldgrpBNeg("bldgrp_b_neg"),
	;
	private final String key;
	private BloodGroup(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
