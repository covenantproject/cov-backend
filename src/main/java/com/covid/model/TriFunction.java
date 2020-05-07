package com.covid.model;


@FunctionalInterface
public interface TriFunction<IN1, IN2, IN3, OUT> {
	
	OUT exec(IN1 in1, IN2 in2, IN3 in3);
}
