package com.gizmo.unusedassets.util.fabric;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.system.MemoryStack;

import com.mojang.blaze3d.matrix.MatrixStack;

import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.vector.Vector4f;


public interface VertexConsumer {
	   Logger LOGGER = LogManager.getLogger();

	   VertexConsumer vertex(double x, double y, double z);

	   VertexConsumer color(int red, int green, int blue, int alpha);

	   VertexConsumer texture(float u, float v);

	   VertexConsumer overlay(int u, int v);

	   VertexConsumer light(int u, int v);

	   VertexConsumer normal(float x, float y, float z);

	   void next();

	   default void vertex(float x, float y, float z, float red, float green, float blue, float alpha, float u, float v, int overlay, int light, float normalX, float normalY, float normalZ) {
	      this.vertex((double)x, (double)y, (double)z);
	      this.color(red, green, blue, alpha);
	      this.texture(u, v);
	      this.overlay(overlay);
	      this.light(light);
	      this.normal(normalX, normalY, normalZ);
	      this.next();
	   }

	   default VertexConsumer color(float red, float green, float blue, float alpha) {
	      return this.color((int)(red * 255.0F), (int)(green * 255.0F), (int)(blue * 255.0F), (int)(alpha * 255.0F));
	   }

	   default VertexConsumer light(int uv) {
	      return this.light(uv & '\uffff', uv >> 16 & '\uffff');
	   }

	   default VertexConsumer overlay(int uv) {
	      return this.overlay(uv & '\uffff', uv >> 16 & '\uffff');
	   }

	   default void quad(MatrixStack.Entry matrixEntry, BakedQuad quad, float red, float green, float blue, int light, int overlay) {
	      this.quad(matrixEntry, quad, new float[]{1.0F, 1.0F, 1.0F, 1.0F}, red, green, blue, new int[]{light, light, light, light}, overlay, false);
	   }

	   default void quad(MatrixStack.Entry matrixEntry, BakedQuad quad, float[] brightnesses, float red, float green, float blue, int[] lights, int overlay, boolean useQuadColorData) {
	      int[] is = quad.getVertexData();
	      Vector3i vec3i = quad.getFace().getDirectionVec();
	      Vector3f vector3f = new Vector3f((float)vec3i.getX(), (float)vec3i.getY(), (float)vec3i.getZ());
	      Matrix4f matrix4f = matrixEntry.getMatrix();
	      vector3f.transform(matrixEntry.getNormal());
	      boolean i = true;
	      int j = is.length / 8;
	      MemoryStack memoryStack = MemoryStack.stackPush();
	      Throwable var17 = null;

	   }

	   default VertexConsumer vertex(Matrix4f matrix, float x, float y, float z) {
	      Vector4f vector4f = new Vector4f(x, y, z, 1.0F);
	      vector4f.transform(matrix);
	      return this.vertex((double)vector4f.getX(), (double)vector4f.getY(), (double)vector4f.getZ());
	   }

	   default VertexConsumer normal(Matrix3f matrix, float x, float y, float z) {
	      Vector3f vector3f = new Vector3f(x, y, z);
	      vector3f.transform(matrix);
	      return this.normal(vector3f.getX(), vector3f.getY(), vector3f.getZ());
	   }
	}