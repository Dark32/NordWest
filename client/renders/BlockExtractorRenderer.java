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
	float w6 = 0.874f;
	private Block block;

	@Override
	public void renderInventoryBlock(Block _block, int metadata, int modelID, RenderBlocks renderer) {
		if (metadata == 0) {// Экстрактор
			_block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true);
			_block.setBlockBounds(0, 0.0F, 0, w1, w2, w1);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true);
			_block.setBlockBounds(1 - w1, 0.0F, 0, 1f, w2, w1);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true);
			_block.setBlockBounds(0, 0.0F, 1 - w1, w1, w2, 1);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true);
			_block.setBlockBounds(1 - w1, 0.0F, 1 - w1, 1f, w2, 1f);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, _block, true);
		} else if (metadata == 1) {
			_block.setBlockBounds(0, 0.0F, 0, 1.0F, w5, 1.0F);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, Block.furnaceIdle, true);

			_block.setBlockBounds(0.0f, w5 - 0.0001f, 0.0f, 1.0F, w6 + 0.0001f, 1.0F);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, Block.glass, true);

			_block.setBlockBounds(w1, w1, w1, 1.0F - w1, 0.99F, 1.0F - w1);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, Block.blockIron, true);

			_block.setBlockBounds(0.0f, w6, 0.0f, 1.0F, 1.0F, 1.0F);
			renderer.setRenderBoundsFromBlock(_block);
			drawFaces(renderer, Block.stone, true);

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
		}
		block.setBlockBounds(0, 0.0F, 0, 1.0F, 1.0F, 1.0F);
		return true;
	}

	private void renderDistiller(int x, int y, int z, Block _block, RenderBlocks renderer, Tessellator tessellator) {

		Icon iconTop = renderer.getBlockIconFromSide(Block.furnaceIdle, 0);
		Icon iconSide = renderer.getBlockIconFromSideAndMetadata(Block.furnaceIdle, 2, 2);
		Icon iconStill = renderer.getBlockIconFromSideAndMetadata(Block.waterMoving, 0, 0);
		double topMinX = (double) iconTop.getInterpolatedU(0);
		double topMaxX = (double) iconTop.getInterpolatedU(16);
		double topMinZ = (double) iconTop.getInterpolatedV(0);
		double topMaxZ = (double) iconTop.getInterpolatedV(16);

		double sideMinX = (double) iconSide.getInterpolatedU(0);
		double sideMaxX = (double) iconSide.getInterpolatedU(16);
		double sideMinZ = (double) iconSide.getInterpolatedV(16 * (1 - w5));
		double sideMaxZ = (double) iconSide.getInterpolatedV(16);

		double stillMinX = (double) iconStill.getInterpolatedU(0);
		double stillMaxX = (double) iconStill.getInterpolatedU(16);
		double stillMinZ = (double) iconStill.getInterpolatedV(16 * w5);
		double stillMaxZ = (double) iconStill.getInterpolatedV(16 * w6);

		tessellator.setColorOpaque(250, 250, 250);
		//top
		tessellator.addVertexWithUV(x, y + w5, z, topMaxX, topMaxZ);
		tessellator.addVertexWithUV(x, y + w5, z + 1, topMaxX, topMinZ);
		tessellator.addVertexWithUV(x + 1, y + w5, z + 1, topMinX, topMinZ);
		tessellator.addVertexWithUV(x + 1, y + w5, z, topMinX, topMaxZ);
		//down
		tessellator.addVertexWithUV(x + 1, y, z, topMaxX, topMaxZ);
		tessellator.addVertexWithUV(x + 1, y, z + 1, topMaxX, topMinZ);
		tessellator.addVertexWithUV(x, y, z + 1, topMinX, topMinZ);
		tessellator.addVertexWithUV(x, y, z, topMinX, topMaxZ);
		//down

		// side 1
		tessellator.addVertexWithUV(x, y, z + 1, sideMaxX, sideMaxZ);
		tessellator.addVertexWithUV(x, y + w5, z + 1, sideMaxX, sideMinZ);
		tessellator.addVertexWithUV(x, y + w5, z, sideMinX, sideMinZ);
		tessellator.addVertexWithUV(x, y, z, sideMinX, sideMaxZ);
		//side 2
		tessellator.addVertexWithUV(x + 1, y, z + 1, sideMaxX, sideMaxZ);
		tessellator.addVertexWithUV(x + 1, y + w5, z + 1, sideMaxX, sideMinZ);
		tessellator.addVertexWithUV(x, y + w5, z + 1, sideMinX, sideMinZ);
		tessellator.addVertexWithUV(x, y, z + 1, sideMinX, sideMaxZ);
		// side 3
		tessellator.addVertexWithUV(x + 1, y, z, sideMaxX, sideMaxZ);
		tessellator.addVertexWithUV(x + 1, y + w5, z, sideMaxX, sideMinZ);
		tessellator.addVertexWithUV(x + 1, y + w5, z + 1, sideMinX, sideMinZ);
		tessellator.addVertexWithUV(x + 1, y, z + 1, sideMinX, sideMaxZ);
		//side 4
		tessellator.addVertexWithUV(x, y, z, sideMaxX, sideMaxZ);
		tessellator.addVertexWithUV(x, y + w5, z, sideMaxX, sideMinZ);
		tessellator.addVertexWithUV(x + 1, y + w5, z, sideMinX, sideMinZ);
		tessellator.addVertexWithUV(x + 1, y, z, sideMinX, sideMaxZ);

		//top glass
		_block.setBlockBounds(0.0f, w5 - 0.0001f, 0.0f, 1.0F, w6 + 0.0001f, 1.0F);
		renderer.setRenderBoundsFromBlock(_block);
		renderer.renderStandardBlock(Block.glass, x, y, z);

		_block.setBlockBounds(w1, w1, w1, 1.0F - w1, 0.99F, 1.0F - w1);
		renderer.setRenderBoundsFromBlock(_block);
		renderer.renderStandardBlock(Block.blockIron, x, y, z);

		_block.setBlockBounds(0.0f, w6, 0.0f, 1.0F, 1.0F, 1.0F);
		renderer.setRenderBoundsFromBlock(_block);
		renderer.renderStandardBlock(Block.stone, x, y, z);
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
		//tessellator.setColorOpaque(250, 250, 200);
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

		// внутренние стенки
		icon = renderer.getBlockIconFromSide(Block.cobblestone, 0);
		minX = (double) icon.getInterpolatedU(0);
		maxX = (double) icon.getInterpolatedU(16);
		minZ = (double) icon.getInterpolatedV(0);
		maxZ = (double) icon.getInterpolatedV(16);
		w2_w3_maxZ = (double) icon.getInterpolatedV(16 * w2);
		float innershift = w1 + 2 * shift;
		//tessellator.setColorOpaque(100, 100, 100);
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
