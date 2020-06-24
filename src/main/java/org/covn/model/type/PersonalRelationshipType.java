package org.covn.model.type;

public enum PersonalRelationshipType implements BaseEnum{
	child("relationship_child"),
	spouse("relationship_spouse"),
	stepchild("relationship_stepchild"),
	friend("relationship_friend"),
	grandchild("relationship_grandchild"),
	otherRelative("relationship_other_relative"),
	stepparent("relationship_stepparent"),
	coworker("relationship_coworker"),
	partner("relationship_partner"),
	grandparent("relationship_grandparent"),
	parent("relationship_parent"),
	other("relationship_other"),
	medicalPoa("relationship_medical_poa"),
	attorney("relationship_attorney"),
	sibling("relationship_sibling"),
	;
	private final String key;
	private PersonalRelationshipType(String key) {
		this.key = key;
	}
	@Override
	public String getKey() {
		return this.key;
	}
}
