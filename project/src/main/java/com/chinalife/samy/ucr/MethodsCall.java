package com.chinalife.samy.ucr;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class MethodsCall implements ClassFileTransformer {

	@Override
	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {
		// TODO Auto-generated method stub
		ClassReader cr = new ClassReader(classfileBuffer);
		ClassNode cn = new ClassNode();
		cr.accept(cn, 0);
		for (Object obj : cn.methods) {
			MethodNode mn = (MethodNode) obj;
			// Precluding the constructed methods
			if ("<init>".endsWith(mn.name) || "<clinit>".equals(mn.name)) {
				continue;
			}

			InsnList insns = mn.instructions;
			InsnList il = new InsnList();
			// Add the standard output
			il.add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out",
					"Ljava/io/PrintStream;"));
			// Add output string: Class.Method
			il.add(new LdcInsnNode("Call Function: " + cn.name + "." + mn.name));
			// Invoke
			il.add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream",
					"println", "(Ljava/lang/String;)V", false));
			insns.insert(il);
			mn.maxStack += 3;
		}

		ClassWriter cw = new ClassWriter(0);
		cn.accept(cw);
		return cw.toByteArray();
	}

}
