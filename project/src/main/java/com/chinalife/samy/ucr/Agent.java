package com.chinalife.samy.ucr;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 *
 */
public class Agent {
	public static void premain(String args, Instrumentation inst) {
		inst.addTransformer(new MethodsCall());
	}
}
