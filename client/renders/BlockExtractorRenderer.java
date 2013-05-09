package mods.nordwest.client.renders;

import org.lwjgl.opengl.GL11;

import mods.nordwest.common.CustomBlocks;
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
	float w3 = 0.2250f;
	float w4 = w2 - w3;
	float w5 = 0.3740f;
	float w6 = 0.875f;
	float w7 = 0.0625f;
	float w8 = 0.4375f;
	private Block block;

	@Override
	public void renderInventoryBlock(Block _block, int metadata, int modelID, RenderBlocks renderer) {
		if (metadata == 0) {// Экстрактор
			_block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true, 0);
			_block.setBlockBounds(0, 0.0F, 0, w1, w2, w1);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true, 0);
			_block.setBlockBounds(1 - w1, 0.0F, 0, 1f, w2, w1);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true, 0);
			_block.setBlockBounds(0, 0.0F, 1 - w1, w1, w2, 1);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true, 0);
			_block.setBlockBounds(1 - w1, 0.0F, 1 - w1, 1f, w2, 1f);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true, 0);
		} else if (metadata == 1) {
			_block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0f, 1.0F);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true, 1);

			//_block.setBlockBounds(0.0f, w5 - 0.0001f, 0.0f, 1.0F, w6 + 0.0001f, 1.0F);
			//renderer.setRenderBoundsFromBlock(_block);
			//drawFaces(renderer, Block.glass, true);

			_block.setBlockBounds(w1, w1, w1, 1.0F - w1, 0.99F, 1.0F - w1);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, Block.blockIron, true, 0);

			_block.setBlockBounds(0.0f, w5, 0.0f, 1.0F, w5 + 0.01f, 1.0F);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, Block.stone, true, 0);

		} else if (metadata == 2) {
			_block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0f, 1.0F);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true, 2);

		} else if (metadata == 3) {
			for (int k = 0; k < 5; k++) {
				switch (k) {
				case 0: {
					renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
					break;
				}
				case 1: {
					renderer.setRenderBounds(0.0F, 0.25F, 0.0F, 0.125F, 1.0F, 1.0F);
					break;
				}
				case 2: {
					renderer.setRenderBounds(0.875F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
					break;
				}
				case 3: {
					renderer.setRenderBounds(0.125F, 0.25F, 0.0F, 0.875F, 1.0F, 0.125F);
					break;
				}
				case 4: {
					renderer.setRenderBounds(0.125F, 0.25F, 0.875F, 0.875F, 1.0F, 1.0F);
					break;
				}
				}
				/*
				 * if (k == 0) { renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F); } if (k == 1) { renderer.setRenderBounds(0.0F, 0.25F, 0.0F, 0.125F, 1.0F, 1.0F); } if (k == 2) { renderer.setRenderBounds(0.875F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F); } if (k == 3) { renderer.setRenderBounds(0.125F, 0.25F, 0.0F, 0.875F, 1.0F, 0.125F); } if (k == 4) { renderer.setRenderBounds(0.125F, 0.25F, 0.875F, 0.875F, 1.0F, 1.0F); }
				 */

				drawFaces(renderer, _block, true, 3);
			}

		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		int meta = world.getBlockMetadata(x, y, z);
		Tessellator tessellator = Tessellator.instance;
		if (meta == 0) {
			renderExtractor(x, y, z, block, renderer, tessellator);
		} else if (meta == 1) {
			renderDistiller(x, y, z, block, renderer, tessellator);
		} else if (meta == 2) {
			renderCooler(x, y, z, block, renderer, tessellator);
		} else if (meta == 3) {
			renderGyle(x, y, z, block, renderer, tessellator);
		}
		block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
		return true;
	}

	private void renderGyle(int i, int j, int k, Block _block, RenderBlocks renderer, Tessellator tessellator) {

		tessellator.draw();
		tessellator.startDrawingQuads();

		float f = 5;
		renderer.setOverrideBlockTexture(Block.blocksList[5].getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.25F, 1.0F);
		renderer.renderStandardBlock(_block, i, j, k);
		renderer.setRenderBounds(0.0F, 0.25F, 0.0F, 0.125F, 1.0F, 1.0F);
		renderer.renderStandardBlock(_block, i, j, k);
		renderer.setRenderBounds(0.875F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.renderStandardBlock(_block, i, j, k);
		renderer.setRenderBounds(0.125F, 0.25F, 0.0F, 0.875F, 1.0F, 0.125F);
		renderer.renderStandardBlock(_block, i, j, k);
		renderer.setRenderBounds(0.125F, 0.25F, 0.875F, 0.875F, 1.0F, 1.0F);
		renderer.renderStandardBlock(_block, i, j, k);
		renderer.setRenderBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		renderer.setOverrideBlockTexture(_block.getIcon(6, 3));
		tessellator.draw();
		tessellator.startDrawingQuads();
		renderer.setRenderBounds(0.125F, 0.24F, 0.125F, 0.875F, 0.24F + 0.125F * f, 0.875F);
		renderer.renderFaceYPos(_block, i,j, k, renderer.getBlockIconFromSideAndMetadata(_block, 6, 3));
		renderer.clearOverrideBlockTexture();
		
	}

	private void renderCooler(int x, int y, int z, Block block2, RenderBlocks renderer, Tessellator tessellator) {
		Icon iconTop = renderer.getBlockIconFromSide(Block.furnaceIdle, 0);
		double topMinX = (double) iconTop.getInterpolatedU(0);
		double topMaxX = (double) iconTop.getInterpolatedU(16);
		double topMinZ = (double) iconTop.getInterpolatedV(0);
		double topMaxZ = (double) iconTop.getInterpolatedV(16);
		tessellator.setColorOpaque(250, 250, 250);
		//top
		tessellator.addVertexWithUV(x, y + w7, z, topMaxX, topMaxZ);
		tessellator.addVertexWithUV(x, y + w7, z + 1, topMaxX, topMinZ);
		tessellator.addVertexWithUV(x + 1, y + w7, z + 1, topMinX, topMinZ);
		tessellator.addVertexWithUV(x + 1, y + w7, z, topMinX, topMaxZ);
		//down
		tessellator.addVertexWithUV(x + 1, y + w2 + 0.01f, z, topMaxX, topMaxZ);
		tessellator.addVertexWithUV(x + 1, y + w2 + 0.01f, z + 1, topMaxX, topMinZ);
		tessellator.addVertexWithUV(x, y + w2 + 0.01f, z + 1, topMinX, topMinZ);
		tessellator.addVertexWithUV(x, y + w2 + 0.01f, z, topMinX, topMaxZ);

		block2.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0F, 1.00F, 1.0F);
		renderer.setRenderBoundsFromBlock(block2);
		renderer.renderStandardBlock(block2, x, y, z);

		block2.setBlockBounds(w1, w7, w1, 1.0F - w1, w2, 1.0F - w1);
		renderer.setRenderBoundsFromBlock(block2);
		renderer.renderStandardBlock(Block.blockIron, x, y, z);

		
		//tessellator.setColorRGBA(255, 255, 255, 000);
		//GL11.glEnable(GL11.GL_BLEND);
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		block2.setBlockBounds(0.01f, w7+0.01f, 0.01f, 0.99F, w2, 0.99F);
		renderer.setRenderBoundsFromBlock(block2);
		renderer.renderStandardBlock(Block.waterStill, x, y, z);
		//GL11.glDisable(GL11.GL_BLEND); 

	}

	private void renderDistiller(int x, int y, int z, Block _block, RenderBlocks renderer, Tessellator tessellator) {

		Icon iconTop = renderer.getBlockIconFromSide(Block.furnaceIdle, 0);
		double topMinX = (double) iconTop.getInterpolatedU(0);
		double topMaxX = (double) iconTop.getInterpolatedU(16);
		double topMinZ = (double) iconTop.getInterpolatedV(0);
		double topMaxZ = (double) iconTop.getInterpolatedV(16);
		tessellator.setColorOpaque(250, 250, 250);
		//top
		tessellator.addVertexWithUV(x, y + w5, z, topMaxX, topMaxZ);
		tessellator.addVertexWithUV(x, y + w5, z + 1, topMaxX, topMinZ);
		tessellator.addVertexWithUV(x + 1, y + w5, z + 1, topMinX, topMinZ);
		tessellator.addVertexWithUV(x + 1, y + w5, z, topMinX, topMaxZ);
		//down
		tessellator.addVertexWithUV(x + 1, y + w6 + 0.01f, z, topMaxX, topMaxZ);
		tessellator.addVertexWithUV(x + 1, y + w6 + 0.01f, z + 1, topMaxX, topMinZ);
		tessellator.addVertexWithUV(x, y + w6 + 0.01f, z + 1, topMinX, topMinZ);
		tessellator.addVertexWithUV(x, y + w6 + 0.01f, z, topMinX, topMaxZ);

		_block.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0F, 1.00F, 1.0F);
		renderer.setRenderBoundsFromBlock(_block);
		renderer.renderStandardBlock(_block, x, y, z);
		_block.setBlockBounds(w1, w1, w1, 1.0F - w1, 0.99F, 1.0F - w1);
		renderer.setRenderBoundsFromBlock(_block);
		renderer.renderStandardBlock(Block.blockIron, x, y, z);
	}

	private void renderExtractor(int x, int y, int z, Block block, RenderBlocks renderer, Tessellator tessellator) {
		block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(block);
		renderer.renderStandardBlock(block, x, y, z);
		Icon icon = renderer.getBlockIconFromSide(Block.waterStill, 0);

		double minX = (double) icon.getInterpolatedU(0);
		double maxX = (double) icon.getInterpolatedU(16);
		double minZ = (double) icon.getInterpolatedV(0);
		double maxZ = (double) icon.getInterpolatedV(16);
		double w2_w3_maxZ = (double) icon.getInterpolatedV(16 * w4);
		float shift = 0.01f;
		tessellator.setColorRGBA(100, 100, 100, 255);

		// внутренние стенки
		Icon iconInnerSise = renderer.getBlockIconFromSide(Block.cobblestone, 0);
		double innerSideMinX = (double) iconInnerSise.getInterpolatedU(0);
		double innerSideMaxX = (double) iconInnerSise.getInterpolatedU(16);
		double innerSideMinZ = (double) iconInnerSise.getInterpolatedV(0);
		double innerSideMaxZ = (double) iconInnerSise.getInterpolatedV(16);
		double innerSide_w2_w3_maxZ = (double) icon.getInterpolatedV(16 * w2);
		float innershift = w1 + 2 * shift;
		tessellator.setColorRGBA(100, 100, 100, 255);
		// inner side 1
		tessellator.addVertexWithUV(x + innershift, y + shift, z + 1, innerSideMaxX, innerSide_w2_w3_maxZ);
		tessellator.addVertexWithUV(x + innershift, y + w2, z + 1, innerSideMaxX, innerSideMinZ);
		tessellator.addVertexWithUV(x + innershift, y + w2, z, innerSideMinX, innerSideMinZ);
		tessellator.addVertexWithUV(x + innershift, y + shift, z, innerSideMinX, innerSide_w2_w3_maxZ);
		//inner side 2
		tessellator.addVertexWithUV(x + 1, y + shift, z + 1 - innershift, innerSideMaxX, innerSide_w2_w3_maxZ);
		tessellator.addVertexWithUV(x + 1, y + w2, z + 1 - innershift, innerSideMaxX, innerSideMinZ);
		tessellator.addVertexWithUV(x, y + w2, z + 1 - innershift, innerSideMinX, innerSideMinZ);
		tessellator.addVertexWithUV(x, y + shift, z + 1 - innershift, innerSideMinX, innerSide_w2_w3_maxZ);
		// inner  side 1
		tessellator.addVertexWithUV(x + 1 - innershift, y + shift, z, innerSideMaxX, innerSide_w2_w3_maxZ);
		tessellator.addVertexWithUV(x + 1 - innershift, y + w2, z, innerSideMaxX, innerSideMinZ);
		tessellator.addVertexWithUV(x + 1 - innershift, y + w2, z + 1, innerSideMinX, innerSideMinZ);
		tessellator.addVertexWithUV(x + 1 - innershift, y + shift, z + 1, innerSideMinX, innerSide_w2_w3_maxZ);
		// inner side 2
		tessellator.addVertexWithUV(x, y + shift, z + innershift, innerSideMaxX, innerSide_w2_w3_maxZ);
		tessellator.addVertexWithUV(x, y + shift + w2, z + innershift, innerSideMaxX, innerSideMinZ);
		tessellator.addVertexWithUV(x + 1, y + w2, z + innershift, innerSideMinX, innerSideMinZ);
		tessellator.addVertexWithUV(x + 1, y, z + innershift, innerSideMinX, innerSide_w2_w3_maxZ);
		//inner top
		tessellator.addVertexWithUV(x, y + w2, z + 1, innerSideMaxX, innerSideMaxZ);
		tessellator.addVertexWithUV(x, y + w2, z, innerSideMaxX, innerSideMinZ);
		tessellator.addVertexWithUV(x + 1, y + w2, z, innerSideMinX, innerSideMinZ);
		tessellator.addVertexWithUV(x + 1, y + w2, z + 1, innerSideMinX, innerSideMaxZ);

		//liquid
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

	public void drawFaces(RenderBlocks renderblocks, Block block, boolean solidtop, int meta) {
		Tessellator tessellator = Tessellator.instance;
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, -1.0F, 0.0F);
		renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 0, meta));
		tessellator.draw();
		if (solidtop)
			GL11.glDisable(3008);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 1, meta));
		tessellator.draw();
		if (solidtop)
			GL11.glEnable(3008);
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, 1.0F);
		renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 2, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0.0F, 0.0F, -1.0F);
		renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 3, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(1.0F, 0.0F, 0.0F);
		renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 4, meta));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1.0F, 0.0F, 0.0F);
		renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderblocks.getBlockIconFromSideAndMetadata(block, 5, meta));
		tessellator.draw();
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}
}
