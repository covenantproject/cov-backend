package org.covn.support;

public interface QuadFunction<IN1, IN2, IN3, IN4, OUT> {
	
	OUT exec(IN1 in1, IN2 in2, IN3 in3, IN4 in4);

}
