package mods.nordwest.client.renders;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BlockExtractorRenderer extends RenderBlocks implements ISimpleBlockRenderingHandler {
	float w1 = 0.3120f;
	float w2 = 0.5620f;
	float w3 = 0.225f;
	float w4 = w2 - w3;

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		drawFaces(renderer, block, true);

		block.setBlockBounds(0, 0.0F, 0, w1, w2, w1);
		renderer.setRenderBoundsFromBlock(block);
		drawFaces(renderer, block, true);
		block.setBlockBounds(1 - w1, 0.0F, 0, 1f, w2, w1);
		renderer.setRenderBoundsFromBlock(block);
		drawFaces(renderer, block, true);
		block.setBlockBounds(0, 0.0F, 1 - w1, w1, w2, 1);
		renderer.setRenderBoundsFromBlock(block);
		drawFaces(renderer, block, true);
		block.setBlockBounds(1 - w1, 0.0F, 1 - w1, 1f, w2, 1f);
		renderer.setRenderBoundsFromBlock(block);
		drawFaces(renderer, block, true);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		Icon icon = renderer.getBlockIconFromSide(Block.waterStill, 0);
		Tessellator tessellator = Tessellator.instance;

		double minX = (double) icon.getInterpolatedU(0);
		double maxX = (double) icon.getInterpolatedU(16);
		double minZ = (double) icon.getInterpolatedV(0);
		double maxZ = (double) icon.getInterpolatedV(16);
		double w2_w3_maxZ = (double) icon.getInterpolatedV(16 * w4);
		float shift = 0.01f;
		tessellator.setColorOpaque(250, 250, 200);
		//liquid
		//tessellator.addTranslation(par1, par2, par3)
		//top
		tessellator.addVertexWithUV(x, y + w4, z, maxX, maxZ);
		tessellator.addVertexWithUV(x, y + w4, z + 1, maxX, minZ);
		tessellator.addVertexWithUV(x + 1, y + w4, z + 1, minX, minZ);
		tessellator.addVertexWithUV(x + 1, y + w4, z, minX, maxZ);
		//down
		tessellator.addVertexWithUV(x + 1, y + shift, z, maxX, maxZ);
		tessellator.addVertexWithUV(x + 1, y + shift, z + 1, maxX, minZ);
		tessellator.addVertexWithUV(x, y + shift, z + 1, minX, minZ);
		tessellator.addVertexWithUV(x, y + shift, z, minX, maxZ);
		// side 1
		tessellator.addVertexWithUV(x + shift, y, z + 1, maxX, w2_w3_maxZ);
		tessellator.addVertexWithUV(x + shift, y + w4, z + 1, maxX, minZ);
		tessellator.addVertexWithUV(x + shift, y + w4, z, minX, minZ);
		tessellator.addVertexWithUV(x + shift, y, z, minX, w2_w3_maxZ);
		//side 2
		tessellator.addVertexWithUV(x + 1, y, z + 1 - shift, maxX, w2_w3_maxZ);
		tessellator.addVertexWithUV(x + 1, y + w4, z + 1 - shift, maxX, minZ);
		tessellator.addVertexWithUV(x, y + w4, z + 1 - shift, minX, minZ);
		tessellator.addVertexWithUV(x, y, z + 1 - shift, minX, w2_w3_maxZ);
		// side 3
		tessellator.addVertexWithUV(x + 1 - shift, y, z, maxX, w2_w3_maxZ);
		tessellator.addVertexWithUV(x + 1 - shift, y + w4, z, maxX, minZ);
		tessellator.addVertexWithUV(x + 1 - shift, y + w4, z + 1, minX, minZ);
		tessellator.addVertexWithUV(x + 1 - shift, y, z + 1, minX, w2_w3_maxZ);
		//side 3
		tessellator.addVertexWithUV(x, y, z + shift, maxX, w2_w3_maxZ);
		tessellator.addVertexWithUV(x, y + w4, z + shift, maxX, minZ);
		tessellator.addVertexWithUV(x + 1, y + w4, z + shift, minX, minZ);
		tessellator.addVertexWithUV(x + 1, y, z + shift, minX, w2_w3_maxZ);

		// внутренние стенки
		icon = renderer.getBlockIconFromSide(Block.cobblestone, 0);
		minX = (double) icon.getInterpolatedU(0);
		maxX = (double) icon.getInterpolatedU(16);
		minZ = (double) icon.getInterpolatedV(0);
		maxZ = (double) icon.getInterpolatedV(16);
		w2_w3_maxZ = (double) icon.getInterpolatedV(16 * w2);
		float innershift = w1 + 2 * shift;
		tessellator.setColorOpaque(100, 100, 100);
		// inner side 1
		tessellator.addVertexWithUV(x + innershift, y + shift, z + 1, maxX, w2_w3_maxZ);
		tessellator.addVertexWithUV(x + innershift, y + w2, z + 1, maxX, minZ);
		tessellator.addVertexWithUV(x + innershift, y + w2, z, minX, minZ);
		tessellator.addVertexWithUV(x + innershift, y + shift, z, minX, w2_w3_maxZ);
		//inner side 2
		tessellator.addVertexWithUV(x + 1, y + shift, z + 1 - innershift, maxX, w2_w3_maxZ);
		tessellator.addVertexWithUV(x + 1, y + w2, z + 1 - innershift, maxX, minZ);
		tessellator.addVertexWithUV(x, y + w2, z + 1 - innershift, minX, minZ);
		tessellator.addVertexWithUV(x, y + shift, z + 1 - innershift, minX, w2_w3_maxZ);
		// inner  side 1
		tessellator.addVertexWithUV(x + 1 - innershift, y + shift, z, maxX, w2_w3_maxZ);
		tessellator.addVertexWithUV(x + 1 - innershift, y + w2, z, maxX, minZ);
		tessellator.addVertexWithUV(x + 1 - innershift, y + w2, z + 1, minX, minZ);
		tessellator.addVertexWithUV(x + 1 - innershift, y + shift, z + 1, minX, w2_w3_maxZ);
		// inner side 2
		tessellator.addVertexWithUV(x, y + shift, z + innershift, maxX, w2_w3_maxZ);
		tessellator.addVertexWithUV(x, y + shift + w2, z + innershift, maxX, minZ);
		tessellator.addVertexWithUV(x + 1, y + w2, z + innershift, minX, minZ);
		tessellator.addVertexWithUV(x + 1, y, z + innershift, minX, w2_w3_maxZ);
		//inner top
		tessellator.addVertexWithUV(x, y + w2, z + 1, maxX, maxZ);
		tessellator.addVertexWithUV(x, y + w2, z, maxX, minZ);
		tessellator.addVertexWithUV(x + 1, y + w2, z, minX, minZ);
		tessellator.addVertexWithUV(x + 1, y + w2, z + 1, minX, maxZ);
		
		block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
		return true;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return mods.nordwest.common.Config.ExtractorRendererID;
	}

	public void drawFaces(RenderBlocks renderblocks, Block block, boolean solidtop) {
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		renderblocks.renderBottomFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 0));
		tessellator.draw();
		if (solidtop)
			GL11.glDisable(3008);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderblocks.renderTopFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 1));
		tessellator.draw();
		if (solidtop)
			GL11.glEnable(3008);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderblocks.renderEastFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 2));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		renderblocks.renderWestFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 3));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderblocks.renderNorthFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 4));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		renderblocks.renderSouthFace(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSide(block, 5));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
}
